package com.college.student.repository.impl;

import com.college.student.pojo.Student;
import com.college.student.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class InMemoryStudentRepositoryImpl implements StudentRepository {
    private List<Student> studentList = new ArrayList<>();
    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }
    @Override
    public List<Student> listStudents() {
        return this.studentList;
    }
    @Override
    public void deleteStudent(int rollNo) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if(student.getrollNo() == rollNo) {
                iterator.remove();
            }
        }
    }
}
