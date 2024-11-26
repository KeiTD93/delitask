package hvnh.delitask_serverapi.repository;

import hvnh.delitask_serverapi.entity.ServiceCleaningHour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceCleaningHourCRUD extends JpaRepository<ServiceCleaningHour, Integer> {
    ServiceCleaningHour findByHour(int hour);
}
