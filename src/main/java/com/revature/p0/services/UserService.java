package com.revature.p0.services;

import com.revature.p0.models.Student;
import com.revature.p0.repository.FacultyRepository;
import com.revature.p0.repository.StudentRepository;

public class UserService {

    public UserService(StudentRepository studentRepository, FacultyRepository facultyRepository){
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }

    private StudentRepository studentRepository;
    private FacultyRepository facultyRepository;

    public boolean registerStudent(Student student){
        boolean sRegister = studentRepository.save(student);
        return sRegister;
    }

    public boolean loginStudent(String username, String password){
        boolean sLogin = studentRepository.login(username, password);
        return sLogin;
    }

    public boolean loginFaculty(String username, String password){
        boolean fLogin = facultyRepository.login(username, password);
        return fLogin;
    }
}
