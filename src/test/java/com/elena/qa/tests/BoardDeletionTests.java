package com.elena.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresent()) {
            app.getSession().login("rochman.elena@gmail.com", "12345.com");
        }
    }

    @Test
    public void testBoardDeletion() throws InterruptedException {
        Thread.sleep(4000);
        int before = app.getBoard().getBoardsCount();
        app.getBoard().selectFirstBoard();
        app.getBoard().openMenu();
        app.getBoard().deleteBoard();
        app.getBoard().returnToHomePage();
        Thread.sleep(4000);
        int after = app.getBoard().getBoardsCount();
        Assert.assertEquals(after, before - 1);
    }
}



