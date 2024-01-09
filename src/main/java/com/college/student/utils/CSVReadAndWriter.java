package com.college.student.utils;

import com.college.student.pojo.Student;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReadAndWriter {
    private final File file;
    public CSVReadAndWriter(File file) {
        this.file = file;
    }
    public void writeHeadings() {

    }
    public Student updateStudent(Student student) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.file));
            File tempFile = new File(file.getAbsolutePath().replace(".csv","_temp.csv"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile,true));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] filed = line.split(",");
                int stuRollNo = Integer.parseInt(filed[0]);
                if(stuRollNo == student.getRollNo()) {
                    line = String.format("%d,%s,%d,%d",student.getRollNo(),student.getName(),(int)student.getAge(),
                            (int)student.getPhoneNo());
                }
                //add line to csv;
                try {
                    writer.write(line + "\n");
                    writer.flush();
                } catch (IOException i) {
                    i.printStackTrace();
                }
            }
           // this.file.delete();
            tempFile.renameTo(this.file);
        } catch (IOException i) {
            i.printStackTrace();
        }
        return null;
    }

    public Student deleteStudent(int rollNo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.file));
            File tempFile = new File(file.getAbsolutePath().replace(".csv","_temp.csv"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile,true));
            String line = null;
            Student student = new Student();
            while ((line = reader.readLine()) != null) {
                String[] filed = line.split(",");
                int stuRollNo = Integer.parseInt(filed[0]);
                if(stuRollNo != rollNo) {
                    //add line to csv;
                    try {
                        writer.write(line + "\n");
                        writer.flush();
                    } catch (IOException i) {
                        i.printStackTrace();
                    }
                } else {
                    student.setRollNo(Integer.parseInt(filed[0]));
                    student.setName(filed[1]);
                    student.setAge(Byte.parseByte(filed[2]));
                    student.setPhoneNo(Long.parseLong(filed[3]));
                }
            }
            // this.file.delete();
            tempFile.renameTo(this.file);
            return student;
        } catch (IOException i) {
            i.printStackTrace();
        }
        return null;
    }
    public Student getStudentByRollNo(int rollNo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                Student student = new Student();
                String[] filed = line.split(",");
                int stuRollNo = Integer.parseInt(filed[0]);
                if(stuRollNo == rollNo) {
                    student.setRollNo(Integer.parseInt(filed[0]));
                    student.setName(filed[1]);
                    student.setAge(Byte.parseByte(filed[2]));
                    student.setPhoneNo(Long.parseLong(filed[3]));
                    return student;
                }
            }
        } catch (IOException i) {
            i.printStackTrace();
        }
        return null;
    }
    public List<Student> readStudents() {
        List<Student> studentList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                Student student = new Student();
                 String[] filed = line.split(",");
                 student.setRollNo(Integer.parseInt(filed[0]));
                 student.setName(filed[1]);
                 student.setAge(Byte.parseByte(filed[2]));
                 student.setPhoneNo(Long.parseLong(filed[3]));
                 studentList.add(student);
            }
        } catch (IOException i) {
            i.printStackTrace();
        }
        return studentList;
    }
    public void writeStudent(Student student) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.file,true));
            String line = String.format("%d,%s,%d,%d",student.getRollNo(),student.getName(),(int)student.getAge(),(int)student.getPhoneNo());
            writer.write(line + "\n");
            writer.flush();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
