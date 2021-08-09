package com.revature.p0.screens;

import com.revature.p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class FacultyScreen extends Screen {
    public FacultyScreen(BufferedReader entryReader, ScreenRouter screenRouter) {
        super("faculty", entryReader, screenRouter);
    }

    @Override
    public void render() throws IOException {
        String options = "Faculty Screen\n" +
                "1) Add a Class\n" +
                "2) Edit a Class\n" +
                "3) Remove a Class\n" +
                "4) Return to Welcome Screen\n";
        System.out.println(options);
        String entry = entryReader.readLine();
        if (entry.equals("4")) screenRouter.navigate("welcome");
    }
}
