package service;

import pojo.Order;
import pojo.OrderCar;

import java.util.List;

public interface WaiterService {
    public List<Order> getOrdersByWid(int wId);   //获取wId对应的订单
    public List<OrderCar> getMenusByOid(int oId);      //根据订单号获取菜单
}
