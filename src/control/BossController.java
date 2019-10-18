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

    @RequestMapping("/bossHome")
    public String toBossHome(Model model){
        return "boss/bossHome";
    }

    @RequestMapping("toAuthenti")
    public String toAuthenti(Model model){
        return bossService.toAuthenti(model);
    }

    @RequestMapping("authenti")
    public String authenti(HttpServletRequest request, Model model){
        int wid=Integer.parseInt(request.getParameter("wid"));
        return bossService.authenti(wid,model);
    }

    @RequestMapping("toSetMenu")
    public String toSetMenu(Model model){
        return bossService.toSetMenu(model);
    }

    @RequestMapping("addMenuClass")
    public String addMenuClass(MenuClass menuClass, Model model){
        return bossService.addMenuClass(menuClass,model);
    }

    @RequestMapping("addMenu")
    public String addMenu(Menu menu, Model model){
        return bossService.addMenu(menu,model);
    }

    @RequestMapping("toMenusInfo")
    public String toMenusInfo(Model model){
        return bossService.toMenusInfo(model);
    }

    @RequestMapping("modifyMenu")
    public String modifyMenu(Menu menu,Model model){
        return bossService.modifyMenu(menu,model);
    }
}
