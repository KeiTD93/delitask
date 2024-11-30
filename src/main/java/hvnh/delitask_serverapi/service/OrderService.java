package hvnh.delitask_serverapi.service;

import hvnh.delitask_serverapi.dto.request.OrderDto;
import hvnh.delitask_serverapi.dto.response.OrderDetailDto;
import hvnh.delitask_serverapi.entity.Cleaner;
import hvnh.delitask_serverapi.entity.CleaningOrder;
import hvnh.delitask_serverapi.entity.Order;
import hvnh.delitask_serverapi.entity.User;
import hvnh.delitask_serverapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    CleanerCRUD cleanerCRUD;
    public int countOrder(String username) {
        return orderCRUD.countByCustomerId(usersCRUD.findByUsername(username).getId());
    }

    public int getPrice(int hour) {
        return serviceCleaningHourCRUD.findByHour(hour).getPrice();
    }

    public int addOrder(OrderDto orderDto) {
        User user = usersCRUD.findByUsername(orderDto.getCustomerId());
        Order order = orderCRUD.saveAndFlush(Order.builder()
                .customerId(user.getId())
                .cleanerId(null)
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


    public Object getListCleaningOrderReceived(String username) {
        User user = usersCRUD.findByUsername(username);
        Optional<Cleaner> cleanerOpt = cleanerCRUD.findByUserId(user.getId());
        List<Order> orders = orderCRUD.findByCleanerId(cleanerOpt.get().getId());
        List<OrderDetailDto> orderDetailDtoList = new ArrayList<>();
        for (Order order : orders) {
            Optional<CleaningOrder> cleaningOrderOptional = cleaningOrderCRUD.findByOrderIdAndStatus(order.getId(), "pending");
            if (cleaningOrderOptional.isPresent()) {
                orderDetailDtoList.add(OrderDetailDto.builder()
                        .orderId(order.getId())
                        .totalPrice(cleaningOrderOptional.get().getTotalPrice())
                        .deposit(cleaningOrderOptional.get().getDeposit())
                        .status(order.getStatus())
                        .startTime(cleaningOrderOptional.get().getStartTime())
                        .note(cleaningOrderOptional.get().getNote())
                        .isCleaningOther(cleaningOrderOptional.get().getIsCleaningOther())
                        .isCook(cleaningOrderOptional.get().getIsCook())
                        .hasTool(cleaningOrderOptional.get().getHasTool())
                        .hasAnimal(cleaningOrderOptional.get().getHasAnimal())
                        .serviceCleaningHourId(cleaningOrderOptional.get().getServiceCleaningHourId())
                        .address(order.getAddress())
                        .build()
                );            }
        }
        return orderDetailDtoList;

    }


    public List<OrderDetailDto> getListCleaningOrder() {
        List<Order> orders = orderCRUD.findByCleanerId(null);
        List<OrderDetailDto> orderDetailDtoList = new ArrayList<>();
        for (Order order : orders) {
            Optional<CleaningOrder> cleaningOrderOptional = cleaningOrderCRUD.findByOrderIdAndStatus(order.getId(), "pending");
            if (cleaningOrderOptional.isPresent()) {
                orderDetailDtoList.add(OrderDetailDto.builder()
                                .orderId(order.getId())
                                .totalPrice(cleaningOrderOptional.get().getTotalPrice())
                                .deposit(cleaningOrderOptional.get().getDeposit())
                                .status(order.getStatus())
                                .startTime(cleaningOrderOptional.get().getStartTime())
                                .note(cleaningOrderOptional.get().getNote())
                                .isCleaningOther(cleaningOrderOptional.get().getIsCleaningOther())
                                .isCook(cleaningOrderOptional.get().getIsCook())
                                .hasTool(cleaningOrderOptional.get().getHasTool())
                                .hasAnimal(cleaningOrderOptional.get().getHasAnimal())
                                .serviceCleaningHourId(cleaningOrderOptional.get().getServiceCleaningHourId())
                                .address(order.getAddress())
                        .build()
                );
            }
        }
        return orderDetailDtoList;
    }

    public String apply(int cleanId, int orderId) {
        Order order = orderCRUD.findById(orderId);
        if (order.getCleanerId() == null) {
            order.setCleanerId(cleanId);
            orderCRUD.saveAndFlush(order);
            return "OK";
        } else
            return "ERROR";
    }

    public List<OrderDetailDto> findWaittingCleaningOrders(String username) {

        List<OrderDetailDto> orderDetailDtos = new ArrayList<>();
        Optional<CleaningOrder> cleaningOrder;
        int userId = usersCRUD.findByUsername(username).getId();
        List<Order> orders = orderCRUD.findByCustomerId(userId);
        for (Order order : orders) {
            cleaningOrder = cleaningOrderCRUD.findByOrderId(order.getId());
            if (cleaningOrder.isPresent()) {
                orderDetailDtos.add(OrderDetailDto.builder()
                        .orderId(orders.get(0).getId())
                        .totalPrice(cleaningOrder.get().getTotalPrice())
                        .deposit(cleaningOrder.get().getDeposit())
                        .status(order.getStatus())
                        .startTime(cleaningOrder.get().getStartTime())
                        .note(cleaningOrder.get().getNote())
                        .isCleaningOther(cleaningOrder.get().getIsCleaningOther())
                        .isCook(cleaningOrder.get().getIsCook())
                        .hasAnimal(cleaningOrder.get().getHasAnimal())
                        .hasTool(cleaningOrder.get().getHasTool())
                        .serviceCleaningHourId(cleaningOrder.get().getServiceCleaningHourId())
                        .address(order.getAddress())
                        .build());
            }
        }
        return orderDetailDtos;
    }
}
