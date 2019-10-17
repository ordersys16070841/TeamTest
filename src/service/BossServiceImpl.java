package service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;


@Service
@Transactional
public class BossServiceImpl implements BossService {

    public String toBossHome(Model model){
        return "";
    }
}
