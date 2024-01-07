package com.college.student.repository;

import com.college.student.pojo.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> listStudents();
    void  addStudent(Student student);

   // List<Student> getStudent();

    void deleteStudent(int rollNo);
   // void updateStudentDetailsByRollNo(int studentRollNo, String studentName, byte studentAge, long studentPhoneNo);

    void updateStudentByRollNo(int studentRollNoToUpdate,int studentRollNo, String studentName, byte studentAge, long studentPhoneNo);

}
