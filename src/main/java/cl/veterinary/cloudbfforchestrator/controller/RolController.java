package cl.veterinary.cloudbfforchestrator.controller;

import cl.veterinary.cloudbfforchestrator.model.Rol;
import cl.veterinary.cloudbfforchestrator.model.User;
import cl.veterinary.cloudbfforchestrator.service.RolService;
import cl.veterinary.cloudbfforchestrator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class RolController {

    @Autowired
    RolService rolService;


    @GetMapping("/findAllRoles")
    public ResponseEntity<List<Rol>> findAllRoles() {
        return ResponseEntity.ok(rolService.findAllRol());
    }

    @GetMapping("/findRolById/{id}")
    public ResponseEntity<Rol> findRolById(@PathVariable Long id ) {
        return ResponseEntity.ok(rolService.findRolById(id));
    }

    @PostMapping("/saveRol")
    public ResponseEntity<Rol> saveRol(@RequestBody Rol rol ) {
        return ResponseEntity.ok(rolService.saveRol(rol));
    }

    @PutMapping("/updateRol/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable Long id,@RequestBody Rol rol ) {
        return ResponseEntity.ok(rolService.updateRol(id,rol));
    }

    @DeleteMapping("/deleteRol/{id}")
    public ResponseEntity<String> deleteRol(@PathVariable Long id) {
        return ResponseEntity.ok(rolService.deleteRol(id));
    }



}
