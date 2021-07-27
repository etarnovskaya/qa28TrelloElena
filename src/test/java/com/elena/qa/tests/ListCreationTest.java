package com.elena.qa.tests;

import com.elena.qa.model.List;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ListCreationTest extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.session().isAvatarPresent()) {
            app.session().login("rochman.elena@gmail.com", "12345.com");
        }
        if(app.board().isThereABoard()){
            app.board().createBoard();
        }
    }

    @Test
    public void testListCreation(){
        app.board().selectFirstBoard();
        app.list().addNew();
        app.list().typeName(new List().withName("autoTest"));
        app.list().saveEdit();

    }
}
