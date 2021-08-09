package com.revature.p0.screens;

import com.revature.p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class FacultyLogInScreen extends Screen{
    public FacultyLogInScreen(BufferedReader entryReader, ScreenRouter screenRouter){
        super("facultyLogin", entryReader, screenRouter);
    }


    @Override
    public void render() throws IOException {
        System.out.println("Faculty Login Screen:");

        System.out.println("Please enter your username");
        String username = entryReader.readLine();

        System.out.println("Please enter your password");
        String password = entryReader.readLine();

        screenRouter.navigate("faculty");
    }
}
