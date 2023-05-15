package com.freecrm;
import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginTest extends CommonAPI {
    Logger log = LogManager.getLogger(LoginTest.class.getName());
    WebDriver driver;

    @Test
    public void validEmail() {
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";

        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);


        WebElement loginLink = driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']"));
        loginLink.click();
        log.info("enter login page");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("awafzaman@gmail.com");
        log.info("Correct username entered");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Takeover2022");
        log.info("Correct password entered");

        driver.findElement(By.xpath("//div[text()='Login']")).click();
        log.info("Click on login Success");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        String expectedHomePageHeader = "No items found";
        String actualHomePageHeader = driver.findElement(By.xpath("//div[contains(text(),'No items found')]")).getText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        log.info("User login success");


    }

    @Test
    public void inValidEmail() {
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);


        WebElement loginLink = driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']"));
        loginLink.click();
        log.info("enter login page");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("invalid email");
        log.info("Correct username entered");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Takeover2022");
        log.info("Correct password entered");

        driver.findElement(By.xpath("//div[text()='Login']")).click();
        log.info("Click on login Success");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        String expectedError = "Something went wrong...";
        String actualError = driver.findElement(By.xpath("//div[contains(text(),'Something went wrong...')]")).getText();
        Assert.assertEquals(expectedError, actualError);
        log.info("Validate error success");


    }

    @Test
    public void missingEmail() {
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);


        WebElement loginLink = driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']"));
        loginLink.click();
        log.info("enter login page");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("");
        log.info("Correct username entered");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Takeover2022");
        log.info("Correct password entered");

        driver.findElement(By.xpath("//div[text()='Login']")).click();
        log.info("Click on login Success");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        String expectedError = "Invalid request";
        String actualError = driver.findElement(By.xpath("//p[contains(text(),'Invalid request')]")).getText();
        Assert.assertEquals(expectedError, actualError);
        log.info("Validate error success");


    }

    @Test
    public void missingPassword() {
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);


        WebElement loginLink = driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']"));
        loginLink.click();
        log.info("enter login page");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("awafzaman@gmail.com");
        log.info("Correct username entered");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("");
        log.info("Correct password entered");

        driver.findElement(By.xpath("//div[text()='Login']")).click();
        log.info("Click on login Success");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        String expectedError = "Invalid request";
        String actualError = driver.findElement(By.xpath("//p[contains(text(),'Invalid request')]")).getText();
        Assert.assertEquals(expectedError, actualError);
        log.info("Validate error success");


    }
}
