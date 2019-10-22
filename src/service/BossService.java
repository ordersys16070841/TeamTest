package service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pojo.Menu;
import pojo.MenuClass;
import pojo.Waiter;

import java.util.List;


public interface BossService {

    public List<Waiter> getWaitersInfo();
    public int authentiWaiter(Waiter waiter);
    public List<MenuClass> getMenuClass();

    public int checkMenuClassRepeat(MenuClass menuClass);
    public int addMenuClass(MenuClass menuClass);

    public int checkMenuRepeat(Menu menu);
    public int addMenu(Menu menu);
    public List<Menu> getMenusInfo();
    public int modifyMenu(Menu menu, Model model);
}
