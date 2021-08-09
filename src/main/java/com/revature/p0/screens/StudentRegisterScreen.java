package com.revature.p0.screens;

import com.revature.p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class StudentRegisterScreen extends Screen{
    public StudentRegisterScreen(BufferedReader entryReader, ScreenRouter screenRouter){
        super("register", entryReader, screenRouter);
    }

    @Override
    public void render() throws IOException {
        System.out.println("Student Register Screen:");

        System.out.println("Please enter your first name");
        String firstname = entryReader.readLine();

        System.out.println("Please enter your last name");
        String lastname = entryReader.readLine();

        System.out.println("Please enter your email");
        String email = entryReader.readLine();
        System.out.println("Please enter your username");
        String username = entryReader.readLine();

        System.out.println("Please enter your password");
        String password = entryReader.readLine();
    }
}
