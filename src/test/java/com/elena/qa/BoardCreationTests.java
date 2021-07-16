package com.elena.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!isAvatarPresent()) {
            login("rochman.elena@gmail.com", "12345.com");
        }
    }


    @Test
    public void boardCreationTest() {
        String boardName = "qa28Board_" + System.currentTimeMillis();

        clickOnPlusButton();
        selectCreateBoard();
        fillBoardCreation(boardName);
        confirmBoardCreation();
        waitForAddListButtonInTheBoard();
        String title = getTitle();
        Assert.assertEquals(title, boardName);
    }



}
