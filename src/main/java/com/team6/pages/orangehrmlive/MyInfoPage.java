package com.team6.pages.orangehrmlive;


import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyInfoPage extends CommonAPI {
    Logger log = LogManager.getLogger(HomepagePage.class.getName());

    public MyInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[6]/a[1]")
    WebElement MyInfo;

    @FindBy(name = "firstName")
    WebElement firstNameField;

    @FindBy(name = "lastName")
    WebElement lastNameField;


    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[5]/button")
    WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p")
    WebElement ProfileName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/h6")
    WebElement firstNameLastName;

    //SeleniumMethods

//    public void enterLastName(String lastName) {
//        waitFor(10);
//        clearAndType(lastNameField, lastName);
//    }

    public void clickOnMyInfo() {
        clickOn(MyInfo);
        waitFor(2);
        log.info("Click on My Info Success");

    }

    public void enterFirstAndLastName(String firstName, String lastName){
        ClearText(firstNameField);
        firstNameField.sendKeys(firstName);
        ClearText(lastNameField);
        lastNameField.sendKeys(lastName);
        log.info("First and last name enter Success");

    }

    public void ClearText(WebElement element) {
        int length = element.getAttribute("value").length();
        for (int i = 0; i < length; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void clickOnSave() {
        saveButton.click();
        clickOnMyInfo();
        log.info("Click on save Success");
    }

    public String firstNameLastName(){
        return firstNameLastName.getText();
    }

    public String accountName() {
        return ProfileName.getText();
    }

    private void waitFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            log.error("InterruptedException occurred while waiting", e);
        }
    }
}



