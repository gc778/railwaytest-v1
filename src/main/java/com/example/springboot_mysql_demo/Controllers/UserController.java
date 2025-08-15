package com.example.springboot_mysql_demo.Controllers;


import com.example.springboot_mysql_demo.Services.UserService;
import com.example.springboot_mysql_demo.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable  Long id){
        return userService.getUserById(id);
    }

//    @GetMapping("/byEmail/{email}")
//    public User getUserByEmail(String email)
//    {
//        return userService.getUserByEmail(email);
//    }

    @DeleteMapping("/{id}")
    public String deleteUser(Long id)
    {
        userService.deleteUser(id);
        return String.format("user with id: %d has been deleted", id);
    }
}
