package com.college.student.repository.impl;

import com.college.student.pojo.Student;
import com.college.student.repository.StudentRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.*;
public class InFileStudentRepositoryImpl implements Serializable, StudentRepository {
    private final File file;
    public InFileStudentRepositoryImpl() {
        this.file = new File("C:\\Users\\chakr\\IdeaProjects\\CollegeAdministration\\Student.txt");
    }

    @Override
    public List<Student> listStudents() {
        return readStudentObject();
    }

    @Override
    public void addStudent(Student student) {
        List<Student> studentList = readStudentObject();   //first read the file
        studentList.add(student);  //adding the new student to the existing studentList
        writeStudentObject(studentList); //and write the new studentList to the file  else file will be overwritten everytime add a new student;
    }

    @Override
    public Student deleteStudent(int rollNo) {
        List<Student> studentList = readStudentObject();  //reading the student file first and
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if(student.getRollNo() == rollNo) {
                iterator.remove();             //after deleting the specific student will add the new list again to the file;
                writeStudentObject(studentList);
                return student;
            }
        }
        return null;
    }

    @Override
    public Student updateStudentByRollNo(Student updateStudent) {
        List<Student> studentList = readStudentObject();   //first reading the student object file and assign to the student list;
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if(student.getRollNo() == updateStudent.getRollNo()) {
                student.setRollNo(updateStudent.getRollNo());
                student.setName(updateStudent.getName());
                student.setAge(updateStudent.getAge());
                student.setPhoneNo(updateStudent.getPhoneNo());  //after updating all the values will add the new list to the file again;
                writeStudentObject(studentList);
                return student;
            }
        }
        return null;
    }

    @Override
    public Student getStudentData(int studentRollNo) {
        Iterator<Student> iterator = readStudentObject().iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if(student.getRollNo() == studentRollNo) {
                return student;
            }
        }
        return null;
    }

    public void writeStudentObject(List<Student> studentList) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.file));
            objectOutputStream.writeObject(studentList);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public List<Student> readStudentObject() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(this.file));
            return (List<Student>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return null;
    }
}
