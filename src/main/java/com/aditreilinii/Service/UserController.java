package com.aditreilinii.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @GetMapping(path = "/chatPage")
    public String chatPage(){
        return "This will be the chat page.";
    }
    @GetMapping(path = "/api/v1/users")
    public List <User> getUser(){
         return List.of(new User (1L, "foxie", "foxie", "foxie@gmail.com",  "adrian",  "alexandru"),
         new User(2L, "aladin", "aladin", "aladin@gmail.com", "alex", "alex"));

    }

}
