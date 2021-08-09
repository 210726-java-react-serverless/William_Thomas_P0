package com.revature.p0.screens;

import com.revature.p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class StudentScreen extends Screen{
    public StudentScreen(BufferedReader entryReader, ScreenRouter screenRouter) {
        super("student", entryReader, screenRouter);
    }

    @Override
    public void render() throws IOException {
        String options = "Student Screen:\n" +
                "1) View All Classes\n" +
                "2) Register for a Class\n" +
                "3) Drop a Class\n" +
                "4) View Your Classes\n" +
                "5) Return to Welcome Screen";
        System.out.println(options);
        String entry = entryReader.readLine();
        if (entry.equals("5")) screenRouter.navigate("welcome");
    }
}
