package control;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Menu;
import pojo.MenuClass;
import service.BossService;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * 打开认证员工页面
     * @param model
     * @return
     */
    @RequestMapping("toAuthenti")
    public String toAuthenti(Model model){
        return bossService.toAuthenti(model);
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
        return bossService.authenti(wid,model);
    }

    /**
     * 打开设置菜单页面
     * @param model
     * @return
     */
    @RequestMapping("toSetMenu")
    public String toSetMenu(Model model){
        return bossService.toSetMenu(model);
    }

    /**
     * 处理添加菜单类别
     * @param menuClass
     * @param model
     * @return
     */
    @RequestMapping("addMenuClass")
    public String addMenuClass(MenuClass menuClass, Model model){
        return bossService.addMenuClass(menuClass,model);
    }

    /**
     * 处理添加菜单
     * @param menu
     * @param model
     * @return
     */
    @RequestMapping("addMenu")
    public String addMenu(Menu menu, Model model){
        return bossService.addMenu(menu,model);
    }

    /**
     * 打开菜单信息页面
     * @param model
     * @return
     */
    @RequestMapping("toMenusInfo")
    public String toMenusInfo(Model model){
        return bossService.toMenusInfo(model);
    }

    /**
     * 处理修改菜单成本、价格、库存
     * @param menu
     * @param model
     * @return
     */
    @RequestMapping("modifyMenu")
    public String modifyMenu(Menu menu,Model model){
        return bossService.modifyMenu(menu,model);
    }
}
