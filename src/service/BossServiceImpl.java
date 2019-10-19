package service;


import dao.BossDao;
import dao.WaiterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import pojo.Boss;
import pojo.Menu;
import pojo.MenuClass;
import pojo.Waiter;

import java.util.List;


@Service
@Transactional
public class BossServiceImpl implements BossService {
    @Autowired
    private BossDao bossDao;


    /***************************认证员工 start***************************************************/

    public List<Waiter> getWaitersInfo(){
        return bossDao.getWaitersInfo();
    }

    public int authentiWaiter(Waiter waiter){
        return bossDao.authentiWaiter(waiter);
    }

    /***************************认证员工 start***************************************************/



    /***************************打开设置菜单页面 start***************************************************/

    public List<MenuClass> getMenuClass(){
        return bossDao.getMenuClass();
    }

    /***************************打开设置菜单页面 end***************************************************/


    /***************************处理添加菜单类别 start***************************************************/

    public int checkMenuClassRepeat(MenuClass menuClass){
        return bossDao.checkMenuClassRepeat(menuClass);
    }

    public int addMenuClass(MenuClass menuClass){
        return bossDao.addMenuClass(menuClass);
    }
    /***************************处理添加菜单类别 end***************************************************/


    /***************************处理添加菜单 start***************************************************/

    public int checkMenuRepeat(Menu menu){
        return bossDao.checkMenuRepeat(menu);
    }

    public int addMenu(Menu menu){
        return bossDao.addMenu(menu);
    }

    /***************************处理添加菜单 end***************************************************/


    /***************************打开菜单信息页面 start***************************************************/

    public List<Menu> getMenusInfo(){
        return bossDao.getMenusInfo();
    }

    /***************************打开菜单信息页面 end***************************************************/


    /***************************处理修改菜单成本、价格、库存 start***************************************************/

    public int modifyMenu(Menu menu,Model model){
        return bossDao.modifyMenu(menu);
    }

    /***************************处理修改菜单成本、价格、库存 end***************************************************/

}
