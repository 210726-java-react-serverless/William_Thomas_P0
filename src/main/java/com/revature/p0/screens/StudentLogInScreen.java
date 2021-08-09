package com.revature.p0.screens;

import com.revature.p0.util.ScreenRouter;

import java.io.BufferedReader;

public class StudentLogInScreen extends Screen{

    public StudentLogInScreen(BufferedReader entryReader, ScreenRouter screenRouter){
        super("studentLogin", entryReader, screenRouter);
    }

    @Override
    public void render(){
        System.out.println("Student Login");
    }

}
