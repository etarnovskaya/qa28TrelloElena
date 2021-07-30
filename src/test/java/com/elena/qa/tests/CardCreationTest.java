package com.elena.qa.tests;

import com.elena.qa.model.Card;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CardCreationTest extends TestBase{
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.session().isAvatarPresent()) {
            app.session().login("rochman.elena@gmail.com", "12345.com");
        }
        if(!app.board().isOnTheBoardsPage()){
            app.board().returnToHomePage();
        }

        Thread.sleep(3000);
        if(!app.board().isThereABoard()){
            app.board().createBoard();
        }

    }

    @Test
    public void testListCreation(){
        app.board().selectFirstBoard();
        //if(isThereAList()){createList()}
        app.card().addNew();
        app.card().fillForm(new Card().withName("withLable").withColor("yellow"));
        app.card().confirmCreation();
      //  app.card().addNew();
        app.card().fillForm(new Card().withName("withoutLable"));
        app.card().confirmCreation();

    }
}
