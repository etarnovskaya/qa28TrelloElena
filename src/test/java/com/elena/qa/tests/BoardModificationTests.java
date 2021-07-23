package com.elena.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends  TestBase {
   @BeforeMethod
    public void preconditions() throws InterruptedException {
       if (!app.getSession().isAvatarPresent()) {
           app.getSession().login("rochman.elena@gmail.com", "12345.com");
       }
       if(app.getBoard().isThereABoard()){
           app.getBoard().createBoard();
       }
   }

   @Test
    public void boardNameModificationTest(){
       int before = app.getBoard().getBoardsCount();
       app.getBoard().selectFirstBoard();

       app.getBoard().editBoardName("Edited board");
       app.getBoard().returnToHomePage();
       int after = app.getBoard().getBoardsCount();

       Assert.assertEquals(after, before);
   }
}
