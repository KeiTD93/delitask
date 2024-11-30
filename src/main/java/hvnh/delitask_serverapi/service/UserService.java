package hvnh.delitask_serverapi.service;

import hvnh.delitask_serverapi.dto.request.UserDto;
import hvnh.delitask_serverapi.entity.User;
import hvnh.delitask_serverapi.repository.UsersCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UsersCRUD usersCRUD;

    public void addUser(UserDto userDto) {
        usersCRUD.saveAndFlush(User.builder()
                .email(userDto.getEmail())
                .name("default")
                .username(userDto.getUsername())
                .role_type("customer")
                .password(userDto.getPassword())
                .phoneNumber(userDto.getPhone())
                .build());
    }

    public String isValidUser(String username, String password) {
        boolean check = usersCRUD.countByUsernameAndPassword(username, password) > 0;
        if (check) {
            return usersCRUD.findByUsername(username).getRole_type();
        } else
            return "Invalid username or password";
    }

    public String checkRoleType(String username) {
        return usersCRUD.findByUsername(username).getRole_type();
    }

    public boolean checkAccountAvaiable(String username, String email, String phone) {
        return !(usersCRUD.countByUsernameOrEmailOrPhoneNumber(username, email, phone) > 0);
    }
}
