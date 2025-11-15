package org.example.test.test;

import org.example.test.pom.FormPom;
import org.example.test.utilis.Driver1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormText {

    public WebDriver driver;

    public static String URL = "https://demoqa.com/automation-practice-form";
    public static String FIRST_NAME = "Portarescu";
    public static String LAST_NAME = "Ion";
    public static String EMAIL = "ionut34x@gmail.com";
    public static String GENDER = "Male";
    public static String USER_NUMBER = "0797245144";
    public static String SUBJECT = "Maths";
    public static String HOBBY = "Music";
    public static String STATE = "Rajasthan";
    public static String CITY = "Jaipur";

  
    public static String DOB_DAY = "23 Oct 2025";

    @BeforeClass
    public void beforeTest() {
        driver = Driver1.setup();
        driver.manage().window().maximize();
    }

    @Test
    public void formTest() {

        driver.get(URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        FormPom form = new FormPom(driver);

        
        form.closeAdvert();
        form.setFirstName(FIRST_NAME);
        form.setLastName(LAST_NAME);
        form.setUserEmail(EMAIL);

        driver.findElement(By.xpath("//label[text()='" + GENDER + "']")).click();

        form.scroLlToSubject();
        form.setUserNumber(USER_NUMBER);

        
        form.setDateOfBirthInput(DOB_DAY);

        form.setSubjectsInput(SUBJECT);
        form.scroLlToSubject();

        driver.findElement(By.xpath("//label[text()='" + HOBBY + "']")).click();

        form.setstate(STATE);
        form.setcity(CITY);

        driver.findElement(By.id("submit")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("example-modal-sizes-title-lg"))
        );

       
        String actualName = driver.findElement(By.xpath("//td[text()='Student Name']/following-sibling::td")).getText();
        String actualEmail = driver.findElement(By.xpath("//td[text()='Student Email']/following-sibling::td")).getText();
        String actualGender = driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText();
        String actualNumber = driver.findElement(By.xpath("//td[text()='Mobile']/following-sibling::td")).getText();
        String actualDateOfBirth = driver.findElement(By.xpath("//td[text()='Date of Birth']/following-sibling::td")).getText();
        String actualSubjects = driver.findElement(By.xpath("//td[text()='Subjects']/following-sibling::td")).getText();
        String actualHobbies = driver.findElement(By.xpath("//td[text()='Hobbies']/following-sibling::td")).getText();
        String actualStateCity = driver.findElement(By.xpath("//td[text()='State and City']/following-sibling::td")).getText();

        // =========================
        // NORMALIZARE FORMAT DATA
        // =========================
        String normalizedActualDob = actualDateOfBirth
                .replace(",", "")                                 
                .replaceAll("([A-Za-z]{3})(\\d)", "$1 $2")       
                .replace("January", "Jan")
                .replace("February", "Feb")
                .replace("March", "Mar")
                .replace("April", "Apr")
                .replace("May", "May")
                .replace("June", "Jun")
                .replace("July", "Jul")
                .replace("August", "Aug")
                .replace("September", "Sep")
                .replace("October", "Oct")
                .replace("November", "Nov")
                .replace("December", "Dec")
                .trim();

        
        String normalizedExpectedDob = DOB_DAY.trim();

       
        System.out.println("\n=== DOB DEBUG ===");
        System.out.println("ACTUAL RAW     : [" + actualDateOfBirth + "]");
        System.out.println("ACTUAL NORMAL  : [" + normalizedActualDob + "]");
        System.out.println("EXPECTED NORMAL: [" + normalizedExpectedDob + "]");
        System.out.println("=================\n");

        // =========================
        // ASSERTURI CORECTE
        // =========================
        Assert.assertEquals(actualName, FIRST_NAME + " " + LAST_NAME);
        Assert.assertEquals(actualEmail, EMAIL);
        Assert.assertEquals(actualGender, GENDER);
        Assert.assertEquals(actualNumber, USER_NUMBER);
        Assert.assertEquals(normalizedActualDob, normalizedExpectedDob);  // DOB FIXED
        Assert.assertEquals(actualSubjects, SUBJECT);
        Assert.assertEquals(actualHobbies, HOBBY);
        Assert.assertEquals(actualStateCity, STATE + " " + CITY);
    }

    @AfterClass
    public void afterTest() {
        driver.quit();
    }
}
