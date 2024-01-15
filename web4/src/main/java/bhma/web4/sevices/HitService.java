package bhma.web4.sevices;

import bhma.web4.exceptions.WrongParamsException;
import bhma.web4.entities.HitEntity;
import org.springframework.stereotype.Service;

@Service
public class HitService {
    public HitEntity check(HitEntity hit) throws WrongParamsException {
        if (hit.getX() == null || hit.getY() == null || hit.getR() == null) {
            throw new WrongParamsException("One or more coordinates are not defined!");
        }
        if (hit.getR() <= 0) {
            throw new WrongParamsException("The radius is not positive!");
        }
        double start = System.nanoTime();
        hit.setAttemptTime(System.currentTimeMillis());
        hit.setHit((hit.getX() <= 0 && hit.getY() <= 0 && hit.getY() >= -hit.getR() - hit.getX())
                || (hit.getX() >= 0 && hit.getY() <= 0 && hit.getY() >= -hit.getR() / 2 && hit.getX() <= hit.getR())
                || (hit.getX() >= 0 && hit.getY() >= 0
                && hit.getY() * hit.getY() + hit.getX() * hit.getX() <= hit.getR() * hit.getR() / 4));
        hit.setExecutionTime(System.nanoTime() - start);
        return hit;
    }
}
