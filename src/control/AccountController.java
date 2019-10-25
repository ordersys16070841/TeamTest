package control;

import net.sf.json.JSONObject;
import net.sf.jsqlparser.statement.select.Wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public String bossLogin(Boss boss, Model model,HttpSession session){
        boss.setBpsd(MD5Util2.getStringMD5(boss.getBpsd()));
        if(accountService.bossLogin(boss,model)>0){
            session.setAttribute("boss","boss");
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
    public String clientLogin(HttpSession session,Client client,Model model){
        client.setCpsd(MD5Util2.getStringMD5(client.getCpsd()));
        if(accountService.clientLogin(client,model)>0){
            int cId=accountService.getCidByAcot(client);
            session.setAttribute("cId",cId);
            return "forward:clienthome";
        }else {
            model.addAttribute("loginMsg","登录失败，账号或密码错误");
            return "client/clientLogin";
        }
    }

    @RequestMapping(value="/clientLogin.json",method= RequestMethod.POST)
    public void getFromClient(HttpServletRequest request, HttpServletResponse response, Client client, Model model) {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;
        JSONObject json = new JSONObject();

        try {
            out = response.getWriter();
            if (!"".equals(request.getParameter("cacot")) && !"".equals(request.getParameter("cpsd"))) {

                String cacot = request.getParameter("cacot");
                String cpsd = request.getParameter("cpsd");
                client.setCacot(cacot);
                client.setCpsd(cpsd);
                System.out.println(cacot);
                System.out.println(cpsd);
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
        waiter.setWpsd(MD5Util2.getStringMD5(waiter.getWpsd()));
        if(accountService.waiterLogin(waiter)>0){
            waiter.setWstatus(2);
            accountService.updateStatus(waiter);
            waiter=accountService.getWaterInfo(waiter);
            session.setAttribute("waiterName",waiter.getWname());
            session.setAttribute("wId",waiter.getWid());
            return "forward:toWaiterHome";
        }else{
            model.addAttribute("loginMsg","登录失败，账号密码错误或账号未被店长认证");
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
        }else if(client.getCacot().matches("^[^0-9][\\w_]{4,10}$")&&
                client.getCpsd().matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$")){
            client.setCpsd(MD5Util2.getStringMD5(client.getCpsd()));
            accountService.registerClient(client);
            model.addAttribute("registerMsg","注册成功,<a href=\"toClientLogin\">登录传送门</a>");
            return "client/clientRegister";
        }else{
            model.addAttribute("registerMsg","注册失败，账号或密码设置过于简单");
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
        }else if(waiter.getWacot().matches("^[^0-9][\\w_]{4,10}$")&&
                waiter.getWpsd().matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$")){
            waiter.setWpsd(MD5Util2.getStringMD5(waiter.getWpsd()));
            accountService.registerWaiter(waiter);
            model.addAttribute("registerMsg","注册信息已提交给店长，等待店长验证");
            return "waiter/waiterRegister";
        }else {
            model.addAttribute("registerMsg","注册失败，账号或密码设置过于简单");
            return "waiter/waiterRegister";
        }
    }

    /***************************WaiterRegister end***************************************************/



    /***************************WaiterLogout start***************************************************/

    @RequestMapping("/waiterLogout")
    public String waiterLogout(HttpSession session){
        int wId=(Integer)session.getAttribute("wId");
        accountService.waiterlogout(wId);
        session.removeAttribute("waiterName");
        session.removeAttribute("wId");
        return "waiter/waiterLogin";
    }

    /***************************WaiterLogout end***************************************************/


    /***************************ClientLogout start***************************************************/

    @RequestMapping("/clientLogout")
    public String clientLogout(HttpSession session){
        session.removeAttribute("cId");
        session.removeAttribute("clientName");
        return "client/clientLogin";
    }

    /***************************ClientLogout end***************************************************/


    /***************************BossLogout start***************************************************/

    @RequestMapping("/bossLogout")
    public String bossLogout(HttpSession session){
        session.removeAttribute("boss");
        return "boss/bossLogin";
    }

    /***************************BossLogout end***************************************************/

}
