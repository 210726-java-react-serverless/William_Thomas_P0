package com.revature.p0.screens;

import com.revature.p0.models.Classes;
import com.revature.p0.services.ClassService;
import com.revature.p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class AddClassScreen extends Screen{
    public AddClassScreen(BufferedReader entryReader, ScreenRouter screenRouter, ClassService classService){
        super("add", entryReader, screenRouter);
        this.classService = classService;
    }

    ClassService classService;

    @Override
    public void render() throws IOException {
        System.out.println("Enter class code, ex. ENGL 101");
        String clCode = entryReader.readLine();

        System.out.println("Enter subject");
        String subject = entryReader.readLine();

        System.out.println("Enter class level");
        String level = entryReader.readLine();

        System.out.println("Enter class description");
        String description = entryReader.readLine();

        Classes c = new Classes(subject, clCode, level, description);
        classService.add(c);

        System.out.println(clCode + " has been added");

        screenRouter.navigate("faculty");
    }
}
