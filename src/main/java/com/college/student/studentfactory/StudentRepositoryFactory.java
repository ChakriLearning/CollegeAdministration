package com.college.student.studentfactory;

import com.college.student.pojo.Student;
import com.college.student.repository.StudentRepository;
import com.college.student.repository.impl.InCSVFileStudentRepositoryImpl;
import com.college.student.repository.impl.InDBRepositoryImplementation;
import com.college.student.repository.impl.InFileStudentRepositoryImpl;
import com.college.student.repository.impl.InMemoryStudentRepositoryImpl;

//this is factory interface;
public class StudentRepositoryFactory {
    public StudentRepository getStudentRepositoryInstance(String storageType) {
        if(storageType == null) return null;
        if(storageType.equals("InMemory") || storageType.equals("inmemory")) {
            return new InMemoryStudentRepositoryImpl();
            //interface       =        //class
        } else if(storageType.equals("FileMemory") || storageType.equals("filememory")){
            return new InFileStudentRepositoryImpl();
        } else if(storageType.equals("csv") || storageType.equals("CSV")) {
            return new InCSVFileStudentRepositoryImpl();
        } else if (storageType.equals("db") || storageType.equals("indb")) {
            return new InDBRepositoryImplementation();
        }
        return null;
    }
}
