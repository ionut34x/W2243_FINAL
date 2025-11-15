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
        options.setCapability("browserVersion", "128.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "GitHub Actions Test");
            put("sessionTimeout", "15m");
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});
            put("enableVideo", true);
            put("enableVNC", true);
            put("enableLog", true);
        }});

        // IMPORTANT: NICI UN HEADLESS AICI!!
        // Chrome trebuie să aibă interfață grafică pentru video.

        return new RemoteWebDriver(
                URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                options
        );
    }
}
