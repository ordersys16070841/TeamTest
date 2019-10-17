package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
