package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ClientService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @RequestMapping("clienthome")
    public String clienthome(HttpServletRequest request, Model model){
        int mclass;
        if(request.getParameter("mclass")==null){
            mclass=1;
        }else{
            mclass=Integer.parseInt(request.getParameter("mclass"));
        }
        return clientService.clienthome(mclass,model);
    }

    @RequestMapping("clientAddMenu")
    public String clientAddMenu(HttpServletRequest request,Model model){
        int mclass=Integer.parseInt(request.getParameter("mclass"));
        return clientService.clientAddMenu(mclass,model);
    }
}
