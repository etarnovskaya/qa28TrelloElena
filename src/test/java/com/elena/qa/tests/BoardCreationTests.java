package com.elena.qa.tests;

import com.elena.qa.model.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.session().isAvatarPresent()) {
            app.session().login("rochman.elena@gmail.com", "12345.com");
        }
    }


    @Test
    public void boardCreationTest() throws InterruptedException {
        String boardName = "qa28Board_" + System.currentTimeMillis();
        Thread.sleep(4000);
        int before = app.board().getBoardsCount();

        app.board().clickOnPlusButton();
        app.board().selectCreateBoard();
        app.board().fillBoardCreation(new Board().withBoardName(boardName));
        app.board().confirmBoardCreation();
        app.board().waitForAddListButtonInTheBoard();
        String title = app.board().getTitle();
        Assert.assertEquals(title, boardName);

        app.board().returnToHomePage();
        Thread.sleep(4000);
        int after = app.board().getBoardsCount();
        Assert.assertEquals(after, before + 1);
    }

}
