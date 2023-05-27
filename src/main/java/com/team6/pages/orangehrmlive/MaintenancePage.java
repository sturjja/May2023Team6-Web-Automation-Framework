package com.team6.pages.orangehrmlive;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MaintenancePage extends CommonAPI {
    Logger log = LogManager.getLogger(LoginPage.class.getName());

    public MaintenancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
    WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
    public WebElement passwordField;

    @FindBy(css = "#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(10) > a")
    WebElement maintenance;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/form/div[3]/div/div[2]/input")
    WebElement passFieldMaintence;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/form/div[4]/button[2]")
    WebElement confirmButtonMaintenance;

    // methods

    public void clickMaintenance() {
        clickOn(maintenance);
        log.info("Click on maintenance enter Success");
    }

    public void enterPassForMaintenance(String password) {
        passFieldMaintence.sendKeys(password);
        confirmButtonMaintenance.click();
        log.info("Enter password for maintenance tab  Success");

    }


}
