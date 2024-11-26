package hvnh.delitask_serverapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "customer_id")
    private int customerId;

    @Column (name = "cleaner_id")
    private Integer cleanerId;

    @Column
    private String name_customer;

    @Column
    private String phone_customer;

    @Column
    private String home_type;

    @Column
    private String address;

    @Column
    private String service_type;

    @Column
    private String status;

    @Column
    private String pay_status;

    @Column
    private String feedback;

    @Column
    private Integer rating;

    @Column
    private Integer old_order_id;

    @Column
    private Date feedback_date;
}
