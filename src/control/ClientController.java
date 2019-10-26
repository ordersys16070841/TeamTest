package control;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.*;
import service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.*;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    /***************************客户主页 start***************************************************/

    /**
     * 客户主页
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/clienthome")
    public String clienthome(HttpServletRequest request,HttpSession session, Model model){
        int mclass;
        if(request.getParameter("mclass")==null){
            mclass=1;
        }else{
            mclass=Integer.parseInt(request.getParameter("mclass"));
        }
        List<MenuClass> menuClassList=clientService.getMenuClass();
        int size=menuClassList.size();
        model.addAttribute("menuClassList",menuClassList);
        model.addAttribute("size",size);
        List<Menu> menuList=clientService.getMenusByClass(mclass);
        model.addAttribute("menuList",menuList);
        if(session.getAttribute("cId")!=null){
            int cId=(Integer) session.getAttribute("cId");
            session.setAttribute("clientName",clientService.getClientNameByCid(cId));
        }
        return "client/clientHome";
    }

    @RequestMapping(value="/clienthome.json",method= RequestMethod.POST)
    public void getFromClient(HttpServletRequest request, HttpServletResponse response, Model model){
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;
        JSONObject json = new JSONObject();

        try {
            out = response.getWriter();
            List<Menu> menuList = clientService.getAllMenus();
            JSONArray jsonArray = JSONArray.fromObject(menuList);
            json.put("menus", jsonArray);
            System.out.println(json.toString());

            out.write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /***************************客户主页 end***************************************************/


    /***************************客户点菜 start***************************************************/

    /**
     * 客户点菜
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/clientAddMenu")
    public String clientAddMenu(HttpServletRequest request, Model model, HttpSession session){
        int mId=Integer.parseInt(request.getParameter("mId"));
        if(clientService.getMenuAmot(mId)==0){
            model.addAttribute("addMenuMsg","添加失败，库存不足");
            return "forward:clienthome";
        }
        List<OrderCar> orderCarList=(List<OrderCar>) session.getAttribute("orderCarList");
        Menu menu=clientService.getMenuNmeAPrice(mId);
        if(orderCarList==null){
            orderCarList=new ArrayList<OrderCar>();
            orderCarList.add(new OrderCar(mId,menu.getMname(),1,menu.getMprice()));
            session.setAttribute("orderCarList",orderCarList);
            model.addAttribute("addMenuMsg","添加成功");
            return "forward:clienthome";
        }else{
            Iterator<OrderCar> iterator=orderCarList.iterator();
            OrderCar orderCar;
            int index=0;
            while(iterator.hasNext()){
                orderCar=iterator.next();
                if(orderCar.getmId()==mId){
                    orderCar.setOmamot(orderCar.getOmamot()+1);
                    orderCarList.set(index,orderCar);
                    session.setAttribute("orderCarList",orderCarList);
                    model.addAttribute("addMenuMsg","添加成功");
                    return "forward:clienthome";
                }
                index++;
            }
            orderCarList.add(new OrderCar(mId,menu.getMname(),1,menu.getMprice()));
            session.setAttribute("orderCarList",orderCarList);
            model.addAttribute("addMenuMsg","添加成功");
            return "forward:clienthome";
        }
    }



    /***************************客户点菜 end***************************************************/


    /***************************打开订购车页面 start***************************************************/

    @RequestMapping("/toOrderCar")
    public String toOrderCar(HttpSession session,Model model){
        double totalPrice=0;
        List<OrderCar> orderCarList=(List<OrderCar>) session.getAttribute("orderCarList");
        if(orderCarList!=null){
            Iterator<OrderCar> iterator=orderCarList.iterator();
            OrderCar orderCar;
            while (iterator.hasNext()){
                orderCar=iterator.next();
                totalPrice=totalPrice+orderCar.getMprice()*orderCar.getOmamot();
            }
        }
        model.addAttribute("totalPrice",totalPrice);
        return "client/clientOrderMenu";
    }

    /***************************打开订购车页面 end***************************************************/



    /***************************移除订购车一个菜单 end***************************************************/

    @RequestMapping("/removeMenu")
    public String removeMenu(HttpServletRequest request,HttpSession session,Model model){
        int mId=Integer.parseInt(request.getParameter("mId"));
        List<OrderCar> orderCarList=(List<OrderCar>) session.getAttribute("orderCarList");
        Iterator<OrderCar> iterator=orderCarList.iterator();
        int index=0;
        OrderCar orderCar;
        while (iterator.hasNext()){
            orderCar=iterator.next();
            if(orderCar.getmId()==mId){
                orderCar.setOmamot(orderCar.getOmamot()-1);
                if(orderCar.getOmamot()==0){
                    orderCarList.remove(index);
                }else{
                    orderCarList.set(index,orderCar);
                }
                session.setAttribute("orderCarList",orderCarList);
                model.addAttribute("removeMenuMsg","移除菜单成功");
                return "forward:toOrderCar";
            }
            index++;
        }
        model.addAttribute("removeMenuMsg","移除菜单失败");
        return "forward:toOrderCar";
    }

    /***************************移除订购车一个菜单 end***************************************************/



    /***************************现金支付订单 start***************************************************/

    @RequestMapping("/cashpay")
    public String cashpay(HttpSession session,Model model,HttpServletRequest request){
        if(session.getAttribute("cId")==null){
            model.addAttribute("payMsg","支付订单失败，请登录账号");
            return "forward:toOrderCar";
        }
        if(request.getParameter("deskId")==""){
            model.addAttribute("payMsg","支付订单失败，请填写桌号");
            return "forward:toOrderCar";
        }
        int deskId=Integer.parseInt(request.getParameter("deskId"));
        List<OrderCar> orderCarList=(List<OrderCar>) session.getAttribute("orderCarList");

        int cId=(Integer) session.getAttribute("cId");      //设置订单Order  时间在sql语句中弄
        int oId=clientService.getMaxOid()+1;
        Order order=new Order();
        order.setoId(oId);
        order.setcId(cId);
        List<Integer> waiterList=clientService.getWaitersOnline();     //随机分配服务员
        Random random=new Random();
        int index=random.nextInt(waiterList.size());
        order.setwId(waiterList.get(index));
        order.setDeskId(deskId);
        double totalPrice=0;       //获取总价
        Iterator<OrderCar> iterator=orderCarList.iterator();
        OrderCar orderCar;
        while (iterator.hasNext()){
            orderCar=iterator.next();
            totalPrice=totalPrice+orderCar.getMprice()*orderCar.getOmamot();
        }
        order.setTotal(totalPrice);
        order.setPay(3);    //3表示现金支付
        order.setStatus(0);     //0表示未完成

        if(clientService.generateOrder(order)<=0){         //将Order插入数据库
            model.addAttribute("payMsg","生成订单失败");
            return "forward:toOrderCar";
        }else{
            iterator=orderCarList.iterator();      //生成已点菜单OrderedMenu，一边生成一边插入数据库
            while (iterator.hasNext()){
                orderCar=iterator.next();
                OrderedMenu orderedMenu=new OrderedMenu();
                orderedMenu.setoId(oId);
                orderedMenu.setmId(orderCar.getmId());
                orderedMenu.setOmamot(orderCar.getOmamot());
                orderedMenu.setDeliver(0);   //0表示未分配
                clientService.generateOrderedMenu(orderedMenu);   //将OrderedMenu插入数据库
            }
            model.addAttribute("payMsg","生成订单成功");
            session.removeAttribute("orderCarList");
            return "forward:toOrderCar";

        }
    }

    @RequestMapping(value = "/commitOrder.json", method = RequestMethod.POST)
    public void commitOrderFromClient(HttpServletRequest request, HttpServletResponse response, Model model) {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;
        JSONObject json = new JSONObject();
        JSONArray orderCarJson = JSONArray.fromObject(request.getParameter("orderCars"));
        OrderCar orderCars[] = (OrderCar[]) JSONArray.toArray(orderCarJson, OrderCar.class);
        OrderCar newOrderCar[] = new OrderCar[orderCars.length];


        int deskId = Integer.parseInt(request.getParameter("deskId"));
        int cId = Integer.parseInt(request.getParameter("cId"));
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
        int oId=clientService.getMaxOid()+1;
        Order order = new Order();
        order.setoId(oId);
        order.setcId(cId);
        order.setwId(1);
        order.setDeskId(deskId);
        order.setTotal(totalPrice);
        order.setPay(3);    //3表示现金支付
        order.setStatus(0);     //0表示未完成
        OrderCar orderCar;
        try {
            out = response.getWriter();
            if(clientService.generateOrder(order)<=0){         //将Order插入数据库
                json.put("status", 0);
                out.write(json.toString());
            }else{
                for (int i = 0; i < orderCars.length; i++) {
                    newOrderCar[i] = orderCars[i];
                    OrderedMenu orderedMenu=new OrderedMenu();
                    orderedMenu.setoId(oId);
                    orderedMenu.setmId(orderCars[i].getmId());
                    orderedMenu.setOmamot(orderCars[i].getOmamot());
                    orderedMenu.setDeliver(0);   //0表示未分配
                    clientService.generateOrderedMenu(orderedMenu);   //将OrderedMenu插入数据库
                }

                order = clientService.getOrderById(oId);
//            orderCarList;
                json.put("status", 1);
                json.put("order", JSONObject.fromObject(order));
                orderCarJson = JSONArray.fromObject(newOrderCar);
                json.put("orderCars", orderCarJson);
                out.write(json.toString());
                System.out.println(json.toString());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /***************************现金支付订单 end***************************************************/



    /***************************打开我的订单页面 start***************************************************/

    @RequestMapping("/toMyOrders")
    public String toMyOrders(HttpSession session,Model model){
        if(session.getAttribute("cId")==null){
            return "client/myOrder";
        }
        int cId=(Integer) session.getAttribute("cId");
        Order order=clientService.getCurrentOrder(cId);
        model.addAttribute("order",order);
        List<OrderCar> orderCarList=clientService.getMenusByOid(order.getoId());
        model.addAttribute("orderCarList",orderCarList);
        return "client/myOrder";
    }

    @RequestMapping(value = "/getAllOrdered.json", method = RequestMethod.POST)
    public void getAllOrdered(HttpServletRequest request, HttpServletResponse response, Model model) {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;
        int cId = Integer.parseInt(request.getParameter("cId"));
//        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<Order> orderList = clientService.getAllOrdersById(cId);
        for (Order o :
                orderList) {
            JSONObject order_car = new JSONObject();
            JSONObject orderObject = JSONObject.fromObject(o);
            List<OrderCar> orderCarList = clientService.getMenusByOid(o.getoId());
            JSONArray orderCarJSONArray = JSONArray.fromObject(orderCarList);
            order_car.put("order", orderObject);
            order_car.put("orderCars", orderCarJSONArray);
            jsonArray.add(order_car);
        }
        try {
            out = response.getWriter();
            out.write(jsonArray.toString());
            System.out.println("getAllOrdered:" + jsonArray.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /***************************打开我的订单页面 end***************************************************/

    @RequestMapping("/getOrder.json")
    public void getOrder(HttpServletRequest request, HttpServletResponse response, Model model){
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;
        JSONObject json = new JSONObject();

        try {
            out = response.getWriter();
            Order order = clientService.getOrderById(1);
            JSONObject jsonObject = JSONObject.fromObject(order);
            json.put("order", jsonObject);
            System.out.println(json.toString());

            out.write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

