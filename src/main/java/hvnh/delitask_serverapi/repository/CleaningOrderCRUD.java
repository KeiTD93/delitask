package hvnh.delitask_serverapi.repository;

import hvnh.delitask_serverapi.entity.CleaningOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CleaningOrderCRUD extends JpaRepository<CleaningOrder, Integer> {
}
