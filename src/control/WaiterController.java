package control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WaiterController {

    @RequestMapping("/toWaiterHome")
    public String toWaiterHome(){
        return "waiter/waiterHome";
    }
}
