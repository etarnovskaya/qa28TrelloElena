package com.elena.qa.tests;

import com.elena.qa.model.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresent()) {
            app.getSession().login("rochman.elena@gmail.com", "12345.com");
        }
    }


    @Test
    public void boardCreationTest() throws InterruptedException {
        String boardName = "qa28Board_" + System.currentTimeMillis();
        Thread.sleep(4000);
        int before = app.getBoard().getBoardsCount();

        app.getBoard().clickOnPlusButton();
        app.getBoard().selectCreateBoard();
        app.getBoard().fillBoardCreation(new Board().setBoardName(boardName));
        app.getBoard().confirmBoardCreation();
        app.getBoard().waitForAddListButtonInTheBoard();
        String title = app.getBoard().getTitle();
        Assert.assertEquals(title, boardName);

        app.getBoard().returnToHomePage();
        Thread.sleep(4000);
        int after = app.getBoard().getBoardsCount();
        Assert.assertEquals(after, before + 1);
    }

}
