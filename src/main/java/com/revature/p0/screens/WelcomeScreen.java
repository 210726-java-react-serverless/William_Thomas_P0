package com.revature.p0.screens;

import com.revature.p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class WelcomeScreen extends Screen{
    public WelcomeScreen(BufferedReader entryReader, ScreenRouter screenRouter) {
        super("welcome", entryReader, screenRouter);
    }


    @Override
    public void render() throws IOException {
        String options = "Welcome to our portal.\n" +
                "1) Register Student Account\n" +
                "2) Sign in as Student\n" +
                "3) Sign in as Faculty\n";
        System.out.println(options);
        String entry = entryReader.readLine();

        switch(entry){
            case "1":
                screenRouter.navigate("2");
                break;
        }
    }

}
