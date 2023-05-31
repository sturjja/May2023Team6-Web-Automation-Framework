package com.team6.pages.automation.scaledupit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.team6.base.CommonAPI;

public class RegisterPage extends CommonAPI {
    Logger log = LogManager.getLogger(RegisterPage.class.getName());
    public RegisterPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(xpath = "//*[@id=\"post-9\"]/header/h1")
    WebElement emailField ;
    @FindBy(xpath = "//*[@id=\"post-9\"]/div/div/div/div[2]/div[1]/header/a")
    WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"billing_first_name\"]")
    WebElement registerBtn ;

    public void enterEmail(String newEmail){
        type(emailField, newEmail);
        log.info("enter new email success");
    }
    public void enterPassword(String validPassword){
        type(passwordField, validPassword);
        log.info("enter password success");
    }
    public void clickOnRegisterBtn(){
        clickOn(registerBtn);
        log.info("click on register button Success");
    }
}
