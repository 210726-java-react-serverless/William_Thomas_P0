package com.revature.p0.screens;

import com.revature.p0.util.ScreenRouter;

import java.io.BufferedReader;

public class StudentScreen extends Screen{
    public StudentScreen(BufferedReader entryReader, ScreenRouter screenRouter) {
        super("/student", entryReader, screenRouter);
    }

    @Override
    public void render(){
        System.out.println("Student Screen");
    }
}
