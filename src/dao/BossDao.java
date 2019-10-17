package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Boss;

@Repository
@Mapper
public interface BossDao {
    int checkBossAcot(Boss boss);     //检查店长账号密码

}
