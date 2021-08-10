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

    public void registerStudent(Student student){
        studentRepository.save(student);
    }

    public void loginStudent(String username, String password){
        studentRepository.login(username, password);
    }

    public void loginFaculty(String username, String password){
        facultyRepository.login(username, password);
    }
}
