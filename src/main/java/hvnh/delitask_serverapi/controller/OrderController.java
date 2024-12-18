package hvnh.delitask_serverapi.controller;

import hvnh.delitask_serverapi.dto.request.OrderDto;
import hvnh.delitask_serverapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/countOrder")
    public ResponseEntity<?> countOrder(@RequestHeader(value = "username") String username) {
        return ResponseEntity.ok(orderService.countOrder(username));
    }

    @GetMapping("/getPrice")
    public ResponseEntity<?> getPrice(@RequestHeader(value = "hour") int hour) {
        return ResponseEntity.ok(orderService.getPrice(hour));
    }

    @PostMapping("/addOrder")
    public ResponseEntity<?> addOrder(@RequestBody OrderDto orderDto) {
        int orderId = orderService.addOrder(orderDto);
        return ResponseEntity.ok(orderId);
    }

    @GetMapping("/getListCleanJob")
    public ResponseEntity<?> getListCleanJob() {
        return ResponseEntity.ok(orderService.getListCleaningOrder());
    }


    @GetMapping("/getListCleanJobReceived")
    public ResponseEntity<?> getListCleanJobReceived(@RequestHeader(value = "username") String username) {
        return ResponseEntity.ok(orderService.getListCleaningOrderReceived(username));
    }


    @GetMapping("/apply")
    public ResponseEntity<?> apply(@RequestHeader(value = "cleanerId") int cleanerId, @RequestHeader(value = "orderId") int orderId) {
        return ResponseEntity.ok(orderService.apply(cleanerId, orderId));
    }

    @GetMapping("/findWaittingOrders")
    public ResponseEntity<?> findWaittingOrders(@RequestHeader(value = "username") String username) {
        return ResponseEntity.ok(orderService.findWaittingCleaningOrders(username));
    }

}
