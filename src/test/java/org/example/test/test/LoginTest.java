package org.example.test.test;

import org.example.test.pom.LoginPom;
import org.testng.annotations.Test;

public class LoginTest extends Basic {

    public static String URL = "https://demoqa.com/login";
    public static String FIRST_NAME = "Ion";
    public static String PASSW = "Ionut34x#";

    @Test
    public void formTest() throws InterruptedException {

        driver.get(URL);

        LoginPom form = new LoginPom(driver);
        form.setUsername(FIRST_NAME);
        form.setPassword(PASSW);
        form.clickLogin();

        Thread.sleep(3000);
        System.out.println("Test finalizat");
    }
}
