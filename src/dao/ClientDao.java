package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Client;
import pojo.Menu;
import pojo.MenuClass;

import java.util.List;

@Repository
@Mapper
public interface ClientDao {
    /**
     * 检查客户密码账号
     * @param client
     * @return
     */
    public int checkClientAcot(Client client);

    /**
     * 检查客户账号是否重复
     * @param client
     * @return
     */
    public int checkClientAcotRepeat(Client client);

    /**
     * 注册客户
     * @param client
     * @return
     */
    public int registerClient(Client client);

    /**
     * 获取菜单类别
     * @return
     */
    public List<MenuClass> getMenuClass();

    /**
     * 获取对应菜单类别的菜单
     * @param mclass
     * @return
     */
    public List<Menu> getMenusByClass(int mclass);

    /**
     *
     * @return
     */
    public int addMenuToOrder();

}
