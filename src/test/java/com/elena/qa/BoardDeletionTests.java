package com.elena.qa;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends  TestBase{
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresent()) {
            app.getSession().login("rochman.elena@gmail.com", "12345.com");
        }
    }

    @Test
    public void testBoardDeletion() throws InterruptedException {
        Thread.sleep(4000);
        int boardsCount = app.getBoard().getBoardsCount();
        while (boardsCount>1) {
            app.getBoard().selectFirstBoard();
            app.getBoard().openMenu();
            app.getBoard().deleteBoard();
            app.getBoard().returnOnHomePage();
            Thread.sleep(4000);
            boardsCount = app.getBoard().getBoardsCount();
        }
    }


}
