package com.college.student.repository.impl;

import com.college.student.exception.InvalidInputException;
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
    public Student deleteStudent(int rollNo) {
        Iterator<Student> iterator = studentList.iterator();
        Student deletedStudent = null;
        while (iterator.hasNext()) {
            Student student = iterator.next();       //deleting specific student details from list;
            if(student.getRollNo() == rollNo) {
                deletedStudent = student;
                iterator.remove();
            } else {
                throw new InvalidInputException("Student RollNo not Found");
            }
        }
        return deletedStudent;
    }

    @Override
    public Student updateStudentByRollNo(int studentRollNoToUpdate,int studentRollNo, String studentName, byte studentAge, long studentPhoneNo) {
        Iterator<Student> iterator = studentList.iterator();
        Student updatedStudent = null;
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if(student.getRollNo() == studentRollNoToUpdate) {
                student.setRollNo(studentRollNo);
                student.setName(studentName);
                student.setAge(studentAge);
                student.setPhoneNo(studentPhoneNo);
                updatedStudent = student;
            } else {
                throw new InvalidInputException("Student RollNo Not Found");
            }
        }
        return updatedStudent;
    }

    @Override
    public Student getStudentData(int studentRollNo) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if(student.getRollNo() == studentRollNo) {
                return student;
            }
        }
        return null;
    }


}
