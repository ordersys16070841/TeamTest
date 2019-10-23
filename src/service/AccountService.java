package service;

import org.springframework.ui.Model;
import pojo.Boss;
import pojo.Client;
import pojo.Waiter;

import javax.servlet.http.HttpSession;


public interface AccountService {
    public int bossLogin(Boss boss, Model model);
    public int clientLogin(Client client, Model model);
    public int waiterLogin(Waiter waiter);     //返回wId  结果不行
    public int updateStatus(Waiter waiter);
    public int checkClientAcotRepeat(Client client);
    public int registerClient(Client client);
    public int checkWaiterAcotRepeat(Waiter waiter);
    public int registerWaiter(Waiter waiter);

    public Client getClientInfo(Client client);
    public int getCidByAcot(Client client);   //通过账号获取cId
    public Waiter getWaterInfo(Waiter waiter);    //通过账号获取员工信息
}
