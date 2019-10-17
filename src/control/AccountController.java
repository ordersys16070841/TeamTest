package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.Boss;
import pojo.Client;
import pojo.Waiter;
import service.AccountService;
import tools.MD5Util2;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/toBossLogin")
    public String toBossLogin(){
        return "boss/bossLogin";
    }

    @RequestMapping("/bossLogin")
    public String bossLogin(Boss boss, Model model){
        boss.setBpsd(MD5Util2.getStringMD5(boss.getBpsd()));
        return accountService.bossLogin(boss,model);
    }

    @RequestMapping("/toClientLogin")
    public String toClientLogin(){
        return "client/clientLogin";
    }

    @RequestMapping("/clientLogin")
    public String clientLogin(Client client,Model model){
        client.setCpsd(MD5Util2.getStringMD5(client.getCpsd()));
        return accountService.clientLogin(client,model);
    }

    @RequestMapping("/toWaiterLogin")
    public String toWaiterLogin(){
        return "waiter/waiterLogin";
    }

    @RequestMapping("/waiterLogin")
    public String waiterLogin(Waiter waiter,Model model){
        waiter.setWpsd(MD5Util2.getStringMD5(waiter.getWpsd()));
        return accountService.waiterLogin(waiter,model);
    }
}
