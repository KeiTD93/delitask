package hvnh.delitask_serverapi.repository;

import hvnh.delitask_serverapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderCRUD extends JpaRepository<Order, Integer> {
    int countByCustomerId(int customerId);
    List<Order> findByCleanerId(Integer cleanerId);

}
