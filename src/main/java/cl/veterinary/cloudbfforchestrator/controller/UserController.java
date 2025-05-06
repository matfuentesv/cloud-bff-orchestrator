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


    @GetMapping("/rest/findAllUser")
    public ResponseEntity<List<User>> findAllUser() {
        return ResponseEntity.ok(userService.findAllUserRest());
    }

    @GetMapping("/rest/findUserById/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id ) {
        return ResponseEntity.ok(userService.findUserByIdRest(id));
    }

    @PostMapping("/rest/saveUserWithDefaultRole")
    public ResponseEntity<User> saveUserWithDefaultRoleRest(@RequestBody User user ) {
        return ResponseEntity.ok(userService.saveUserWithDefaultRoleRest(user));
    }

    @PostMapping("/rest/saveUser")
    public ResponseEntity<User> saveUser(@RequestBody User user ) {
        return ResponseEntity.ok(userService.saveUserRest(user));
    }


    @PutMapping("/rest/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user ) {
        return ResponseEntity.ok(userService.updateUserRest(id,user));
    }

    @DeleteMapping("/rest/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUserRest(id));
    }

    @DeleteMapping("/rest/deleteRolAndUser/{id}")
    public ResponseEntity<String> deleteRolAndUserRest(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteRolAndUserRest(id));
    }

    @GetMapping("/graphQL/findAllUser")
    public ResponseEntity<List<User>> findAllUserGraphQl() {
        return ResponseEntity.ok(userService.findAllUserGraphQl());
    }

    @GetMapping("/graphQL/findUserById/{id}")
    public ResponseEntity<User> findUserByIdGraphQl(@PathVariable Long id ) {
        return ResponseEntity.ok(userService.findUserByIdGraphQl(id));
    }

    @PostMapping("/graphQL/saveUser")
    public ResponseEntity<User> saveUserGraphQl(@RequestBody User user ) {
        return ResponseEntity.ok(userService.saveUserGraphQl(user));
    }

    @PostMapping("/graphQL/saveUserWithDefaultRole")
    public ResponseEntity<User> saveUserWithDefaultRoleGraphQl(@RequestBody User user ) {
        return ResponseEntity.ok(userService.saveUserWithDefaultRoleGraphQl(user));
    }

    @PutMapping("/graphQL/updateUser/{id}")
    public ResponseEntity<User> updateUserGraphQl(@PathVariable Long id,@RequestBody User user ) {
        return ResponseEntity.ok(userService.updateUserGraphQl(id,user));
    }

    @DeleteMapping("/graphQL/deleteUser/{id}")
    public ResponseEntity<String> deleteUserGraphQl(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUserGraphQl(id));
    }

    @DeleteMapping("/graphQL/deleteRolAndUser/{id}")
    public ResponseEntity<String> deleteRolAndUserGraphQl(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteRolAndUserGraphQl(id));
    }


}
