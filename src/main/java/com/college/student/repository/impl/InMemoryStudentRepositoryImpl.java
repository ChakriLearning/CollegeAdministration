package com.college.student.repository.impl;

import com.college.student.pojo.Student;
import com.college.student.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InMemoryStudentRepositoryImpl implements StudentRepository {
    private List<Student> studentList = new ArrayList<>();
    @Override
    public void addStudent(Student student) {  //adding student in list;
        studentList.add(student);
    }
    @Override
    public List<Student> listStudents() {
        return this.studentList;
    }  //printing/retrieving all the student's from list;
    @Override
    public void deleteStudent(int rollNo) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();       //deleting specific student details from list;
            if(student.getRollNo() == rollNo) {
                iterator.remove();
            }
        }
    }

    @Override
    public void updateStudentByRollNo(int studentRollNoToUpdate,int studentRollNo, String studentName, byte studentAge, long studentPhoneNo) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if(student.getRollNo() == studentRollNoToUpdate) {
                student.setRollNo(studentRollNo);
                student.setName(studentName);
                student.setAge(studentAge);
                student.setPhoneNo(studentPhoneNo);
            }
        }
    }


}
