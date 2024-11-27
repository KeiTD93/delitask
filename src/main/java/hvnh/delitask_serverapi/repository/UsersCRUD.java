package hvnh.delitask_serverapi.repository;

import hvnh.delitask_serverapi.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsersCRUD extends CrudRepository<User, Integer> {

    int countByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

    int countByUsernameOrEmailOrPhoneNumber(String username, String email, String phoneNumber);
}
