package org.example.test.utilis;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver1 {

    public static WebDriver setup() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");

       
        opt.addArguments("--headless=new");
        opt.addArguments("--no-sandbox");
        opt.addArguments("--disable-dev-shm-usage");
        opt.addArguments("--disable-gpu");
        opt.addArguments("--disable-infobars");
        opt.addArguments("--disable-extensions");
        opt.addArguments("--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(opt);
        return driver;
    }
}
