package bhma.web4.repositories;

import bhma.web4.entities.HitEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HitRepo extends CrudRepository<HitEntity, Long> {
    List<HitEntity> findAll();
}
