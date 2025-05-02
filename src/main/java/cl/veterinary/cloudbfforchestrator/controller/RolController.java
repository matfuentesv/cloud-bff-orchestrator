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


    @GetMapping("/rest/findAllRoles")
    public ResponseEntity<List<Rol>> findAllRolRest() {
        return ResponseEntity.ok(rolService.findAllRolRest());
    }

    @GetMapping("/rest/findRolById/{id}")
    public ResponseEntity<Rol> findRolByIdRest(@PathVariable Long id ) {
        return ResponseEntity.ok(rolService.findRolByIdRest(id));
    }

    @PostMapping("/rest/saveRol")
    public ResponseEntity<Rol> saveRolRest(@RequestBody Rol rol ) {
        return ResponseEntity.ok(rolService.saveRolRest(rol));
    }

    @PutMapping("/rest/updateRol/{id}")
    public ResponseEntity<Rol> updateRolRest(@PathVariable Long id,@RequestBody Rol rol ) {
        return ResponseEntity.ok(rolService.updateRolRest(id,rol));
    }

    @DeleteMapping("/rest/deleteRol/{id}")
    public ResponseEntity<String> deleteRol(@PathVariable Long id) {
        return ResponseEntity.ok(rolService.deleteRolRest(id));
    }


    @GetMapping("/graphQL/findAllRoles")
    public ResponseEntity<List<Rol>> findAllRolRestQL() {
        return ResponseEntity.ok(rolService.findAllRolGraphQL());
    }

    @GetMapping("graphQL/findRolById/{id}")
    public ResponseEntity<Rol> findRolByIdGraphQL(@PathVariable Long id ) {
        return ResponseEntity.ok(rolService.findRolByIdGraphQL(id));
    }

    @PostMapping("/graphQL/saveRol")
    public ResponseEntity<Rol> saveRolGraphQL(@RequestBody Rol rol ) {
        return ResponseEntity.ok(rolService.saveRolGraphQL(rol));
    }

    @PutMapping("/graphQL/updateRol/{id}")
    public ResponseEntity<Rol> updateRolGraphQL(@PathVariable Long id,@RequestBody Rol rol ) {
        return ResponseEntity.ok(rolService.updateRolGraphQL(id,rol));
    }

    @DeleteMapping("/graphQL/deleteRol/{id}")
    public ResponseEntity<String> deleteRolGraphQL(@PathVariable Long id) {
        return ResponseEntity.ok(rolService.deleteRolGraphQL(id));
    }


}
