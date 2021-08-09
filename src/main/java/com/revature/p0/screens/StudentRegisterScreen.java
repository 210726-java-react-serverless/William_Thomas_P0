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
        System.out.println("register");
    }
}
