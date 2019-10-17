package service;


import dao.BossDao;
import dao.ClientDao;
import dao.WaiterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import pojo.Boss;
import pojo.Client;
import pojo.Waiter;
import tools.MD5Util2;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    private BossDao bossDao;
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private WaiterDao waiterDao;

    public String bossLogin(Boss boss, Model model){
        if(bossDao.checkBossAcot(boss)>0){
            return "boss/bossHome";
        }
        else{
            model.addAttribute("loginMsg","登录失败，账号或密码错误");
            return "boss/bossLogin";
        }
    }

    public String clientLogin(Client client, Model model){
        if(clientDao.checkClientAcot(client)>0){
            return "client/clientHome";
        }
        else{
            model.addAttribute("loginMsg","登录失败，账号或密码错误");
            return "client/clientLogin";
        }
    }

    public String waiterLogin(Waiter waiter, Model model){
        if(waiterDao.checkWaiterAcot(waiter)>0){
            return "waiter/waiterHome";
        }
        else{
            model.addAttribute("loginMsg","登录失败，账号或密码错误");
            return "waiter/waiterLogin";
        }
    }
}
