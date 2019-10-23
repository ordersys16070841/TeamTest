package control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Order;
import pojo.OrderCar;
import service.WaiterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WaiterController {
    @Autowired
    private WaiterService waiterService;

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

    /***************************打开服务员页面 end***************************************************/


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
