package hvnh.delitask_serverapi.repository;

import hvnh.delitask_serverapi.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderCRUD extends CrudRepository<Order, Integer> {
    int countByCustomerId(int customerId);
}
