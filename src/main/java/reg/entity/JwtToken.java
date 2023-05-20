package reg.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "jwtStorage")
@Entity
@Data
public class JwtToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    @Column(columnDefinition = "TEXT")
    private String refreshToken;
}
