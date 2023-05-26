package com.team6.pages.orangehrmlive;


import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyInfoPage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());

    public MyInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(css = "#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(6) > a")
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
        waitFor(5);
        log.info("Click on My Info Success");

    }

    public void enterFirstAndLastName(String firstName, String lastName){
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        log.info("First and last name enter Success");

    }

    public void clickOnSave() {
        saveButton.click();
        waitFor(5);
        getDriver().navigate().refresh();
        waitFor(10);
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



