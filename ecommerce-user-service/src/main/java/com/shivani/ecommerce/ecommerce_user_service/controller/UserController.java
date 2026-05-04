package com.shivani.ecommerce.ecommerce_user_service.controller;

import com.shivani.ecommerce.ecommerce_user_service.entity.User;
import com.shivani.ecommerce.ecommerce_user_service.model.UserResponseDTO;
import com.shivani.ecommerce.ecommerce_user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveuser")
    public ResponseEntity<Long> saveuser(@RequestBody User user) {
        long id = userService.saveuser(user);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping("/getuser/{id}")
    public ResponseEntity<UserResponseDTO> getuser(@PathVariable long id) {
        UserResponseDTO fetcheduser = userService.getuser(id);
        return ResponseEntity.ok(fetcheduser);
    }

    @GetMapping("/getusers")
    public ResponseEntity<List<UserResponseDTO>> getAllUser() {
        List<UserResponseDTO> fetchedusers = userService.getalluser();
        return ResponseEntity.ok(fetchedusers);
    }

    // ✅ FIX: keep DTO but works fine
    @PutMapping("/updateuser/{id}")
    public ResponseEntity<String> updateUser(@PathVariable long id,
                                             @RequestBody UserResponseDTO user) {
        userService.updateUser(id, user);
        return ResponseEntity.ok("User updated successfully");
    }

    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}