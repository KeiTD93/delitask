package hvnh.delitask_serverapi.controller;

import hvnh.delitask_serverapi.dto.request.UserDto;
import hvnh.delitask_serverapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {

        userService.addUser(userDto);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/verify")
    public ResponseEntity<?> login(@RequestHeader(value = "username") String username,
                                   @RequestHeader(value = "password") String password) {
        return ResponseEntity.ok(userService.isValidUser(username, password));
    }

    @GetMapping("/checkRoleType")
    public ResponseEntity<?> checkRoleType(@RequestHeader(value = "username") String username) {
        return ResponseEntity.ok(userService.checkRoleType(username));
    }

    @GetMapping("/checkAccountAvaiable")
    public ResponseEntity<?> checkAccountAvaiable(@RequestHeader(value = "username") String username,
                                                  @RequestHeader(value = "email") String email,
                                                  @RequestHeader(value = "phone") String phone) {
        return ResponseEntity.ok(userService.checkAccountAvaiable(username, email, phone));
    }
}
