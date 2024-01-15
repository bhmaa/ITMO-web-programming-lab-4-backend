package bhma.web4.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class HitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private Double x;
    @Getter
    @Setter
    private Double y;
    @Getter
    @Setter
    private Double r;
    @Getter
    @Setter
    private Boolean hit;
    @Getter
    @Setter
    private Long attemptTime;
    @Getter
    @Setter
    private Double executionTime;

    public HitEntity() {
    }

    public HitEntity(Double x, Double y, Double r, Boolean hit, Long attemptTime, Double executionTime) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
        this.attemptTime = attemptTime;
        this.executionTime = executionTime;
    }
}
