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

    /***************************客户主页 start***************************************************/

    public List<MenuClass> getMenuClass(){
        return clientDao.getMenuClass();
    }

    public List<Menu> getMenusByClass(int mclass){
        return clientDao.getMenusByClass(mclass);
    }

    /***************************客户主页 end***************************************************/

    public String clientAddMenu(int mclass,Model model){

        return "";
    }
}
