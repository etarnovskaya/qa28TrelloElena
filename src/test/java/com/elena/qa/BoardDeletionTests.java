package com.elena.qa;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends  TestBase{
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!isAvatarPresent()) {
            login("rochman.elena@gmail.com", "12345.com");
        }
    }

    @Test
    public void testBoardDeletion() throws InterruptedException {
        Thread.sleep(4000);
        int boardsCount = getBoardsCount();
        while (boardsCount>1) {
            selectFirstBoard();
            openMenu();
            deleteBoard();
            returnOnHomePage();
            Thread.sleep(4000);
            boardsCount = getBoardsCount();
        }

    }

    private void returnOnHomePage() {
        waitForElement(By.cssSelector("[data-test-id*=header-home]"), 30);
        click(By.cssSelector("[data-test-id*=header-home]"));
    }

    private void deleteBoard() {
        if(!isElementDisplayed(By.cssSelector(".js-open-more"))) {
            click(By.cssSelector(".icon-back"));
        }
        click(By.cssSelector(".js-open-more"));
        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm"));
        click(By.cssSelector(".js-delete"));
        click(By.cssSelector(".js-confirm"));
    }

    private void openMenu() {
        if(isElementDisplayed(By.cssSelector(".js-show-sidebar"))) {
            click(By.cssSelector(".js-show-sidebar"));
        }
    }

    private int getBoardsCount() {
     return   wd.findElements(By.xpath("//*[contains(@class, 'boards-page-board-section-header-icon-default-image')]/../../../..//li")).size()-1;
    }

    private void selectFirstBoard() {
        click(By.xpath("//*[contains(@class, 'boards-page-board-section-header-icon-default-image')]/../../../..//li"));
    }


}
