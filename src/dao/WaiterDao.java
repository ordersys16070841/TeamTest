package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Waiter;

@Repository
@Mapper
public interface WaiterDao {
    public int checkWaiterAcot(Waiter waiter);
    public int updateStatus(Waiter waiter);


}
