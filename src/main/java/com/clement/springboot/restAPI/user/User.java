package com.clement.springboot.restAPI.user;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


public class User {


    private String name;
    private int id;
    private LocalDate birthDate;

    public User(String name, Integer id, LocalDate birthDate) {
        this.name = name;
        this.id = id;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", birthDate=" + birthDate +
                '}';
    }
}
