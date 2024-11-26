package hvnh.delitask_serverapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "cleaning_order")
public class CleaningOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "total_price")
    private int totalPrice;

    @Column
    private int deposit;

    @Column
    private String status;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column
    private String note;

    @Column(name = "is_cleaning_order")
    private Boolean isCleaningOther;

    @Column(name = "is_cook")
    private Boolean isCook;

    @Column(name = "has_tool")
    private Boolean hasTool;

    @Column(name = "has_animals")
    private Boolean hasAnimal;
}
