package service;

import org.springframework.ui.Model;
import pojo.*;

import java.util.List;

public interface ClientService {
    public List<MenuClass> getMenuClass();
    public List<Menu> getMenusByClass(int mclass);
    public String clientAddMenu(int mclass, Model model);
    public List<Menu> getAllMenus();
    public Menu getMenuNmeAPrice(int mId);    //获取mId对应的菜名和售价
    public int getMenuAmot(int mId);    //获取mId菜单的库存
    public int getMaxOid();      //获取最大Oid值
    public List<Integer> getWaitersOnline();      //获取在线服务员的wId
    public int generateOrder(Order order);      //生成订单，插入tb_order
    public int generateOrderedMenu(OrderedMenu orderedMenu);    //生成已点菜单，插入tb_orderedMenu
    public String getClientNameByCid(int cId);   //通过cId获取客户名
    public Order getCurrentOrder(int cId);     //获取客户当前(即未完成)的订单
    public List<OrderCar> getMenusByOid(int oId);      //根据订单号获取菜单
    public int updateMenuAmot(Menu menu);      //更新菜的库存
}
