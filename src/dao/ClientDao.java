package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Client;

@Repository
@Mapper
public interface ClientDao {
    public int checkClientAcot(Client client);
}
