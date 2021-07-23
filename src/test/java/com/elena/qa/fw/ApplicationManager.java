package com.elena.qa.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager{
    WebDriver wd;
    BoardHelper board;
    SessionHelper session;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        openSite("https://trello.com/");
        board = new BoardHelper(wd);
        session = new SessionHelper(wd);
    }


    public void openSite(String url) {
        wd.get(url);
    }

    public BoardHelper getBoard() {
        return board;
    }

    public SessionHelper getSession() {
        return session;
    }

    public void stop() {
        wd.quit();
    }

}