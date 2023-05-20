package com.team6.pages.placeholder;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonAPI {
    Logger log = LogManager.getLogger(LoginPage.class.getName());
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(css = "#user-name") //driver.findElement(By.xpath(""))
    WebElement usernameField;

    @FindBy(css = "#password")
    WebElement passwordField;

    @FindBy(css = "#login-button")
    WebElement loginBtn;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]")
    WebElement errorMessage;

    @FindBy(xpath = "//div[contains(text(),'Swag Labs')]")
    WebElement loginPageHeader;

    //reusable methods
    public void enterUsername(String username){
        type(usernameField, username);
        log.info("enter username success");
    }
    public void enterPassword(String password){
        type(passwordField, password);
        log.info("enter password success");
    }
    public void clickOnLoginBtn(){
        clickOn(loginBtn);
        log.info("click on login button Success");
    }
    public String getErrorMessage(){
        String text = getElementText(errorMessage);
        log.info("get error message text success");
        return text;
    }
    public boolean checkPresenceOfLoginPageHeader(){
        boolean loginPageHeaderIsDisplayed = isVisible(loginPageHeader);
        log.info("login page header presence "+loginPageHeaderIsDisplayed);
        return loginPageHeaderIsDisplayed;
    }
    public String getLoginPageHeaderText(){
        String loginPageHeaderText = getElementText(loginPageHeader);
        log.info("login page header text is "+loginPageHeaderText);
        return loginPageHeaderText;
    }
}
