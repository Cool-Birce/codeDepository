package com.gec.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Brice
 * @title: User
 * @projectName Test
 * @description: TODO
 * @date 2020/10/26 15:11
 */
public class User {
    private int id;
    private String userName;
    private String userPassword;
    private String userUrl;
    private Set<Car> cars=new HashSet<>();

    public User() {
    }

    public User(int id, String userName, String userPassword, String userUrl) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userUrl = userUrl;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public User(String userName, String userPassword, String userUrl) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userUrl = userUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userUrl='" + userUrl + '\'' +
                '}';
    }
}
