package com.elena.qa;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() {
        // Capabilities caps = new DesiredCapabilities();
        app.init();
    }


    @AfterMethod
    public void tearDown() {
        app.stop();
    }




}
