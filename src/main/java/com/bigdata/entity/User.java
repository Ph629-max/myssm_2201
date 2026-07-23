package com.bigdata.entity;

public class User {
    private Integer id;
    private String username;
    private String password;
    private int gender;
    private String regTime;

    public User() {
    }

    public User(String username, String password, int gender, String regTime) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.regTime = regTime;
    }

    public User(Integer id, String username, String password, int gender, String regTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.regTime = regTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", regTime='" + regTime + '\'' +
                '}';
    }
}
