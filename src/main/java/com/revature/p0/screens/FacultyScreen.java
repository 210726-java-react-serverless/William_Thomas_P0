package com.revature.p0.screens;

import com.revature.p0.services.ClassService;
import com.revature.p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class FacultyScreen extends Screen {
    public FacultyScreen(BufferedReader entryReader, ScreenRouter screenRouter, ClassService classService) {
        super("faculty", entryReader, screenRouter);
        this.classService = classService;
    }

    String username;
    ClassService classService;

    @Override
    public void render() throws IOException {
        this.username = screenRouter.username;

        String options = "Hello " + username + ". Welcome to the faculty Screen\n" +
                "1) Add a Class\n" +
                "2) Edit a Class\n" +
                "3) Remove a Class\n" +
                "4) Return to Welcome Screen\n";
        System.out.println(options);
        String entry = entryReader.readLine();
        switch (entry){
            case "1":
                screenRouter.navigate("add");
                break;
            case "2":
                screenRouter.navigate("edit");
                break;
            case "3":
                System.out.println("Enter code of class to remove\n");
                String cd = entryReader.readLine();
                classService.remove(cd);
                System.out.println(cd + " has been removed\n");
                break;
            default:
                System.out.println("Invalid entry\n");
        }
        if (entry.equals("4")) screenRouter.navigate("welcome");
    }
}
