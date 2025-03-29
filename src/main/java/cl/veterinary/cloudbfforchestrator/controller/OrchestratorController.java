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


}
