package hvnh.delitask_serverapi.repository;

import hvnh.delitask_serverapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersCRUD extends JpaRepository<User, Integer> {

    int countByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

    int countByUsernameOrEmailOrPhoneNumber(String username, String email, String phoneNumber);
}
