package service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pojo.Boss;
import pojo.Client;
import pojo.Waiter;

import javax.servlet.http.HttpSession;


public interface AccountService {
    public String bossLogin(Boss boss, Model model);
    public String clientLogin(Client client, Model model);
    public String waiterLogin(Waiter waiter, Model model, HttpSession session);
    public String clientRegister(Client client,Model model);
    public String waiterRegister(Waiter waiter, Model model);
}
