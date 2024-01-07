package com.college.student.controller;

import com.college.student.pojo.Student;
import com.college.student.service.StudentService;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdmissionController {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int storageType = storageTypeOption();
        StudentService studentService = new StudentService(storageType);
        int choice = Integer.MAX_VALUE;
        while (true) {
            choice = displayStudentChoices();
            switch (choice) {
                case 1 :
                    Student student = new Student();
                   System.out.print("\nEnter Student RollNo : ");
                   int rollNo = scanner.nextInt();
                   scanner.nextLine();
                   System.out.print("\nEnter Student Name : ");
                   String name = scanner.nextLine();
                   System.out.print("\nEnter Student Age : ");
                   int age = scanner.nextInt();
                   scanner.nextLine();
                   System.out.print("\nEnter Student phoneNumber : ");
                   long phoneNo = scanner.nextLong();
                   scanner.nextLine();
                   student.setRollNo(rollNo);
                   student.setName(name);
                   student.setAge(age);
                   student.setPhoneNo(phoneNo);
                   studentService.addStudent(student);
                   System.out.println("-------------Student details added Successfully-------------");
                   break;
                case 2 :
                    System.out.println("\n-------------List of Students---------------");
                    List<Student> studentList = studentService.listStudents();
                    for(Student student1 : studentList) {
                        System.out.println(student1);
                    }
                    System.out.println("-------------List of Students---------------");
                    break;
                case 3 :
                    System.out.print("\nEnter Student Roll No to delete from Student List : ");
                    rollNo = scanner.nextInt();
                    scanner.nextLine();
                    studentService.deleteStudentByRollNo(rollNo);
                case 0 :
                    System.exit(0);
            }
        }
    }
    public static int storageTypeOption() {
        System.out.println("****************Welcome to College Administration***************");
        System.out.println("where do you want to save the data ?");
        System.out.println("1. InMemory");
        System.out.println("2. File Memory");
        System.out.print("Enter Option : ");
        int storageType = scanner.nextInt();
        scanner.nextLine();
        return storageType;
    }
    public static int displayStudentChoices() {
        System.out.println("1. Add Student Info\n2. Display All Students data");
        System.out.println("3.delete specific student data\n4.update specific student data");
        System.out.print("Enter Option : ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}
