package control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WaiterController {

    /**
     * 打开服务员页面
     * @return
     */
    @RequestMapping("/toWaiterHome")
    public String toWaiterHome(){
        return "waiter/waiterHome";
    }
}
