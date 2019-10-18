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
    public int checkClientAcot(Client client);
    public int checkClientAcotRepeat(Client client);
    public int registerClient(Client client);
    public List<MenuClass> getMenuClass();
    public List<Menu> getMenusByClass(int mclass);
}
