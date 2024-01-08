package com.college.student.repository.impl;

import com.college.student.exception.InvalidInputException;
import com.college.student.pojo.Student;
import com.college.student.repository.StudentRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InFileStudentRepositoryImpl implements Serializable, StudentRepository {
    private File file;
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private List<Student> studentList;
    public InFileStudentRepositoryImpl() {
        this.file = new File("C:\\Users\\chakr\\IdeaProjects\\CollegeAdministration\\Student.txt");
        studentList = new ArrayList<>();
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.file));
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public List<Student> listStudents() {
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(this.file));
            studentList = (ArrayList<Student>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return studentList;
    }
    @Override
    public void addStudent(Student student) {
        studentList.add(student);
        try{
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.file));
            objectOutputStream.writeObject(studentList);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    @Override
    public Student deleteStudent(int rollNo) {
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(this.file));
            studentList = (ArrayList<Student>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException f) {
            f.printStackTrace();
        }
        int size = studentList.size();
        Iterator<Student> iterator = studentList.iterator();
        Student deletedStudent = null;
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if(student.getRollNo() == rollNo) {
                deletedStudent = student;
                iterator.remove();
            } else {
                size--;
                if(size == 0) throw new InvalidInputException("Student RollNo Not Found");
            }
        }
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.file));
            objectOutputStream.writeObject(studentList);
        } catch (IOException i) {
            i.printStackTrace();
        }
        return deletedStudent;

    }

    @Override
    public Student updateStudentByRollNo(int studentRollNoToUpdate, int studentRollNo, String studentName, byte studentAge, long studentPhoneNo) {
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(this.file));
            studentList = (ArrayList<Student>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        int size = studentList.size();
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
                size--;
                if(size == 0) throw new InvalidInputException("Student RollNo Not Found");
            }
        }
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.file));
            objectOutputStream.writeObject(studentList);
        } catch (IOException i) {
            i.printStackTrace();
        }
        return updatedStudent;
    }

    @Override
    public Student getStudentData(int studentRollNo) {
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(this.file));
            studentList = (ArrayList<Student>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        int size = studentList.size();
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if(student.getRollNo() == studentRollNo) {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.file));
                    objectOutputStream.writeObject(studentList);
                } catch (IOException i){
                    i.printStackTrace();
                }
                return student;
            } else {
                size--;
                if(size == 0) throw new InvalidInputException("Student RollNo Not Found");
            }
        }
        return null;
    }
}
