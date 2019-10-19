package service;

import org.springframework.ui.Model;
import pojo.Boss;
import pojo.Client;
import pojo.Waiter;

import javax.servlet.http.HttpSession;


public interface AccountService {
    public int bossLogin(Boss boss, Model model);
    public int clientLogin(Client client, Model model);
    public int waiterLogin(Waiter waiter);
    public int updateStatus(Waiter waiter);
    public int checkClientAcotRepeat(Client client);
    public int registerClient(Client client);
    public int checkWaiterAcotRepeat(Waiter waiter);
    public int registerWaiter(Waiter waiter);
}
