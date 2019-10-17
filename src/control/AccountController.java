package control;

import net.sf.jsqlparser.statement.select.Wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.Boss;
import pojo.Client;
import pojo.Waiter;
import service.AccountService;
import tools.MD5Util2;

import javax.servlet.http.HttpSession;

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
    public String waiterLogin(Waiter waiter,Model model, HttpSession session){
        waiter.setWpsd(MD5Util2.getStringMD5(waiter.getWpsd()));
        return accountService.waiterLogin(waiter,model,session);
    }

    @RequestMapping("/toClientRegister")
    public String toClientRegister(){
        return "client/clientRegister";
    }

    @RequestMapping("/clientRegister")
    public String clientRegister(Client client,Model model){
        return accountService.clientRegister(client,model);
    }

    @RequestMapping("/toWaiterRegister")
    public String toWaiterRegister(){
        return "waiter/waiterRegister";
    }

    @RequestMapping("/waiterRegister")
    public String waiterRegister(Waiter waiter, Model model){
        return accountService.waiterRegister(waiter,model);
    }
}
