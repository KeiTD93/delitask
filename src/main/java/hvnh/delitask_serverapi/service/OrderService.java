package hvnh.delitask_serverapi.service;

import hvnh.delitask_serverapi.dto.OrderDto;
import hvnh.delitask_serverapi.entity.CleaningOrder;
import hvnh.delitask_serverapi.entity.Order;
import hvnh.delitask_serverapi.repository.CleaningOrderCRUD;
import hvnh.delitask_serverapi.repository.OrderCRUD;
import hvnh.delitask_serverapi.repository.ServiceCleaningHourCRUD;
import hvnh.delitask_serverapi.repository.UsersCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderCRUD orderCRUD;
    @Autowired
    UsersCRUD usersCRUD;
    @Autowired
    ServiceCleaningHourCRUD serviceCleaningHourCRUD;
    @Autowired
    CleaningOrderCRUD cleaningOrderCRUD;

    public int countOrder(String username) {
        return orderCRUD.countByCustomerId(usersCRUD.findByUsername(username).getId());
    }

    public int getPrice(int hour) {
        return serviceCleaningHourCRUD.findByHour(hour).getPrice();
    }

    public int addOrder(OrderDto orderDto) {
        Order order = orderCRUD.saveAndFlush(Order.builder()
                .customerId(orderDto.getCustomerId())
                .cleaner_id(null)
                .old_order_id(null)
                .name_customer(orderDto.getNameCustomer())
                .phone_customer(orderDto.getPhoneCustomer())
                .home_type(orderDto.getHomeType())
                .address(orderDto.getAddress())
                .service_type(orderDto.getServiceType())
                .status("PENDING")
                .pay_status(orderDto.getPayStatus())
                .build());

        cleaningOrderCRUD.saveAndFlush(CleaningOrder.builder()
                .orderId(order.getId())
                .totalPrice(Integer.parseInt(orderDto.getTotalPrice()))
                .status("PENDING")
                .startTime(orderDto.getStartTime())
                .note(orderDto.getNote())
                .isCleaningOther(orderDto.isCleaningOther())
                .isCook(orderDto.isCook())
                .hasAnimal(orderDto.isHasAnimal())
                .hasTool(orderDto.isHasTool())
                .serviceCleaningHourId(serviceCleaningHourCRUD.findByHour(orderDto.getServiceCleaningHour()).getId())
                .build());

        return order.getId();
    }
}
