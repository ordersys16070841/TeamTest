package control;

import net.sf.jsqlparser.statement.select.Wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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




/***************************BossLogin start***************************************************/

    /**
     * 打开店长登录页面
     * @return
     */
    @RequestMapping("/toBossLogin")
    public String toBossLogin(){
        return "boss/bossLogin";
    }


    /**
     * 处理店长登录
     * @param boss
     * @param model
     * @return
     */
    @RequestMapping("/bossLogin")
    public String bossLogin(Boss boss, Model model){
        boss.setBpsd(MD5Util2.getStringMD5(boss.getBpsd()));
        if(accountService.bossLogin(boss,model)>0){
            return "boss/bossHome";
        }else {
            model.addAttribute("loginMsg","登录失败，账号或密码错误");
            return "boss/bossLogin";
        }
    }


/***************************BossLogin end***************************************************/



/***************************ClientLogin start***************************************************/


    /**
     * 打开客户登录页面
     * @return
     */
    @RequestMapping("/toClientLogin")
    public String toClientLogin(){
        return "client/clientLogin";
    }

    /**
     * 处理客户登录
     * @param client
     * @param model
     * @return
     */
    @RequestMapping("/clientLogin")
    public String clientLogin(Client client,Model model){
        client.setCpsd(MD5Util2.getStringMD5(client.getCpsd()));
        if(accountService.clientLogin(client,model)>0){
            return "client/clientHome";
        }else {
            model.addAttribute("loginMsg","登录失败，账号或密码错误");
            return "client/clientLogin";
        }
    }

/***************************ClientLogin end***************************************************/


    /***************************WaiterLogin start***************************************************/

    /**
     * 打开服务员登录页面
     * @return
     */
    @RequestMapping("/toWaiterLogin")
    public String toWaiterLogin(){
        return "waiter/waiterLogin";
    }

    /**
     * 处理服务员登录
     * @param waiter
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/waiterLogin")
    public String waiterLogin(Waiter waiter,Model model, HttpSession session){
        if(accountService.waiterLogin(waiter)>0){
            waiter.setWstatus(2);
            accountService.updateStatus(waiter);
            session.setAttribute("waiterName",waiter.getWname());
            return "forwarrd:toWaiterHome";
        }else{
            model.addAttribute("loginMsg","登录失败，账号或密码错误");
            return "waiter/waiterLogin";
        }
    }

    /***************************WaiterLogin end***************************************************/


    /***************************ClientRegister start***************************************************/

    /**
     * 打开客户注册页面
     * @return
     */
    @RequestMapping("/toClientRegister")
    public String toClientRegister(){
        return "client/clientRegister";
    }

    /**
     * 处理客户注册
     * @param client
     * @param model
     * @return
     */
    @RequestMapping("/clientRegister")
    public String clientRegister(Client client,Model model){
        if(accountService.checkClientAcotRepeat(client)>0){
            model.addAttribute("registerMsg","注册失败，该账号已被注册");
            return "client/clientRegister";
        }else{
            client.setCpsd(MD5Util2.getStringMD5(client.getCpsd()));
            accountService.registerClient(client);
            model.addAttribute("registerMsg","注册成功");
            return "client/clientRegister";
        }
    }

    /***************************ClientRegister end***************************************************/



    /***************************WaiterRegister start***************************************************/

    /**
     * 打开服务员注册页面
     * @return
     */
    @RequestMapping("/toWaiterRegister")
    public String toWaiterRegister(){
        return "waiter/waiterRegister";
    }

    /**
     * 处理服务员注册
     * @param waiter
     * @param model
     * @return
     */
    @RequestMapping("/waiterRegister")
    public String waiterRegister(Waiter waiter, Model model){
        if(accountService.checkWaiterAcotRepeat(waiter)>0){
            model.addAttribute("registerMsg","注册失败，该账号已被注册");
            return "waiter/waiterRegister";
        }else{
            waiter.setWpsd(MD5Util2.getStringMD5(waiter.getWpsd()));
            accountService.registerWaiter(waiter);
            model.addAttribute("registerMsg","注册信息已提交给店长，等待店长验证");
            return "waiter/waiterRegister";
        }
    }

    /***************************WaiterRegister end***************************************************/

}
