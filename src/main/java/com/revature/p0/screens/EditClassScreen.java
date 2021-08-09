package com.revature.p0.screens;

import com.revature.p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class EditClassScreen extends Screen{
    public EditClassScreen(BufferedReader entryReader, ScreenRouter screenRouter){
        super("edit", entryReader, screenRouter);
    }

    @Override
    public void render() throws IOException {
        System.out.println("Enter code of class to edit, ex. ENGL 101");
        String code = entryReader.readLine();

        System.out.println("Change subject to");
        String subject = entryReader.readLine();

        System.out.println("Change class level to");
        String level = entryReader.readLine();

        System.out.println("Change class description to");
        String description = entryReader.readLine();

        System.out.println(code + " has been changed");

        screenRouter.navigate("faculty");
    }
}
