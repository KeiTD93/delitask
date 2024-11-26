package hvnh.delitask_serverapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "Service_Cleaning_Hour")
public class ServiceCleaningHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int hour;
    @Column
    private int price;
    @Column
    private String name;
}
