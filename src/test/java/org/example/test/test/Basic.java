package org.example.test.test;

import org.example.test.utilis.Driver1;
import org.example.test.utilis.DriverSelenoid;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Basic {

    public WebDriver driver;

    @BeforeClass
    public void beforeTest() throws Exception {

        String env = System.getProperty("env", "local");
        System.out.println(">>> Current ENV = " + env);

        // Dacă rulează în GitHub Actions → SELENOID
        if (env.equals("github")) {
            System.out.println(">>> Running tests on SELENOID (GitHub Actions)");
            driver = DriverSelenoid.setup();
        }

        // Dacă rulează local → Chrome normal
        else {
            System.out.println(">>> Running tests LOCALLY");
            driver = Driver1.setup();
        }
    }

    @AfterClass
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}
