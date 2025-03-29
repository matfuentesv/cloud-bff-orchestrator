package cl.veterinary.cloudbfforchestrator.controller;

import cl.veterinary.cloudbfforchestrator.model.User;
import cl.veterinary.cloudbfforchestrator.service.OrchestratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class OrchestratorController {

    @Autowired
    OrchestratorService orchestratorService;


    @GetMapping("/findAllUser")
    public ResponseEntity<List<User>> findAllUser() {
        return ResponseEntity.ok(orchestratorService.findAllUser());
    }

    @GetMapping("/findUserById/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id ) {
        return ResponseEntity.ok(orchestratorService.findUserById(id));
    }

    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUser(@RequestBody User user ) {
        return ResponseEntity.ok(orchestratorService.saveUser(user));
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user ) {
        return ResponseEntity.ok(orchestratorService.updateUser(id,user));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(orchestratorService.deleteUser(id));
    }


}
