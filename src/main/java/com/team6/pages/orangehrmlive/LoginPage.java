package com.team6.pages.orangehrmlive;

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
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
    public //driver.findElement(By.xpath(""))
    WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    public
    WebElement loginBtn;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]")
    WebElement errorMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/h5")
    WebElement loginPageHeader;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")
    WebElement InvalidCredentialMsg;

    //reusable methods

    public void enteringUserNamePassWord(String userName, String passWord){
        enterUsername(userName);
        enterPassword(passWord);
        log.info("Login Success");
    }
    public void enteringUserNamePassWord(){
        enterUsername("Admin");
        enterPassword("admin123");
    }

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
        waitFor(10);
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
        log.info("login page header text is "+ loginPageHeaderText);
        return loginPageHeaderText;
    }

    private void waitFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            log.error("InterruptedException occurred while waiting", e);
        }
    }
}
