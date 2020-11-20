package com.gec.pojo;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author Brice
 * @title: User
 * @projectName springDemo
 * @description: TODO
 * @date 2020/11/410:40
 */
//@Component("user")
//@Controller("user")
//@Service("user")
public class User {
      private int id;
    private String name;
    private String password;
    private BigDecimal monkey;

    public User() {
    }

    public User(int id, String name, String password, BigDecimal monkey) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.monkey = monkey;
    }

    public BigDecimal getMonkey() {
        return monkey;
    }

    public void setMonkey(BigDecimal monkey) {
        this.monkey = monkey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", monkey=" + monkey +
                '}';
    }
}
