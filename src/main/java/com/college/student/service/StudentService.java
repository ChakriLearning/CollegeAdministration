//StudentService class will call various method of StudentRepository to perform operations;
package com.college.student.service;

import com.college.student.pojo.Student;
import com.college.student.repository.StudentRepository;
import com.college.student.repository.impl.InMemoryStudentRepositoryImpl;
import java.util.List;
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(int storageType) {
        if(storageType == 1) {
            studentRepository = new InMemoryStudentRepositoryImpl();
            //interface       =        //class
        } else {
           // studentRepository = new InFileStudentRepositoryImpl();
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

    public Student updateStudentDetailsByRollNo(int studentRollNoToUpdate,int studentRollNo, String studentName, byte studentAge, long studentPhoneNo) {
       return this.studentRepository.updateStudentByRollNo(studentRollNoToUpdate,studentRollNo,studentName,studentAge,studentPhoneNo);
    }

    public Student getStudentByRollNo(int studentRollNo) {
        return  this.studentRepository.getStudentData(studentRollNo);
    }
}
