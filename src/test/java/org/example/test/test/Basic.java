package org.example.test.test;

import org.example.test.utilis.Driver1;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Basic {

    public WebDriver driver;

    @BeforeClass
    public void beforeTest() {
        driver = Driver1.setup();
    }

    @AfterClass
    public void afterTest() {
        if (driver != null) driver.quit();
    }
}
