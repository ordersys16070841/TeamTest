package service;

import dao.WaiterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Order;
import pojo.OrderCar;
import pojo.OrderedMenu;

import java.util.List;

@Service
@Transactional
public class WaiterServiceImpl implements WaiterService {
    @Autowired
    private WaiterDao waiterDao;


    /***************************打开服务员页面 start***************************************************/

    //获取wId对应的订单
    public List<Order> getOrdersByWid(int wId){
        return waiterDao.getOrdersByWid(wId);
    }

    /***************************打开服务员页面 end***************************************************/



    /***************************订单详情 start***************************************************/

    //根据订单号获取菜单
    public List<OrderCar> getMenusByOid(int oId){
        return waiterDao.getMenusByOid(oId);
    }

    /***************************订单详情 end***************************************************/



    /***************************上菜 start***************************************************/

    //上菜，更新tb_orderedmenu表的deliver
    public int servedishes(OrderedMenu orderedMenu){
        return waiterDao.servedishes(orderedMenu);
    }

    //查看tb_orderedmenu表中oId对应的未上菜的数量
    public int checkOrderedMenu(int oId){
        return waiterDao.checkOrderedMenu(oId);
    }

    //更新订单的状态
    public int updateOrderStatus(int oId){
        return waiterDao.updateOrderStatus(oId);
    }


    /***************************上菜 end***************************************************/


    /***************************查看我处理的订单 start***************************************************/

    //查看wId员工处理的历史订单
    public List<Order> checkOrders(int wId){
        return waiterDao.checkOrders(wId);
    }

    /***************************查看我处理的订单 end***************************************************/

}
