package com.revature.p0.util;

import com.revature.p0.screens.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private boolean appRunning = true;
    ScreenRouter screenRouter = new ScreenRouter();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public AppState() {
        this.screenRouter = new ScreenRouter();
        screenRouter.add(new WelcomeScreen(reader, screenRouter))
                    .add(new FacultyScreen(reader, screenRouter))
                    .add(new StudentScreen(reader, screenRouter))
                    .add(new FacultyLogInScreen(reader, screenRouter))
                    .add(new StudentLogInScreen(reader, screenRouter))
                    .add(new StudentRegisterScreen(reader, screenRouter));
    }

    public void starting(){
        screenRouter.navigate("welcome");
        while (appRunning){
            try {
                screenRouter.getActiveScreen().render();
            } catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

}
