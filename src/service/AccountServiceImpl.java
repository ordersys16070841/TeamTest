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

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    private BossDao bossDao;
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private WaiterDao waiterDao;

    public int bossLogin(Boss boss, Model model){
        if(bossDao.checkBossAcot(boss)>0){
            return 1;
        }
        else{
            return 0;
        }
    }
    /********************标准********************************************/

    public int clientLogin(Client client, Model model){
        if(clientDao.checkClientAcot(client)>0){
            return 1;
        }
        else{
            return 0;
        }
    }

    public Client getClientInfo(Client client) {
        return clientDao.getClientInfo(client);
    }

    /********************标准********************************************/

    public String waiterLogin(Waiter waiter, Model model, HttpSession session){
        if(waiterDao.checkWaiterAcot(waiter)>0){
            waiter.setWstatus(2);
            waiterDao.updateStatus(waiter);
            session.setAttribute("waiterName",waiter.getWname());
            return "forwarrd:toWaiterHome";
        }
        else{
            model.addAttribute("loginMsg","登录失败，账号或密码错误");
            return "waiter/waiterLogin";
        }
    }
    public String clientRegister(Client client,Model model){
        if(clientDao.checkClientAcotRepeat(client)>0){
            model.addAttribute("registerMsg","注册失败，该账号已被注册");
            return "client/clientRegister";
        }
        else{
            client.setCpsd(MD5Util2.getStringMD5(client.getCpsd()));
            clientDao.registerClient(client);
            model.addAttribute("registerMsg","注册成功");
            return "client/clientRegister";
        }
    }

    public String waiterRegister(Waiter waiter, Model model){
        if(waiterDao.checkWaiterAcotRepeat(waiter)>0){
            model.addAttribute("registerMsg","注册失败，该账号已被注册");
            return "waiter/waiterRegister";
        }
        else{
            waiter.setWpsd(MD5Util2.getStringMD5(waiter.getWpsd()));
            waiterDao.registerWaiter(waiter);
            model.addAttribute("registerMsg","注册信息已提交给店长，等待店长验证");
            return "waiter/waiterRegister";
        }
    }
}
