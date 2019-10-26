package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.*;

import java.util.List;

@Repository
@Mapper
public interface ClientDao {
    /**
     * 检查客户密码账号
     * @param client
     * @return
     */
    public int checkClientAcot(Client client);

    public Client getClientInfo(Client client);


    /**
     * 检查客户账号是否重复
     * @param client
     * @return
     */
    public int checkClientAcotRepeat(Client client);

    /**
     * 注册客户
     * @param client
     * @return
     */
    public int registerClient(Client client);

    /**
     * 获取菜单类别
     * @return
     */
    public List<MenuClass> getMenuClass();

    /**
     * 获取对应菜单类别的菜单
     * @param mclass
     * @return
     */
    public List<Menu> getMenusByClass(int mclass);

    /**
     *
     * @return
     */
    public int addMenuToOrder();

    public List<Menu> getAllMenus();

    public Menu getMenuNmeAPrice(int mId);

    public int getMenuAmot(int mId);    //获取mId菜单的库存

    public int getMaxOid();      //获取最大Oid值

    public int getCidByAcot(Client client);   //通过账号获取cId

    public List<Integer> getWaitersOnline();      //获取在线服务员的wId

    public int generateOrder(Order order);      //生成订单，插入tb_order

    public int generateOrderedMenu(OrderedMenu orderedMenu);    //生成已点菜单，插入tb_orderedMenu

    public String getClientNameByCid(int cId);   //通过cId获取客户名

    public Order getCurrentOrder(int cId);     //获取客户当前(即未完成)的订单



    Order getOrderById(int oid);
    public List<OrderCar> getMenusByOid(int oId);      //根据订单号获取菜单

    public List<Order> getAllOrdersById(int cId);


}
