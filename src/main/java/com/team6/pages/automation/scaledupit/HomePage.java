package com.team6.pages.automation.scaledupit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.team6.base.CommonAPI;

public class HomePage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(xpath = "//span[contains(text(),'My account')]")
    WebElement mainHeader;

    @FindBy(xpath = "//*[@id=\"post-9\"]/div/div/nav/ul/li[5]/a")
    WebElement accountDetailBtn;

    @FindBy(xpath = "//*[@id=\"post-9\"]/div/div/nav/ul/li[6]")
    WebElement logoutLink;

    //reusable methods
    public String getHeaderText(){
        String text = getElementText(mainHeader);
        log.info("user logged in success");
        return text;
    }
    public void clickOnAccountDetailBtn(){
        clickOn(accountDetailBtn);
        log.info("click on Account Detail Button success");
    }
    public void clickOnLogoutLink(){
        clickOn(logoutLink);
        log.info("click on logout link success");
    }

}
