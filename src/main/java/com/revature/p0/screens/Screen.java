package com.revature.p0.screens;

import com.revature.p0.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class Screen {

    protected String route;
    protected BufferedReader entryReader;
    protected ScreenRouter screenRouter;

    public Screen(String route, BufferedReader entryReader, ScreenRouter screenRouter){
        this.route = route;
        this.entryReader = entryReader;
        this.screenRouter = screenRouter;
    }

    public String getRoute() {
        return route;
    }

    public BufferedReader getReader() {
        return entryReader;
    }

    public void setRoute(String route) {
        this.route = route;
    }
    public abstract void render() throws IOException;
}
