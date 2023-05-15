package com.freecrm;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
public class VerifyDashboard extends CommonAPI {
    WebDriver driver;
    Logger log = LogManager.getLogger(VerifyDashboard.class.getName());
    @Test
    public void testDashboardLoadPage(){
        driver.get("https://freecrm.com/");
        driver.findElement(By.xpath("//span[text()='Log In']")).click();
        log.info("enter login page");
        driver.findElement(By.name("email")).sendKeys("awafzaman@gmail.com");
        log.info("Correct email entered");
        driver.findElement(By.name("password")).sendKeys("Takeover2022");
        log.info("Correct password entered");
        driver.findElement(By.xpath("//div[text()='Login']")).click();
        String expectedTitle = "Cogmento CRM";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Validate dashboard success");



    }



}