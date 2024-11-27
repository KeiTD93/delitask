package hvnh.delitask_serverapi.repository;

import hvnh.delitask_serverapi.entity.CleaningOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CleaningOrderCRUD extends JpaRepository<CleaningOrder, Integer> {

    Optional<CleaningOrder> findByOrderIdAndStatus(int orderId, String status);

}
