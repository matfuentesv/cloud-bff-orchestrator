package cl.veterinary.cloudbfforchestrator.controller;

import cl.veterinary.cloudbfforchestrator.model.User;
import cl.veterinary.cloudbfforchestrator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/findAllUser")
    public ResponseEntity<List<User>> findAllUser() {
        return ResponseEntity.ok(userService.findAllUser());
    }

    @GetMapping("/findUserById/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id ) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUser(@RequestBody User user ) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user ) {
        return ResponseEntity.ok(userService.updateUser(id,user));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }


}
