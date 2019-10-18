package service;

import dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import pojo.Menu;
import pojo.MenuClass;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    public String clienthome(int mclass,Model model){
        List<MenuClass> menuClassList=clientDao.getMenuClass();
        int size=menuClassList.size();
        model.addAttribute("menuClassList",menuClassList);
        model.addAttribute("size",size);
        List<Menu> menuList=clientDao.getMenusByClass(mclass);
        model.addAttribute("menuList",menuList);
        return "client/clientHome";
    }

    public String clientAddMenu(int mclass,Model model){
        return "";
    }
}
