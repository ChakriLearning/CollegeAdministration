package com.college.student.pojo;
//POJO-plain old java object's
//it's to store the student data;
public class Student {
    private int rollNo;
    private String name;
    private byte age;
    private long phoneNo;
    public int getRollNo() {
        return this.rollNo;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() { return this.age; }
    public long getPhoneNo() {
        return this.phoneNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(byte age) {
        this.age = age;
    }
    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String toString() {
        return getRollNo() + "  " + getName() + "  " + getAge() + "  " + getPhoneNo();
    }
}
