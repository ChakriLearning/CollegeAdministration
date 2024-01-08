package com.college.student.repository.impl;

import com.college.student.pojo.Student;
import com.college.student.repository.StudentRepository;

import java.util.List;

public class InFileStudentRepositoryImpls  implements StudentRepository {
    @Override
    public List<Student> listStudents() {
        return null;
    }

    @Override
    public void addStudent(Student student) {

    }

    @Override
    public Student deleteStudent(int rollNo) {
        return null;
    }

    @Override
    public Student updateStudentByRollNo(int studentRollNoToUpdate, int studentRollNo, String studentName, byte studentAge, long studentPhoneNo) {
        return null;
    }

    @Override
    public Student getStudentData(int studentRollNo) {
        return null;
    }
}
