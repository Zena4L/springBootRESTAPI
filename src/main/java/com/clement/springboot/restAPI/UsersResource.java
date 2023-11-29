package com.clement.springboot.restAPI;

import com.clement.springboot.restAPI.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersResource {
    private UserDaoService service;
    public UsersResource(UserDaoService service){
        this.service = service;
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return  service.findAll();
    }

    @GetMapping("/users/{id}")
    public User getAUser(@PathVariable int id){
        return service.findOne(id);

    }
}
