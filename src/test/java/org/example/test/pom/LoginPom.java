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
        js = (JavascriptExecutor) driver;
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
        login.click();
    }
}
