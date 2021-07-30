package com.elena.qa.tests;

import com.elena.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTrelloTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        if (app.session().isAvatarPresent()) {
            app.session().logout();
        }
    }

    @Test
    public void loginTest() throws InterruptedException {

        app.session().clickOnLoginButton();
        //    app.getSession().fillLoginForm(new User ("rochman.elena@gmail.com", "12345.com"));
        app.session().fillLoginForm(new User()
                .withEmail("rochman.elena@gmail.com")
                .withPassword("12345.com"));
        app.session().confirmLogin();

        Assert.assertTrue(app.session().isAvatarPresentWait());
    }

    @Test
    public void logoutTest()  {
        app.session().logout();
        Assert.assertTrue(app.session().checkUserLoggedOut());
    }

    @Test
    public void negativeLoginWithoutPasswordTest() throws InterruptedException {

        app.session().clickOnLoginButton();
        //    app.getSession().fillLoginForm(new User ("rochman.elena@gmail.com", "12345.com"));
        app.session().fillLoginForm(new User()
                .withEmail("rochman.elena@gmail.com"));
        app.session().confirmLogin();
        Assert.assertTrue(app.session().isErrorPresent(), "Error is not present");


    }


}
