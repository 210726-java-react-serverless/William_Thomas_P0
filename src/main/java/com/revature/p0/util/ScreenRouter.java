package com.revature.p0.util;

import com.revature.p0.screens.Screen;

import java.util.HashSet;
import java.util.Set;

public class ScreenRouter {

    private Screen activeScreen;
    private Set<Screen> screens = new HashSet<>();
    public String username;

    public ScreenRouter add(Screen screen){
        screens.add(screen);
        return this;
    }

    public void navigate(String route){
        for (Screen screen : screens){
            if (screen.getRoute().equals(route)){
                activeScreen = screen;
                break;
            }
        }
    }

    public void navigate(String route, String username){
        for (Screen screen : screens){
            if (screen.getRoute().equals(route)){
                activeScreen = screen;
                this.username = username;
                break;
            }
        }
    }

    public Screen getActiveScreen() {
        return activeScreen;
    }
}
