package bhma.web4.controllers;

import bhma.web4.exceptions.WrongParamsException;
import bhma.web4.entities.HitEntity;
import bhma.web4.repositories.HitRepo;
import bhma.web4.sevices.HitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hits")
public class HitController {
    @Autowired
    private HitService hitService;
    @Autowired
    private HitRepo hitRepo;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public List<HitEntity> getHits() {
        return hitRepo.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<?> add(@RequestBody HitEntity hit) {
        try {
            HitEntity savedHit = hitRepo.save(hitService.check(hit));
            return new ResponseEntity<>(savedHit, HttpStatus.OK);
        } catch (WrongParamsException e) {
            return ResponseEntity.badRequest().body("{\"error\": \"" + e.getMessage() + "\"}");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("{\"error\": \"Your coordinates aren't numbers!\"}");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping
    public ResponseEntity<?> clear() {
        try {
            hitRepo.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("{\"error\": \"Your coordinates aren't numbers!\"}");
        }
    }
}
