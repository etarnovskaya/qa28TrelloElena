package com.elena.qa.tests;

import com.elena.qa.fw.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp() {
        // Capabilities caps = new DesiredCapabilities();
        app.init();
    }




    @AfterSuite(enabled = false)
    public void tearDown() throws InterruptedException {
        app.board().clearBoardList();
        app.stop();
    }




}
