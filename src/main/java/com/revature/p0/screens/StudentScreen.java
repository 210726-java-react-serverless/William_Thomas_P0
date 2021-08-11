package com.revature.p0.screens;

import com.revature.p0.services.ClassService;
import com.revature.p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class StudentScreen extends Screen{
    public StudentScreen(BufferedReader entryReader, ScreenRouter screenRouter, ClassService classService) {
        super("student", entryReader, screenRouter);
        this.classService = classService;
    }

    String username;
    ClassService classService;
    String code;

    @Override
    public void render() throws IOException {
        this.username = screenRouter.username;

        String options = "Hello " + username + ". Welcome to the student screen.\n" +
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
                classService.showAll();
                break;
            case "2":
                System.out.println("Register:\n" +
                        "Enter class code\n");
                String cd = entryReader.readLine();
                classService.register(cd, username);
                System.out.println("You are registered for " + cd + "\n");
                break;
            case "3":
                System.out.println("Enter code for class to drop\n");
                String cod = entryReader.readLine();
                classService.drop(cod, username);
                System.out.println("You have dropped " + cod + "\n");
                break;
            case "4":
                System.out.println("Here are your classes:");
                classService.show(username);
                break;
            case "5":
                screenRouter.navigate("welcome");
                break;
            default:
                System.out.println("Invalid entry\n");
        }
    }
}
