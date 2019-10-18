package service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pojo.Menu;
import pojo.MenuClass;


public interface BossService {

    public String toAuthenti(Model model);
    public String authenti(int wid ,Model model);
    public String toSetMenu(Model model);
    public String addMenuClass(MenuClass menuClass, Model model);
    public String addMenu(Menu menu, Model model);
    public String toMenusInfo(Model model);
    public String modifyMenu(Menu menu,Model model);
}
