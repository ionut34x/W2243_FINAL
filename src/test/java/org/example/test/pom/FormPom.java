package org.example.test.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class FormPom {

    WebDriver driver;

    public FormPom(WebDriver driver) {
        this.driver = driver;
    }

    public void closeAdvert() {
        try {
            driver.switchTo().frame("google_ads_iframe");
        } catch (Exception e) {}
        driver.switchTo().defaultContent();
    }

    public void setFirstName(String txt) {
        driver.findElement(By.id("firstName")).sendKeys(txt);
    }

    public void setLastName(String txt) {
        driver.findElement(By.id("lastName")).sendKeys(txt);
    }

    public void setUserEmail(String email) {
        driver.findElement(By.id("userEmail")).sendKeys(email);
    }

    public void setGender(String gender) {
        driver.findElement(By.xpath("//label[text()='" + gender + "']")).click();
    }

    public void setUserNumber(String number) {
        driver.findElement(By.id("userNumber")).sendKeys(number);
    }


    public void setDateOfBirthInput(String dateFull) {

      
        String[] parts = dateFull.split(" ");
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];

        driver.findElement(By.id("dateOfBirthInput")).click();

        WebElement yearSelect = driver.findElement(By.className("react-datepicker__year-select"));
        yearSelect.click();
        yearSelect.sendKeys(year);
        yearSelect.sendKeys(Keys.ENTER);

        WebElement monthSelect = driver.findElement(By.className("react-datepicker__month-select"));
        monthSelect.click();
        monthSelect.sendKeys(month);
        monthSelect.sendKeys(Keys.ENTER);

      
        WebElement daySelect = driver.findElement(By.xpath(
                "//div[contains(@class,'react-datepicker__day') and not(contains(@class,'outside-month')) and text()='" + Integer.parseInt(day) + "']"
        ));
        daySelect.click();
    }

    public void setSubjectsInput(String subject) {
        WebElement sub = driver.findElement(By.id("subjectsInput"));
        sub.sendKeys(subject);
        sub.sendKeys(Keys.ENTER);
    }

    public void setHobbies(String h) {
        driver.findElement(By.xpath("//label[text()='" + h + "']")).click();
    }

    public void setstate(String state) {
        driver.findElement(By.id("react-select-3-input")).sendKeys(state);
        driver.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
    }

    public void setcity(String city) {
        driver.findElement(By.id("react-select-4-input")).sendKeys(city);
        driver.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);
    }

    public void clickSubmit() {
        WebElement sb = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", sb);
    }

    public void scroLlToSubject() {
        WebElement el = driver.findElement(By.id("subjectsInput"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", el);
    }
}
