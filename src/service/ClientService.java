package service;

import org.springframework.ui.Model;

public interface ClientService {
    public String clienthome(int mclass,Model model);
    public String clientAddMenu(int mclass,Model model);
}
