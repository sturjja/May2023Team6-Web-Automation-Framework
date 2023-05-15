package com.team6.pages.automation.scaledupit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.team6.base.CommonAPI;

public class LoginPage extends CommonAPI {
    Logger log = LogManager.getLogger(LoginPage.class.getName());
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(css = "#username")
    WebElement usernameField;

    @FindBy(css = "#password")
    WebElement passwordField;

    @FindBy(css = "button[name ='login'")
    WebElement loginBtn;

    @FindBy(css = "a[class='my-account']")
    WebElement myAccountBtn;

    @FindBy(xpath = "//*[@id='post-9']/div/div/div[1]/ul/li")
    WebElement errorMessage;

    @FindBy(xpath = "//span[contains(text(),'My account')]")
    WebElement loginPageHeader;

    //reusable methods
    public void enterUsername(String Validusername){
        type(usernameField, Validusername);
        log.info("enter username success");
    }
    public void enterPassword(String Validpassword){
        type(passwordField, Validpassword);
        log.info("enter password success");
    }
    public void clickOnLoginBtn(){
        clickOn(loginBtn);
        log.info("click on login button Success");
    }
    public void clickOnMyAccountBtn(){
        clickOn(myAccountBtn);
        log.info("click on MyAccount button Success");
    }
    public String getErrorMessage(){
        String text = getElementText(errorMessage);
        log.info("get error message text success");
        return text;
    }
    public boolean checkPresenceOfLoginPageHeader(){
        boolean loginPageHeaderIsDisplayed = isVisible(loginPageHeader);
        log.info("login page header is present "+loginPageHeaderIsDisplayed);
        return loginPageHeaderIsDisplayed;
    }
    public String getLoginPageHeaderText(){
        String loginPageHeaderText = getElementText(loginPageHeader);
        log.info("login page header text is "+loginPageHeaderText);
        return loginPageHeaderText;
    }
}
