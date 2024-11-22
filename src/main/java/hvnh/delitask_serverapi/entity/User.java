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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String address;

    @Column
    private Date created_at;

    @Column
    private String email;

    @Column
    private Date email_verified_at;

    @Column
    private String identification;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String phone_number;

    @Column
    private String remember_token;

    @Column
    private String role_type;

    @Column
    private Date updated_at;

    @Column(name = "user_name")
    private String username;
}
