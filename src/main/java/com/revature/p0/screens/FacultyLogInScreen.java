package com.revature.p0.screens;

import com.revature.p0.services.UserService;
import com.revature.p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class FacultyLogInScreen extends Screen{
    public FacultyLogInScreen(BufferedReader entryReader, ScreenRouter screenRouter, UserService userService){
        super("facultyLogin", entryReader, screenRouter);
        this.userService = userService;
    }

    UserService userService;

    @Override
    public void render() throws IOException {
        System.out.println("Faculty Login Screen:");

        System.out.println("Please enter your username");
        String username = entryReader.readLine();

        System.out.println("Please enter your password");
        String password = entryReader.readLine();

        boolean result = userService.loginFaculty(username, password);

        if(result == true) {
            screenRouter.navigate("faculty", username);
        }else{
            System.out.println("wrong username or password");
            screenRouter.navigate("welcome");
        }
    }
}
