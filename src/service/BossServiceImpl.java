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

    public String toAuthenti(Model model){
        List<Waiter> waiterList=bossDao.getWaitersInfo();
        model.addAttribute("waiterList",waiterList);
        return "boss/authenti";
    }

    public String authenti(int wid ,Model model){
        Waiter waiter=new Waiter();
        waiter.setWid(wid);
        bossDao.authentiWaiter(waiter);
        return "forward:toAuthenti";
    }

    public String toSetMenu(Model model){
        List<MenuClass> menuClassList=bossDao.getMenuClass();
        model.addAttribute("menuClassList",menuClassList);
        return "boss/setmenu";
    }

    public String addMenuClass(MenuClass menuClass,Model model){
        if(bossDao.checkMenuClassRepeat(menuClass)>0){
            model.addAttribute("menuClassMsg","该菜单类别已存在，无需再添加");
            return "forward:toSetMenu";
        }else{
            bossDao.addMenuClass(menuClass);
            model.addAttribute("menuClassMsg","菜单类别添加成功");
            return "forward:toSetMenu";
        }
    }

    public String addMenu(Menu menu, Model model){
        if(bossDao.checkMenuRepeat(menu)>0){
            model.addAttribute("addMenuMsg","该菜单已存在，无需再添加");
            return "forward:toSetMenu";
        }else{
            bossDao.addMenu(menu);
            model.addAttribute("addMenuMsg","菜单添加成功");
            return "forward:toSetMenu";
        }
    }

    public String toMenusInfo(Model model){
        List<Menu> menuList=bossDao.getMenusInfo();
        model.addAttribute("menuList",menuList);
        return "boss/menuInfo";
    }

    public String modifyMenu(Menu menu,Model model){
        bossDao.modifyMenu(menu);
        return "forward:toMenusInfo";
    }
}
