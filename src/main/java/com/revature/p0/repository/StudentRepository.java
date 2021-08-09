package com.revature.p0.repository;

import com.revature.p0.models.Student;

public class StudentRepository {
    public void save(Student student){
        System.out.println("registered " + student.getFirstName());
    }
}
