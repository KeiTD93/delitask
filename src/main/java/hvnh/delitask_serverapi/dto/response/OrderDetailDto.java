package hvnh.delitask_serverapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailDto {
    private int orderId;
    private int totalPrice;
    private int deposit;
    private String status;
    private LocalDateTime startTime;
    private String note;
    private Boolean isCleaningOther;
    private Boolean isCook;
    private Boolean hasTool;
    private Boolean hasAnimal;
    private int serviceCleaningHourId;
    private String address;
}
