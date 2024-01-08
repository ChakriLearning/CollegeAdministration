package com.college.student.repository.impl;

import com.college.student.pojo.Student;
import com.college.student.repository.StudentRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InFileStudentRepositoryImpl implements Serializable, StudentRepository {
    private File file;
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    public InFileStudentRepositoryImpl() {
        this.file = new File("C:\\Users\\chakr\\IdeaProjects\\CollegeAdministration\\CollegeAdministration.txt");
//        try {
//            this.fileInputStream = new FileInputStream(this.file);
//            this.fileOutputStream = new FileOutputStream(this.file);
//            this.objectInputStream = new ObjectInputStream(this.fileInputStream);
//            this.objectOutputStream = new ObjectOutputStream(this.fileOutputStream);
//        } catch (IOException i) {
//            i.printStackTrace();
//        }
    }

//    public List<Student> listStudents() {
//        List<Student> studentList = new ArrayList<>();
//        Student student = null;
//        try {
//            objectInputStream = new ObjectInputStream(new FileInputStream(this.file));
//            student = (Student) objectInputStream.readObject();
//            objectInputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        studentList.add(student);
//        return studentList;
//    }

    public List<Student> listStudents() {
        List<Student> studentList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.file))) {
            while (true) {
                try {
                    Student student = (Student) ois.readObject();
                    studentList.add(student);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return studentList;
    }
//    @Override
//    public List<Student> listStudents() {
//        List<Student> studentList = null;
//         try(objectInputStream = new ObjectInputStream(new FileInputStream(this.file))) {
//            while(true) {
//                try {
//                    Student student = (Student)objectInputStream.readObject();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch(Exception e) {
//             e.printStackTrace();
//        }
//        return studentList;
//    }

    @Override
    public void addStudent(Student student) {
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.file,true));
            objectOutputStream.writeObject(student);
//            objectOutputStream.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
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
