package com.bigdata.entity;

public class Emp {
    private int id;
    private String username;
    private double salary;
    private int age;
    private String face;
    private int depid;

    public Emp() {
    }

    public Emp(String username, double salary, int age, String face, int depid) {
        this.username = username;
        this.salary = salary;
        this.age = age;
        this.face = face;
        this.depid = depid;
    }

    public Emp(int id, String username, double salary, int age, String face, int depid) {
        this.id = id;
        this.username = username;
        this.salary = salary;
        this.age = age;
        this.face = face;
        this.depid = depid;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public int getDepid() {
        return depid;
    }

    public void setDepid(int depid) {
        this.depid = depid;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", face='" + face + '\'' +
                ", depid=" + depid +
                '}';
    }
}
