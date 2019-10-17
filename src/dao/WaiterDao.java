package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Client;
import pojo.Waiter;

@Repository
@Mapper
public interface WaiterDao {
    public int checkWaiterAcot(Waiter waiter);
    public int updateStatus(Waiter waiter);
    public int checkWaiterAcotRepeat(Waiter waiter);
    public int registerWaiter(Waiter waiter);

}
