package com.revature.p0.services;

import com.revature.p0.models.Student;
import com.revature.p0.repository.StudentRepository;

public class UserService {

    public UserService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    private StudentRepository studentRepository;

    public void registerStudent(Student student){
        studentRepository.save(student);
    }

    public void loginStudent(){

    }

    public void loginFaculty(){

    }
}
