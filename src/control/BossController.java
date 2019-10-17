package control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BossController {

    @RequestMapping("/bossHome")
    public String toBossHome(Model model){
        return "bossHome";
    }
}
