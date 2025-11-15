package org.example.test.utilis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;

public class DriverSelenoid {

    public static WebDriver setup() throws MalformedURLException {

        ChromeOptions options = new ChromeOptions();

        // IMPORTANT pentru Selenium 4 -> fără asta aruncă Illegal key values
        options.addArguments("--no-sandbox");
        options.addArguments("--headless=new");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size=1920,1080");

        // Specific pentru Selenoid
        HashMap<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("name", "GitHub Actions Test");
        selenoidOptions.put("sessionTimeout", "15m");
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableVideo", true);
        selenoidOptions.put("enableLog", true);
        selenoidOptions.put("env", new ArrayList<String>() {{
            add("TZ=UTC");
        }});

        options.setCapability("browserVersion", "128.0");
        options.setCapability("selenoid:options", selenoidOptions);

        // Conectare la Selenoid local din GitHub Actions
        return new RemoteWebDriver(
                URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                options
        );
    }
}
