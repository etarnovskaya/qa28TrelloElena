package com.elena.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTrelloTests extends TestBase {


    @Test
    public void loginLogoutTest() throws InterruptedException {

        clickOnLoginButton();
        fillLoginForm("rochman.elena@gmail.com", "12345.com");
        confirmLogin();

        Assert.assertTrue(isAvatarPresent());

        logout();
        Assert.assertTrue(checkUserLoggedOut());
    }


}
