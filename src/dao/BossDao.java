package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Boss;
import pojo.Menu;
import pojo.MenuClass;
import pojo.Waiter;

import java.util.List;

@Repository
@Mapper
public interface BossDao {
    public int checkBossAcot(Boss boss);     //检查店长账号密码
    public List<Waiter> getWaitersInfo();
    public int authentiWaiter(Waiter waiter);
    public List<MenuClass> getMenuClass();
    public int addMenuClass(MenuClass menuClass);
    public int checkMenuClassRepeat(MenuClass menuClass);
    public int checkMenuRepeat(Menu menu);
    public int addMenu(Menu menu);
    public List<Menu> getMenusInfo();
    public int modifyMenu(Menu menu);
}
