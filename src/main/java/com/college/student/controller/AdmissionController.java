//controller(main class) - interface to the user/programmer

package com.college.student.controller;

import com.college.student.pojo.Student;
import com.college.student.repository.StudentRepository;
//import com.college.student.service.StudentService;
import com.college.student.studentfactory.StudentRepositoryFactory;

import java.util.List;
import java.util.Scanner;
public class AdmissionController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentRollNo;
        String studentName;
        byte studentAge;
        long studentPhoneNo;
        String storageType = storageTypeOption(scanner);
//        StudentService studentService = new StudentService(storageType);
        StudentRepositoryFactory studentRepositoryFactory = new StudentRepositoryFactory();
        StudentRepository studentRepository = studentRepositoryFactory.getStudentRepositoryInstance(storageType);
        int choice = Integer.MAX_VALUE;
        while (true) {
            choice = displayStudentChoices(scanner,choice);
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
                  // studentService.addStudent(student);
                    studentRepository.addStudent(student);
                   System.out.println("-------------Student details added Successfully-------------");
                   break;
                case 2 :
                    System.out.println("\n-------------List of Students---------------");
                    System.out.println(" RollNo |  Name  |  Age  |  PhoneNo");
                    List<Student> studentList = studentRepository.listStudents();
                    for(Student student1 : studentList) {
                        System.out.println(student1);
                    }
                    System.out.println("-------------List of Students---------------\n");
                    break;
                case 3 :
                    System.out.print("\nEnter Student Roll No to delete from Student List : ");
                    studentRollNo = scanner.nextInt();
                    scanner.nextLine();
                    if(studentRepository.isExist(studentRollNo)) {
                        Student deletedStudent = studentRepository.deleteStudent(studentRollNo);
                        System.out.println("below Student Detail : ");
                        System.out.println(" RollNo |  Name  |  Age  |  PhoneNo");
                        System.out.println(deletedStudent);
                        System.out.println("--------------Has Been deleted Successfully From List----------------");
                    } else {
                        System.out.println("Student rollNo doesn't Exits !  Please Enter the Correct RollNo !!!");
                    }

                    break;
                case 4 :
                    student = new Student();    //created a new student object
                    System.out.print("\nEnter student RollNo to Update From List : ");
                    studentRollNo = scanner.nextInt();
                    scanner.nextLine();
                    if(studentRepository.isExist(studentRollNo)) {
                        System.out.print("\nEnter new  Name to Update : ");
                        studentName = scanner.nextLine();
                        System.out.print("\nEnter new Age to Update : ");
                        studentAge = scanner.nextByte();
                        scanner.nextLine();
                        System.out.print("\nEnter new  phoneNumber to Update : ");
                        studentPhoneNo = scanner.nextLong();
                        scanner.nextLine();
                        student.setRollNo(studentRollNo);
                        student.setName(studentName);
                        student.setAge(studentAge);
                        student.setPhoneNo(studentPhoneNo);
                        Student updatedStudent = studentRepository.updateStudentByRollNo(student);
                        System.out.println("Below Student detail :");
                        System.out.println(" RollNo |  Name  |  Age  |  PhoneNo");
                        System.out.println(updatedStudent);
                        System.out.println("-----------------Has Been Updated Successfully----------------");
                    } else {
                        System.out.println("Student RollNo not Found, Please Enter a Valid RollNo !!!");
                    }

                    break;
                case 5 :
                    System.out.print("Enter rollNo to get the Student Data : ");
                    studentRollNo = scanner.nextInt();
                    scanner.nextLine();
                    if(studentRepository.isExist(studentRollNo)) {
                        Student studentDetail = studentRepository.getStudentData(studentRollNo);
                        System.out.println("-------------Student--------------");
                        System.out.println(" RollNo |  Name  |  Age  |  PhoneNo");
                        System.out.println(studentDetail);
                        System.out.println("-------------Student--------------");
                    } else {
                        System.out.println("Student RollNo not Found, Please Enter a Valid RollNo !!!");
                    }
                    break;
                case 0 :
                    System.exit(0);
                default:
                   System.out.println("Invalid choice");
            }
        }
    }
    public static String storageTypeOption(Scanner scanner) {
        System.out.println("****************Welcome to College Administration***************");
        System.out.println("where do you want to save the data ?");
        System.out.println("1. InMemory  || inmemory");
        System.out.println("2. FileMemory || filememory");
        System.out.println("3. CSV || csv");
        System.out.println("4.Indb || db implementation");
        System.out.print("Enter Option : ");
        return scanner.nextLine();
    }
    public static int displayStudentChoices(Scanner scanner,int choice) {
        System.out.println("1. Add Student In List\n2. Display All Students data");
        System.out.println("3.delete specific student data\n4.update specific student details" );
        System.out.println("5. Get specific student data by rollNo\n0. '0' for EXIT");
        System.out.print("Enter Option : ");
        choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}
