package hvnh.delitask_serverapi.service;

import hvnh.delitask_serverapi.dto.UserDto;
import hvnh.delitask_serverapi.entity.User;
import hvnh.delitask_serverapi.repository.UsersCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UsersCRUD usersCRUD;

    public User addUser(UserDto userDto) {
        return usersCRUD.save(User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .username(userDto.getUsername())
                .role_type("customer")
                .password(userDto.getPassword())
                .build());
    }

    public boolean isValidUser(String username, String password) {
        return usersCRUD.countByUsernameAndPassword(username, password) > 0;
    }

    public String checkRoleType(String username){
        return usersCRUD.findByUsername(username).getRole_type();
    }
}
