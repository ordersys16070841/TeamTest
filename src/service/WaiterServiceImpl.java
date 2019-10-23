package service;

import dao.WaiterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Order;
import pojo.OrderCar;

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

}
