package control;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Menu;
import pojo.MenuClass;
import pojo.Waiter;
import service.BossService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BossController {
    @Autowired
    private BossService bossService;

    /**
     * 打开店长主页
     * @param model
     * @return
     */
    @RequestMapping("/bossHome")
    public String toBossHome(Model model){
        return "boss/bossHome";
    }


    /***************************认证员工 start***************************************************/

    /**
     * 打开认证员工页面
     * @param model
     * @return
     */
    @RequestMapping("toAuthenti")
    public String toAuthenti(Model model){
        List<Waiter> waiterList=bossService.getWaitersInfo();
        model.addAttribute("waiterList",waiterList);
        return "boss/authenti";
    }

    /**
     * 处理认证员工
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("authenti")
    public String authenti(HttpServletRequest request, Model model){
        int wid=Integer.parseInt(request.getParameter("wid"));
        Waiter waiter=new Waiter();
        waiter.setWid(wid);
        if(bossService.authentiWaiter(waiter)>0){
            model.addAttribute("authentiMsg","认证员工成功");
        }else{
            model.addAttribute("authentiMsg","认证员工失败");
        }
        return "forward:toAuthenti";
    }

    /***************************认证员工 end***************************************************/



/***************************打开设置菜单页面 start***************************************************/

    /**
     * 打开设置菜单页面
     * @param model
     * @return
     */
    @RequestMapping("toSetMenu")
    public String toSetMenu(Model model){
        List<MenuClass> menuClassList=bossService.getMenuClass();
        model.addAttribute("menuClassList",menuClassList);
        return "boss/setmenu";
    }

/***************************打开设置菜单页面 end***************************************************/


/***************************处理添加菜单类别 start***************************************************/

    /**
     * 处理添加菜单类别
     * @param menuClass
     * @param model
     * @return
     */
    @RequestMapping("addMenuClass")
    public String addMenuClass(MenuClass menuClass, Model model){
        if(bossService.checkMenuClassRepeat(menuClass)>0){
            model.addAttribute("menuClassMsg","该菜单类别已存在，无需再添加");
            return "forward:toSetMenu";
        }else {
            bossService.addMenuClass(menuClass);
            model.addAttribute("menuClassMsg","菜单类别添加成功");
            return "forward:toSetMenu";
        }
    }

/***************************处理添加菜单类别 end***************************************************/


/***************************处理添加菜单 start***************************************************/

    /**
     * 处理添加菜单
     * @param menu
     * @param model
     * @return
     */
    @RequestMapping("addMenu")
    public String addMenu(Menu menu, Model model){
        if(bossService.checkMenuRepeat(menu)>0){
            model.addAttribute("addMenuMsg","该菜单已存在，无需再添加");
            return "forward:toSetMenu";
        }else{
            bossService.addMenu(menu);
            model.addAttribute("addMenuMsg","菜单添加成功");
            return "forward:toSetMenu";
        }
    }

/***************************处理添加菜单 end***************************************************/


/***************************打开菜单信息页面 start***************************************************/

    /**
     * 打开菜单信息页面
     * @param model
     * @return
     */
    @RequestMapping("toMenusInfo")
    public String toMenusInfo(Model model){
        List<Menu> menuList=bossService.getMenusInfo();
        model.addAttribute("menuList",menuList);
        return "boss/menuInfo";
    }

/***************************打开菜单信息页面 end***************************************************/


/***************************处理修改菜单成本、价格、库存 start***************************************************/

    /**
     * 处理修改菜单成本、价格、库存
     * @param menu
     * @param model
     * @return
     */
    @RequestMapping("modifyMenu")
    public String modifyMenu(Menu menu,Model model){
        bossService.modifyMenu(menu,model);
        return "forward:toMenusInfo";
    }

/***************************处理修改菜单成本、价格、库存 end***************************************************/

}
