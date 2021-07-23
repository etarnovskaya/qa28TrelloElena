package com.elena.qa.tests;

import com.elena.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTrelloTests extends TestBase {
@BeforeMethod
public void preconditions(){
    if(app.getSession().isAvatarPresent()){
        app.getSession().logout();
    }
}

    @Test
    public void loginLogoutTest() throws InterruptedException {

        app.getSession().clickOnLoginButton();
    //    app.getSession().fillLoginForm(new User ("rochman.elena@gmail.com", "12345.com"));
        app.getSession().fillLoginForm(new User()
                .setEmail("rochman.elena@gmail.com")
                .setPassword("12345.com"));
        app.getSession().confirmLogin();

        Assert.assertTrue(app.getSession().isAvatarPresentWait());

        app.getSession().logout();
        Assert.assertTrue(app.getSession().checkUserLoggedOut());
    }

 @Test
    public void negativeLoginWithoutPasswordTest() throws InterruptedException {

        app.getSession().clickOnLoginButton();
    //    app.getSession().fillLoginForm(new User ("rochman.elena@gmail.com", "12345.com"));
        app.getSession().fillLoginForm(new User()
                .setEmail("rochman.elena@gmail.com"));
        app.getSession().confirmLogin();
        Assert.assertTrue(app.getSession().isErrorPresent(), "Error is not present");


    }


}
