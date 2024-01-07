package com.college.student.repository;

import com.college.student.pojo.Student;

import java.util.List;

public interface StudentRepository {
    void  addStudent(Student student);
    List<Student> listStudents();
   // List<Student> getStudent();

    void deleteStudent(int rollNo);
}
