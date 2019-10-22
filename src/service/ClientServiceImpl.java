package service;

import dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import pojo.Menu;
import pojo.MenuClass;
import pojo.Order;
import pojo.OrderedMenu;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    /***************************客户主页 start***************************************************/

    public List<MenuClass> getMenuClass(){
        return clientDao.getMenuClass();
    }

    public List<Menu> getMenusByClass(int mclass){
        return clientDao.getMenusByClass(mclass);
    }

    public List<Menu> getAllMenus() {
        return clientDao.getAllMenus();
    }

    //通过cId获取客户名
    public String getClientNameByCid(int cId){
        return clientDao.getClientNameByCid(cId);
    }

    /***************************客户主页 end***************************************************/

    public String clientAddMenu(int mclass,Model model){
        return "";
    }

    /***************************客户点菜 start***************************************************/

    public Menu getMenuNmeAPrice(int mId){
        return clientDao.getMenuNmeAPrice(mId);
    }

    public int getMenuAmot(int mId){
        return clientDao.getMenuAmot(mId);
    }

    /***************************客户点菜 end***************************************************/


    /***************************客户支付订单 start***************************************************/

    //获取最大Oid值
    public int getMaxOid(){
        return clientDao.getMaxOid();
    }

    //获取在线服务员的wId
    public List<Integer> getWaitersOnline(){
        return clientDao.getWaitersOnline();
    }

    //生成订单，插入tb_order
    public int generateOrder(Order order){
        return clientDao.generateOrder(order);
    }

    //生成已点菜单，插入tb_orderedMenu
    public int generateOrderedMenu(OrderedMenu orderedMenu){
        return clientDao.generateOrderedMenu(orderedMenu);
    }

    /***************************客户支付订单 end***************************************************/


    /***************************打开我的订单页面 start***************************************************/

    //获取客户当前(即未完成)的订单
    public Order getCurrentOrder(int cId){
        return clientDao.getCurrentOrder(cId);
    }

    //根据订单号获取菜单
    public List<OrderedMenu> getMenusByOid(int oId){
        return clientDao.getMenusByOid(oId);
    }

    /***************************打开我的订单页面 end***************************************************/

}
