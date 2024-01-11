package com.college.student.repository.impl;

import com.college.student.utils.DatabaseConnector;
import com.college.student.pojo.Student;
import com.college.student.repository.StudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InDBRepositoryImplementation implements StudentRepository {
    private String dbURL;
    private String dbUsername;
    private  String dbPassword;
    private DatabaseConnector databaseConnector;
    public Connection connectToDatabase() {
        // url = "jdbc:mysql://hostname:port/databasename";
        this.dbURL = "jdbc:mysql://127.0.0.1:3306/collegeadministration";
        this.dbUsername = "root";
        this.dbPassword = "student@1234";
        this.databaseConnector = new DatabaseConnector(this.dbURL,this.dbUsername,this.dbPassword);
        return databaseConnector.connectToDatabase();
    }
    @Override
    public List<Student> listStudents() {
        String query = "select * from student";
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connectToDatabase().prepareStatement(query);
            ResultSet resultset = preparedStatement.executeQuery(query);
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
    public void addStudent(@org.jetbrains.annotations.NotNull Student student) {
        String query = "insert into student values(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connectToDatabase().prepareStatement(query);
            preparedStatement.setInt(1,student.getRollNo());
            preparedStatement.setString(2,student.getName());
            preparedStatement.setByte(3,student.getAge());
            preparedStatement.setLong(4,student.getPhoneNo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student deleteStudent(int rollNo) {
        String selectQuery = "select * from student where rollNo = ?";
        String deleteQuery = "delete from student where rollNo = ?";
        Student student = new Student();
        try {
            PreparedStatement preparedStatement = connectToDatabase().prepareStatement(selectQuery);
            preparedStatement.setInt(1,rollNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                student.setRollNo(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getByte(3));
                student.setPhoneNo(resultSet.getLong(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement = connectToDatabase().prepareStatement(deleteQuery);
            preparedStatement.setInt(1,rollNo);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Student updateStudentByRollNo(Student student) {
        String query = "update student set name = ?, age = ?, phoneNo = ? where rollNo = ?";
        try {
            PreparedStatement preparedStatement = connectToDatabase().prepareStatement(query);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setByte(2,student.getAge());
            preparedStatement.setLong(3,student.getPhoneNo());
            preparedStatement.setLong(4,student.getRollNo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Student getStudentData(int studentRollNo) {
        String selectQuery = "select * from student where rollNo = ?";
        Student student = new Student();
        try {
            PreparedStatement preparedStatement = connectToDatabase().prepareStatement(selectQuery);
            preparedStatement.setInt(1,studentRollNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                student.setRollNo(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getByte(3));
                student.setPhoneNo(resultSet.getLong(4));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isExist(int rollNo) {
        return getStudentData(rollNo) != null;
    }
}
