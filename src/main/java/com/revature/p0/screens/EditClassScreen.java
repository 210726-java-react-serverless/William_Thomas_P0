package com.revature.p0.screens;

import com.revature.p0.models.Classes;
import com.revature.p0.services.ClassService;
import com.revature.p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class EditClassScreen extends Screen{
    public EditClassScreen(BufferedReader entryReader, ScreenRouter screenRouter, ClassService classService){
        super("edit", entryReader, screenRouter);
        this.classService = classService;
    }

    ClassService classService;

    @Override
    public void render() throws IOException {
        System.out.println("Enter code of class to edit, ex. ENGL 101");
        String cd = entryReader.readLine();

        System.out.println("Change subject to");
        String subject = entryReader.readLine();

        System.out.println("Change class level to");
        String level = entryReader.readLine();

        System.out.println("Change class description to");
        String description = entryReader.readLine();

        Classes c = new Classes(subject, cd, level, description);

        classService.edit(c, cd);

        System.out.println(cd + " has been changed");

        screenRouter.navigate("faculty");
    }
}
