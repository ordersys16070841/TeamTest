package service;

import org.springframework.ui.Model;
import pojo.Menu;
import pojo.MenuClass;

import java.util.List;

public interface ClientService {
    public List<MenuClass> getMenuClass();
    public List<Menu> getMenusByClass(int mclass);
    public String clientAddMenu(int mclass,Model model);
}
