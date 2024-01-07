package com.college.student.pojo;

public class Student {
    private int rollNo;
    private String name;
    private int age;
    private long phoneNo;
    public int getrollNo() {
        return this.rollNo;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public long getPhoneNo() {
        return this.phoneNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String toString() {
        return getrollNo() + "  " + getName() + "  " + getAge() + "  " + getPhoneNo();
    }
}
