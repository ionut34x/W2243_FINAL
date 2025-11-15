package org.example.test.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPom extends BasicPom {

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login")
    WebElement login;

    public LoginPom(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void setPassword(String passParam) {
        password.clear();
        password.sendKeys(passParam);
    }

    public void setUserName(String userNameParam) {
        userName.clear();
        userName.sendKeys(userNameParam);
    }

    public void setUsername(String firstName) {
        setUserName(firstName);
    }

    public void clickLogin() {
        // 1. Elimină toate iframe-urile (reclame)
        js.executeScript("document.querySelectorAll('iframe').forEach(e => e.remove());");

        // 2. Adduce butonul în view
        js.executeScript("arguments[0].scrollIntoView(true);", login);

        // 3. Forțează click-ul (previne ElementClickIntercepted)
        js.executeScript("arguments[0].click();", login);
    }
}
