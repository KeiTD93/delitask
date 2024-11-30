package hvnh.delitask_serverapi.repository;

import hvnh.delitask_serverapi.entity.Cleaner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CleanerCRUD extends JpaRepository<Cleaner, Integer> {
    Optional<Cleaner> findByUserId(Integer userId);

}
