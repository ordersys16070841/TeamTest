package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Boss;
import pojo.Waiter;

import java.util.List;

@Repository
@Mapper
public interface BossDao {
    public int checkBossAcot(Boss boss);     //检查店长账号密码
    public List<Waiter> getWaitersInfo();
    public int authentiWaiter(Waiter waiter);
}
