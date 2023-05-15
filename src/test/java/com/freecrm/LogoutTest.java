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

public class LogoutTest extends CommonAPI {
    WebDriver driver;
    @Test
    public void logOut() {
        Logger log = LogManager.getLogger(LogoutTest.class.getName());

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
        String actualHomePageHeader= driver.findElement(By.xpath("//div[contains(text(),'No items found')]")).getText();
        Assert.assertEquals(expectedHomePageHeader,actualHomePageHeader);
        log.info("User login success");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement userMenuButton = driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/i[1]"));
        userMenuButton.click();
        WebElement logOutButton = driver.findElement(By.xpath("//span[contains(text(),'Log Out')]"));
        logOutButton.click();
        log.info("Click on logout button success");

        WebElement forgotPasswordButton = driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));
        boolean forgotPasswordButtonIsDisplayed = forgotPasswordButton.isDisplayed();
        Assert.assertTrue(forgotPasswordButtonIsDisplayed);
        log.info("Forgot password button is displayed");
    }

}