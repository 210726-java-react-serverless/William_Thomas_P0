package com.revature.p0.util;

import com.revature.p0.repository.ClassRepository;
import com.revature.p0.repository.FacultyRepository;
import com.revature.p0.repository.StudentRepository;
import com.revature.p0.screens.*;
import com.revature.p0.services.ClassService;
import com.revature.p0.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private boolean appRunning = true;
    ScreenRouter screenRouter = new ScreenRouter();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StudentRepository studentRepository = new StudentRepository();
    FacultyRepository facultyRepository = new FacultyRepository();
    ClassRepository classRepository = new ClassRepository();
    UserService userService = new UserService(studentRepository, facultyRepository);
    ClassService classService = new ClassService(classRepository);

    public AppState() {
        this.screenRouter = new ScreenRouter();
        screenRouter.add(new WelcomeScreen(reader, screenRouter))
                    .add(new FacultyScreen(reader, screenRouter, classService))
                    .add(new StudentScreen(reader, screenRouter, classService))
                    .add(new FacultyLogInScreen(reader, screenRouter, userService))
                    .add(new StudentLogInScreen(reader, screenRouter, userService))
                    .add(new StudentRegisterScreen(reader, screenRouter, userService))
                    .add(new AddClassScreen(reader, screenRouter, classService))
                    .add(new EditClassScreen(reader, screenRouter, classService));
    }

    public void starting(){
        screenRouter.navigate("welcome");
        while (appRunning){
            try {
                screenRouter.getActiveScreen().render();
            } catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

}
