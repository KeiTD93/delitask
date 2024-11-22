package hvnh.delitask_serverapi.controller;

import hvnh.delitask_serverapi.dto.UserDto;
import hvnh.delitask_serverapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/countOrder")
    public ResponseEntity<?> countOrder(@RequestHeader(value = "username") String username) {
        return ResponseEntity.ok(orderService.countOrder(username));
    }
}
