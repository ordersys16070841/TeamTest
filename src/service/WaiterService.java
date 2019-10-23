package service;

import pojo.Order;
import pojo.OrderCar;
import pojo.OrderedMenu;

import java.util.List;

public interface WaiterService {
    public List<Order> getOrdersByWid(int wId);   //获取wId对应的订单
    public List<OrderCar> getMenusByOid(int oId);      //根据订单号获取菜单
    public int servedishes(OrderedMenu orderedMenu);     //上菜，更新tb_orderedmenu表的deliver
    public int checkOrderedMenu(int oId);    //查看tb_orderedmenu表中oId对应的未上菜的数量
    public int updateOrderStatus(int oId);     //更新订单的状态





}
