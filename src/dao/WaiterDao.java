package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Client;
import pojo.Order;
import pojo.OrderCar;
import pojo.Waiter;

import java.util.List;

@Repository
@Mapper
public interface WaiterDao {
    /**
     * 检查服务员账号
     * @param waiter
     * @return
     */
    public int checkWaiterAcot(Waiter waiter);

    /**
     * 更新服务员状态
     * @param waiter
     * @return
     */
    public int updateStatus(Waiter waiter);

    /**
     * 检查服务员账号是否重复
     * @param waiter
     * @return
     */
    public int checkWaiterAcotRepeat(Waiter waiter);

    /**
     * 注册服务员账号
     * @param waiter
     * @return
     */
    public int registerWaiter(Waiter waiter);

    public List<Order> getOrdersByWid(int wId);   //获取wId对应的订单

    public Waiter getWaterInfo(Waiter waiter);    //通过账号获取员工信息

    public List<OrderCar> getMenusByOid(int oId);      //根据订单号获取菜单

}
