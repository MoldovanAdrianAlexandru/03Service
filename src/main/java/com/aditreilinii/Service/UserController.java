package com.aditreilinii.Service;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/api/v1/users")
    public List <User> getUsers(){
         return userService.getUsers();
    }
    @PostMapping(path = "/api/v1/users")
    public void createUser(@RequestBody User user){
        userService.validateEmail(user.getEmail());
        userService.createUser(user);
    }

    @PutMapping(path = "/api/v1/users/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user){
        userService.updateUser(id, user);
    }
    @DeleteMapping(path = "/api/v1/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
