package com.college.student.controller;

import com.college.student.pojo.Student;
import com.college.student.service.StudentService;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdmissionController {
    private static Scanner scanner = new Scanner(System.in);
    private static int studentRollNo;
    private static String studentName;
    private static byte studentAge;
    private static long studentPhoneNo;
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
                   studentRollNo = scanner.nextInt();
                   scanner.nextLine();
                   System.out.print("\nEnter Student Name : ");
                   studentName = scanner.nextLine();
                   System.out.print("\nEnter Student Age : ");
                   studentAge = scanner.nextByte();
                   scanner.nextLine();
                   System.out.print("\nEnter Student phoneNumber : ");
                   studentPhoneNo = scanner.nextLong();
                   scanner.nextLine();
                   student.setRollNo(studentRollNo);
                   student.setName(studentName);
                   student.setAge(studentAge);
                   student.setPhoneNo(studentPhoneNo);
                   studentService.addStudent(student);
                   System.out.println("-------------Student details added Successfully-------------");
                   break;
                case 2 :
                    System.out.println("\n-------------List of Students---------------");
                    List<Student> studentList = studentService.listStudents();
                    for(Student student1 : studentList) {
                        System.out.println(student1);
                    }
                    System.out.println("-------------List of Students---------------\n");
                    break;
                case 3 :
                    System.out.print("\nEnter Student Roll No to delete from Student List : ");
                    studentRollNo = scanner.nextInt();
                    scanner.nextLine();
                    studentService.deleteStudentByRollNo(studentRollNo);
                    System.out.println("--------------Student details deleted Successfully From List----------------");
                    break;
                case 4 :
                    System.out.print("\nEnter student RollNo to Update From List : ");
                    int studentRollNoToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\nEnter new Student RollNo to Update : ");
                    studentRollNo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("\nEnter new Student Name to Update : ");
                    studentName = scanner.nextLine();
                    System.out.print("\nEnter new Student Age to Update : ");
                    studentAge = scanner.nextByte();
                    scanner.nextLine();
                    System.out.print("\nEnter new Student phoneNumber to Update : ");
                    studentPhoneNo = scanner.nextLong();
                    scanner.nextLine();
                    studentService.updateStudentDetailsByRollNo(studentRollNoToUpdate, studentRollNo,studentName,studentAge,studentPhoneNo);
                    System.out.println("-----------------Student Details Updated Successfully----------------");
                    break;
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
        System.out.println("3.delete specific student data\n4.update specific student details\n0. '0' for EXIT" );
        System.out.print("Enter Option : ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}
