//StudentService class will call various method of StudentRepository to perform operations;
package com.college.student.service;

import com.college.student.pojo.Student;
import com.college.student.repository.StudentRepository;
import com.college.student.repository.impl.InFileStudentRepositoryImpl;
import com.college.student.repository.impl.InMemoryStudentRepositoryImpl;
import java.util.List;
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(String storageType) {
        if(storageType.equals("InMemory") || storageType.equals("inmemory")) {
            studentRepository = new InMemoryStudentRepositoryImpl();
            //interface       =        //class
        } else if(storageType.equals("FileMemory") || storageType.equals("filememory")){
           studentRepository = new InFileStudentRepositoryImpl();
        }
    }

    public void addStudent(Student student) {
        this.studentRepository.addStudent(student);
    }
    public List<Student> listStudents() {
        return this.studentRepository.listStudents();
    }

    public Student deleteStudentByRollNo(int rollNo) {
        return this.studentRepository.deleteStudent(rollNo);
    }

    public Student updateStudentDetailsByRollNo(Student updateStudent) {
       return this.studentRepository.updateStudentByRollNo(updateStudent);
    }

    public Student getStudentByRollNo(int studentRollNo) {
        return  this.studentRepository.getStudentData(studentRollNo);
    }
}
