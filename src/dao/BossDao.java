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
    /**
     * 检查店长账号密码
     * @param boss
     * @return
     */
    public int checkBossAcot(Boss boss);     //检查店长账号密码

    /**
     * 获取待认证的服务员的信息
     * @return
     */
    public List<Waiter> getWaitersInfo();

    /**
     * 认证服务员
     * @param waiter
     * @return
     */
    public int authentiWaiter(Waiter waiter);

    /**
     * 获取菜单类别
     * @return
     */
    public List<MenuClass> getMenuClass();

    /**
     * 添加菜单类别
     * @param menuClass
     * @return
     */
    public int addMenuClass(MenuClass menuClass);

    /**
     * 检查菜单类别是否重复
     * @param menuClass
     * @return
     */
    public int checkMenuClassRepeat(MenuClass menuClass);

    /**
     * 检查菜名是否重复
     * @param menu
     * @return
     */
    public int checkMenuRepeat(Menu menu);

    /**
     * 添加菜单
     * @param menu
     * @return
     */
    public int addMenu(Menu menu);

    /**
     * 获取菜单信息
     * @return
     */
    public List<Menu> getMenusInfo();

    /**
     * 修改菜单成本、价格、库存
     * @param menu
     * @return
     */
    public int modifyMenu(Menu menu);
}
