package bhma.web4.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    private Long id;
    @Column(nullable = false, unique = true)
    @Setter
    @Getter
    private String username;
    @Column(nullable = false)
    @Setter
    @Getter
    private String password;

    public UserEntity() {
    }

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
