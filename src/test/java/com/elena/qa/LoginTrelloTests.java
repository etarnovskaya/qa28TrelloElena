package com.elena.qa;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTrelloTests extends TestBase {


    @Test
    public void loginLogoutTest() throws InterruptedException {

        app.getSession().clickOnLoginButton();
        app.getSession().fillLoginForm("rochman.elena@gmail.com", "12345.com");
        app.getSession().confirmLogin();

        Assert.assertTrue(app.getSession().isAvatarPresentWait());

        app.getSession().logout();
        Assert.assertTrue(app.getSession().checkUserLoggedOut());
    }


}
