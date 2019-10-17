package service;


import dao.BossDao;
import dao.WaiterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import pojo.Boss;
import pojo.Waiter;

import java.util.List;


@Service
@Transactional
public class BossServiceImpl implements BossService {
    @Autowired
    private BossDao bossDao;

    public String toAuthenti(Model model){
        List<Waiter> waiterList=bossDao.getWaitersInfo();
        model.addAttribute("waiterList",waiterList);
        return "boss/authenti";
    }

    public String authenti(int wid ,Model model){
        Waiter waiter=new Waiter();
        waiter.setWid(wid);
        bossDao.authentiWaiter(waiter);
        return "forward:toAuthenti";
    }
}
