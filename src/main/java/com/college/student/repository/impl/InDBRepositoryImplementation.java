package com.college.student.repository.impl;

import com.college.student.dbconnector.DatabaseConnector;
import com.college.student.pojo.Student;
import com.college.student.repository.StudentRepository;
import com.mysql.cj.protocol.Resultset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InDBRepositoryImplementation implements StudentRepository {
    private final String dbURL;
    private final String dbUsername;
    private final String dbPassword;
    private DatabaseConnector databaseConnector;
    public InDBRepositoryImplementation() {
        // url = "jdbc:mysql://hostname:port/databasename";
        this.dbURL = "jdbc:mysql://127.0.0.1:3306/collegeadministration";
        this.dbUsername = "root";
        this.dbPassword = "student@1234";
        this.databaseConnector = new DatabaseConnector(this.dbURL,this.dbUsername,this.dbPassword);
    }
    @Override
    public List<Student> listStudents() {
        String query = "select * from student";
        List<Student> studentList = new ArrayList<>();
        try {
            Statement statement = databaseConnector.conectToDatabase().createStatement();
            ResultSet resultset = statement.executeQuery(query);
            while (resultset.next()) {
                Student student = new Student();
                student.setRollNo(resultset.getInt(1));
                student.setName(resultset.getString(2));
                student.setAge(resultset.getByte(3));
                student.setPhoneNo(resultset.getLong(4));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public void addStudent(Student student) {
//        String query = "insert into student " +
//                "values ("+student.getRollNo() + "," + student.getName() + "," + student.getAge() + "," + student.getPhoneNo() + ")";
//        try {
//            Statement statement = databaseConnector.conectToDatabase().createStatement();
//            ResultSet resultSet = statement.executeUpdate(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public Student deleteStudent(int rollNo) {
        return null;
    }

    @Override
    public Student updateStudentByRollNo(Student student) {
        return null;
    }

    @Override
    public Student getStudentData(int studentRollNo) {
        Student student = new Student();
        String query = "select * from student where rollNo = " + studentRollNo;
        try {
            Statement statement = databaseConnector.conectToDatabase().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            student.setRollNo(resultSet.getInt(1));
            student.setName(resultSet.getString(1));
            student.setAge(resultSet.getByte(3));
            student.setPhoneNo(resultSet.getLong(4));
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isExist(int rollNo) {
        return false;
    }
}
