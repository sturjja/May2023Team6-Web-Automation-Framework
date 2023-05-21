package com.team6.pages.freecrm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    @FindBy(xpath = "//input[@type='text' and @name='email' and @placeholder='Email' and @value='']")
    WebElement emailField;
    @FindBy(xpath = "//input[@type='password' and @name='password' and @placeholder='Password' and @value='']")
    WebElement passwordField;
    @FindBy(xpath = "//div[text()='Login']")
    WebElement loginButton;
    @FindBy(xpath = "//div[@class=\"header\" and text()=\"Something went wrong...\"]\n")
    WebElement errorMessage;
    @FindBy(xpath = "//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
    WebElement clickOnLoginButton;

    @FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
    WebElement forgotPasswordButton;

    @FindBy(xpath = "//a[@href=\"https://register.cogmento.com/password/reset/request/?lang=en-GB\" and text()=\"Forgot your password?\"]\n")
    WebElement actualPageHeader;
    @FindBy(xpath = "//span[text()='Log In']")
    WebElement clickOnLoginLink;


    //reusable methods
    public void clickOnloginLink(){
        clickOn(clickOnLoginLink);
        log.info("enter login page");
    }

    public boolean checkActualPageHeader(){
        boolean forgotPasswordButtonIsDisplayed= isVisible(actualPageHeader);
        log.info("login page header found" +forgotPasswordButtonIsDisplayed );
        return forgotPasswordButtonIsDisplayed;
    }
    public String getActualPageHeaderText(){
        String forgotPasswordButtonText= getElementText(actualPageHeader);
        log.info("login page header text is " +forgotPasswordButtonText );
        return forgotPasswordButtonText;
    }

    public void enterEmail(String email){
        type(emailField , email );
        log.info("Correct username entered");
    }

    public void enterPassword(String password){
        type(passwordField , password );
        log.info("Correct password entered");
    }
    public void clickOnLoginButton(){
        clickOn(loginButton);
        log.info("Click on login Success");
    }
    public String getErrorMessage(){
        String text = getElementText(errorMessage);
        log.info("get error message text success");
        return text;
    }


}
