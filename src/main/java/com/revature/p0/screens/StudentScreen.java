package com.revature.p0.screens;

import com.revature.p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class StudentScreen extends Screen{
    public StudentScreen(BufferedReader entryReader, ScreenRouter screenRouter) {
        super("student", entryReader, screenRouter);
    }

    String code;

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
        switch(entry){
            case "1":
                System.out.println("Here are the available classes:\n");
                break;
            case "2":
                System.out.println("Register:\n" +
                        "Enter class code\n");
                code = entryReader.readLine();
                System.out.println("You are registered for " + code + "\n");
                break;
            case "3":
                System.out.println("Enter code for class to drop\n");
                code = entryReader.readLine();
                System.out.println("You have dropped " + code + "\n");
                break;
            case "4":
                System.out.println("Here are your classes\n");
                break;
            case "5":
                screenRouter.navigate("welcome");
                break;
            default:
                System.out.println("Invalid entry\n");
        }
    }
}
