package com.revature.p0.screens;

import com.revature.p0.util.ScreenRouter;

import java.io.BufferedReader;

public class FacultyScreen extends Screen {
    public FacultyScreen(BufferedReader entryReader, ScreenRouter screenRouter) {
        super("faculty", entryReader, screenRouter);
    }

    @Override
    public void render() {
        System.out.println("Faculty Screen");
    }
}
