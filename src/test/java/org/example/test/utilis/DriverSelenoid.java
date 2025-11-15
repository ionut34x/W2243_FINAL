package org.example.test.utilis;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSelenoid {

    public static WebDriver setup() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        caps.setVersion("128.0");
        caps.setCapability("enableVNC", true);
        caps.setCapability("enableVideo", true);

        return new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                caps
        );
    }
}
