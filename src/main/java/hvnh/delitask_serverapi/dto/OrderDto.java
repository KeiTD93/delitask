package hvnh.delitask_serverapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private int customerId;
    private String nameCustomer;
    private String phoneCustomer;
    private String homeType;
    private String address;
    private String serviceType;
    private String payStatus;
    private boolean isCook;
    private boolean isCleaningOther;
    private boolean hasTool;
    private boolean hasAnimal;
    private String totalPrice;
    private LocalDateTime startTime;
    private String note;
    private int serviceCleaningHour;
}
