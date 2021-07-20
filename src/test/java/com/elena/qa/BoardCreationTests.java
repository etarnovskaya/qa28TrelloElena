package com.elena.qa;

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
    public void boardCreationTest() {
        String boardName = "qa28Board_" + System.currentTimeMillis();

        app.getBoard().clickOnPlusButton();
        app.getBoard().selectCreateBoard();
        app.getBoard().fillBoardCreation(boardName);
        app.getBoard().confirmBoardCreation();
        app.getBoard().waitForAddListButtonInTheBoard();
        String title = app.getBoard().getTitle();
        Assert.assertEquals(title, boardName);
    }

}
