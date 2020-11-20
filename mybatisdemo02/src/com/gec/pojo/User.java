package com.gec.pojo;

/**
 * @author Brice
 * @title: User
 * @projectName mybatisdemo02
 * @description: TODO
 * @date 2020/10/308:59
 */
public class User {
    private int id;
    private String userName;
    private String userPassword;
    private String userUrl;

    public User() {
    }

    public User(int id, String userName, String userPassword, String userUrl) {
        this.id = id;
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
