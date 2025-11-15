package org.example.test.utilis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver1 {

    public static WebDriver setup() {
        ChromeOptions options = new ChromeOptions();

        // Capabilități necesare pentru Selenoid
        options.setCapability("enableVNC", true);
        options.setCapability("enableVideo", true);

        try {
            return new RemoteWebDriver(
                    new URL("http://localhost:4444/wd/hub"),
                    options
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException("Selenoid URL invalid!", e);
        }
    }
}
