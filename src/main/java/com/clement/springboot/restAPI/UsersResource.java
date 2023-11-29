package com.clement.springboot.restAPI;

import com.clement.springboot.restAPI.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user = service.findOne(id);
        if (user == null){
            throw new UserNotFoundException("id: "+id);
        }
        return user;

    }

    @PostMapping("/users")
        public ResponseEntity<User> createUser(@RequestBody User user){
       var savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
         service.deleteById(id);
    }
}
