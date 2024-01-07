package com.college.student.service;

import com.college.student.pojo.Student;
import com.college.student.repository.StudentRepository;
import com.college.student.repository.impl.InMemoryStudentRepositoryImpl;

import java.util.List;

public class StudentService {

    private int storageType;
    private StudentRepository studentRepository;
    public StudentService(int storageType) {
        if(storageType == 1) {
            studentRepository = new InMemoryStudentRepositoryImpl();
            //interface       =        //class
        }
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }
    public List<Student> listStudents() {
        return studentRepository.listStudents();
    }

    public void deleteStudentByRollNo(int rollNo) {
        studentRepository.deleteStudent(rollNo);
    }

    public void updateStudentDetailsByRollNo(int studentRollNoToUpdate,int studentRollNo, String studentName, byte studentAge, long studentPhoneNo) {
        studentRepository.updateStudentByRollNo(studentRollNoToUpdate,studentRollNo,studentName,studentAge,studentPhoneNo);
    }

    public Student getStudentByRollNo(int studentRollNo) {
        return  studentRepository.getStudentData(studentRollNo);
    }
}
