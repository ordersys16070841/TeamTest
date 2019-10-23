package service;


import dao.BossDao;
import dao.ClientDao;
import dao.WaiterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import pojo.Boss;
import pojo.Client;
import pojo.Waiter;
import tools.MD5Util2;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    private BossDao bossDao;
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private WaiterDao waiterDao;

/***************************BossLogin start***************************************************/

    public int bossLogin(Boss boss, Model model){
        if(bossDao.checkBossAcot(boss)>0){
            return 1;
        }
        else{
            return 0;
        }
    }

/***************************BossLogin end***************************************************/



    /***************************ClientLogin start***************************************************/

    public int clientLogin(Client client, Model model){
        if(clientDao.checkClientAcot(client)>0){
            return 1;
        }
        else{
            return 0;
        }
    }

    //通过账号获取cId
    public int getCidByAcot(Client client){
        return clientDao.getCidByAcot(client);
    }

    public Client getClientInfo(Client client) {
        return clientDao.getClientInfo(client);
    }

    /***************************ClientLogin end***************************************************/


    /***************************WaiterLogin start***************************************************/

    public int updateStatus(Waiter waiter){
        return waiterDao.updateStatus(waiter);
    }

    //通过账号获取员工信息
    public Waiter getWaterInfo(Waiter waiter){
        return waiterDao.getWaterInfo(waiter);
    }

    public int waiterLogin(Waiter waiter){
        return waiterDao.checkWaiterAcot(waiter);
    }

    /***************************WaiterLogin end***************************************************/



    /***************************ClientRegister start***************************************************/

    public int checkClientAcotRepeat(Client client){
        return clientDao.checkClientAcotRepeat(client);
    }

    public int registerClient(Client client){
        return clientDao.registerClient(client);
    }

    /***************************ClientRegister end***************************************************/


    /***************************WaiterRegister start***************************************************/

    public int checkWaiterAcotRepeat(Waiter waiter){
        return waiterDao.checkWaiterAcotRepeat(waiter);
    }

    public int registerWaiter(Waiter waiter){
        return waiterDao.registerWaiter(waiter);
    }

    /***************************WaiterRegister end***************************************************/

}
