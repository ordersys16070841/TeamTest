package service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


public interface BossService {

    public String toAuthenti(Model model);
    public String authenti(int wid ,Model model);
}
