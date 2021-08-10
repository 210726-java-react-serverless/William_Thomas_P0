package com.revature.p0.screens;

import com.revature.p0.models.Student;
import com.revature.p0.services.UserService;
import com.revature.p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class StudentLogInScreen extends Screen{

    public StudentLogInScreen(BufferedReader entryReader, ScreenRouter screenRouter, UserService userService){
        super("studentLogin", entryReader, screenRouter);
        this.userService = userService;
    }

    UserService userService;

    @Override
    public void render() throws IOException {
        System.out.println("Student Login Screen:");

        System.out.println("Please enter your username");
        String username = entryReader.readLine();

        System.out.println("Please enter your password");
        String password = entryReader.readLine();

        userService.loginStudent(username, password);
        screenRouter.navigate("student");
    }

}
