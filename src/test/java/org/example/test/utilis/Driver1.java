package org.example.test.utilis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver1 {

    public static WebDriver setup() {
        ChromeOptions options = new ChromeOptions();

        // Pentru local
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        return new ChromeDriver(options);
    }
}
