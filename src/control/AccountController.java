package control;

import net.sf.json.JSONObject;
import net.sf.jsqlparser.statement.select.Wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.Boss;
import pojo.Client;
import pojo.Waiter;
import service.AccountService;
import tools.MD5Util2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

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
/**********************************标准********************************************/
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

    @RequestMapping(value="/clientLogin.json",method= RequestMethod.POST)
    public void getFromClient(HttpServletRequest request, HttpServletResponse response,Client client, Model model) {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;
        JSONObject json = new JSONObject();

        try {
            out = response.getWriter();
            if (!"".equals(request.getParameter("cacot")) && !"".equals(request.getParameter("cpad"))) {

                String cacot = request.getParameter("cacot");
                String cpad = request.getParameter("cpad");
                client.setCacot(cacot);
                client.setCpsd(cpad);
                System.out.println(cacot);
                System.out.println(cpad);
                if (accountService.clientLogin(client, model) > 0) {
                    client = accountService.getClientInfo(client);
                    json.put("client", JSONObject.fromObject(client));
                    System.out.println(json);
                } else {
                    json.put("client", null);
                }

                out.write(json.toString());
            } else {
                json.put("status", 0);
                json.put("user", null);
                out.write(json.toString());
            }
        } catch (Exception e) {
            e.toString();
            json.put("status", -1);
            json.put("user", null);
            out.write(json.toString());
        } finally{
            out.flush();
            out.close();
        }
    }
/***************************ClientLogin end***************************************************/
/**********************************标准********************************************/

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
        waiter.setWpsd(MD5Util2.getStringMD5(waiter.getWpsd()));
        return accountService.waiterLogin(waiter,model,session);
    }

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
        return accountService.clientRegister(client,model);
    }

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
        return accountService.waiterRegister(waiter,model);
    }
}
