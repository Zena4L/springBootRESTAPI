package com.clement.springboot.restAPI;

import com.clement.springboot.restAPI.user.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    // JPA/ Hibernate Database
    // UserDao > Static List
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("Clement", 1, LocalDate.now().minusYears(30)));
        users.add(new User("Zena", 2, LocalDate.now().minusYears(10)));
        users.add(new User("Owireku", 3, LocalDate.now().minusYears(15)));
    }
     public List<User> findAll(){
        return users;
     }
    // public User save(User user)
    public User findOne(int id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
