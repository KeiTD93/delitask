package hvnh.delitask_serverapi.repository;

import hvnh.delitask_serverapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderCRUD extends JpaRepository<Order, Integer> {
    int countByCustomerId(int customerId);
    List<Order> findByCleanerId(Integer cleanerId);

    Order findById(int id);

    List<Order> findByCustomerId(int customerId);
}
