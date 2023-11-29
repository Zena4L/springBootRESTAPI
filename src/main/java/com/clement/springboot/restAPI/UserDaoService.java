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
    private static final List<User> users = new ArrayList<>();
    private static int userCount = 0;

    static {
        users.add(new User("Clement", ++userCount, LocalDate.now().minusYears(30)));
        users.add(new User("Zena", ++userCount, LocalDate.now().minusYears(10)));
        users.add(new User("Owireku", ++userCount, LocalDate.now().minusYears(15)));
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

    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteById(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
