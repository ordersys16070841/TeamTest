package control;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.*;
import service.AccountService;
import service.WaiterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class WaiterController {
    @Autowired
    private WaiterService waiterService;

    @Autowired
    private AccountService accountService;


    /***************************打开服务员页面 start***************************************************/

    /**
     * 打开服务员页面
     * @return
     */
    @RequestMapping("/toWaiterHome")
    public String toWaiterHome(HttpSession session, Model model){
        if(session.getAttribute("wId")==null){
            model.addAttribute("waiterhomeMsg","请先进行登录");
            return "waiter/waiterLogin";
        }
        int wId=(Integer) session.getAttribute("wId");
        List<Order> orderList=waiterService.getOrdersByWid(wId);
        model.addAttribute("orderList",orderList);
        return "waiter/waiterHome";
    }

    @RequestMapping(value = "/toWaiterHome.json", method = RequestMethod.POST)
    public void getWaiterHomeFromClient(HttpServletRequest request, HttpServletResponse response, Model model) {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;
        JSONObject json = new JSONObject();
        Waiter waiter = new Waiter();
        try {
            out = response.getWriter();
            if (!"".equals(request.getParameter("wacot")) && !"".equals(request.getParameter("wpsd"))) {

                String wacot = request.getParameter("wacot");
                String wpsd = request.getParameter("wpsd");
                waiter.setWacot(wacot);
                waiter.setWpsd(wpsd);
                System.out.println(wacot);
                System.out.println(wpsd);
                if (accountService.waiterLogin(waiter) > 0) {
                    waiter.setWstatus(2);
                    accountService.updateStatus(waiter);
                    waiter = accountService.getWaterInfo(waiter);
                    json.put("waiter", JSONObject.fromObject(waiter));
                    System.out.println(json);
                    List<Order> orderList = waiterService.getOrdersByWid(waiter.getWid());
                    JSONArray jsonArray = new JSONArray();
                    for (Order order :
                            orderList) {
                        JSONObject jsonOrder_Car = new JSONObject();
                        JSONObject jsonOrder = new JSONObject();
                        jsonOrder.put("order", JSONObject.fromObject(order));
                        List<OrderCar> orderCarList = waiterService.getMenusByOid(order.getoId());
                        jsonOrder.put("cars", orderCarList);
                        jsonOrder_Car.put("order_car", jsonOrder);
                        jsonArray.add(jsonOrder_Car);
                    }
                    json.put("orders", JSONArray.fromObject(jsonArray));
                } else {
                    json.put("orders", null);
                }

                out.write(json.toString());
                System.out.println(json.toString());

            } else {
                json.put("status", 0);
                json.put("waiter", null);
                out.write(json.toString());
            }
        } catch (Exception e) {
            e.toString();
            json.put("status", -1);
            json.put("waiter", null);
            out.write(json.toString());
        } finally {
            out.flush();
            out.close();
        }
    }
    /***************************打开服务员页面 end***************************************************/


    /***************************上菜 start***************************************************/

    @RequestMapping("/servedishes")
    public String servedishes(HttpServletRequest request, Model model){
        int oId=Integer.parseInt(request.getParameter("oId"));
        int mId=Integer.parseInt(request.getParameter("mId"));
        OrderedMenu orderedMenu=new OrderedMenu();
        orderedMenu.setoId(oId);
        orderedMenu.setmId(mId);
        waiterService.servedishes(orderedMenu);
        if(waiterService.checkOrderedMenu(oId)==0){
            waiterService.updateOrderStatus(oId);
        }
        List<OrderCar> orderCarList=waiterService.getMenusByOid(oId);
        model.addAttribute("orderCarList",orderCarList);
        model.addAttribute("oId",oId);
        return "waiter/orderInfo";
    }

    @RequestMapping(value = "/deliverDishes.json", method = RequestMethod.POST)
    public void serveDishesFromClient(HttpServletRequest request, HttpServletResponse response, Model model) {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;
        int oId = Integer.parseInt(request.getParameter("oId"));
        int mId = Integer.parseInt(request.getParameter("mId"));
        System.out.println("oId" + oId);
        System.out.println("mId" + mId);
        int status = 0;
        JSONObject jsonObject = new JSONObject();
        OrderedMenu orderedMenu = new OrderedMenu();
        orderedMenu.setoId(oId);
        orderedMenu.setmId(mId);
        waiterService.servedishes(orderedMenu);
        if (waiterService.checkOrderedMenu(oId) == 0) {
            waiterService.updateOrderStatus(oId);
            status = 1;
        } else {
            status = 1;
        }
        jsonObject.put("deliver", status);
        try {
            out = response.getWriter();
            out.write(jsonObject.toString());
            System.out.println("deiver"+jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    /***************************上菜 end***************************************************/

    /***************************订单详情 start***************************************************/

    @RequestMapping("/orderInfo")
    public String orderInfo(HttpServletRequest request, Model model){
        int oId=Integer.parseInt(request.getParameter("oId"));
        List<OrderCar> orderCarList=waiterService.getMenusByOid(oId);
        model.addAttribute("orderCarList",orderCarList);
        return "waiter/orderInfo";
    }

    /***************************订单详情 end***************************************************/


}
