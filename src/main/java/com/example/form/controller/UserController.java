package com.example.form.controller;

import com.example.form.entity.User;
import com.example.form.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
        return userService.getOneUserById(userId);
    }
    @PostMapping
    public User creatUser(@RequestBody User newUser){
        return userService.saveOneUser(newUser);
    }
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
    return userService.updateOneUser(userId,newUser);
    }
    @DeleteMapping("/{userId}")
        public void deleteOneUser(@PathVariable Long userId){
            userService.deleteById(userId);

    }


}
