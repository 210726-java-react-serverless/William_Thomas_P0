package com.revature.p0.screens;

import com.revature.p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class AddClassScreen extends Screen{
    public AddClassScreen(BufferedReader entryReader, ScreenRouter screenRouter){
        super("add", entryReader, screenRouter);
    }


    @Override
    public void render() throws IOException {
        System.out.println("Enter class code, ex. ENGL 101");
        String code = entryReader.readLine();

        System.out.println("Enter subject");
        String subject = entryReader.readLine();

        System.out.println("Enter class level");
        String level = entryReader.readLine();

        System.out.println("Enter class description");
        String description = entryReader.readLine();

        System.out.println(code + " has been added");

        screenRouter.navigate("faculty");
    }
}
