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

    @FindBy(css = "button[name ='save_account_details'")
    WebElement saveChangesBtn;

    @FindBy(xpath = "//*[@id=\"post-9\"]/div/div/nav/ul/li[6]")
    WebElement logoutLink;

    @FindBy(xpath = "//input[@id=\"account_email\"]")
    WebElement emailField;
    @FindBy(xpath = "//input[@id=\"password_current\"]")
    WebElement currentPasswordField;
    @FindBy(xpath = "//input[@id=\"password_1\"]")
    WebElement newPasswordField;

    @FindBy(xpath = "//input[@id=\"password_2\"]")
    WebElement confirmPasswordField;

    @FindBy(xpath = "//*[@id=\"menu-item-282\"]")
    WebElement menCollectionBtn;
    @FindBy(xpath = "//*[@id=\"main\"]/ul/li[1]")
    WebElement beltLink;
    @FindBy(xpath = "//*[@id=\"product-197\"]/div[2]/form/button")
    WebElement addToCartBtn;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div")
    WebElement confirmationMessage;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div/a")
    WebElement viewCartBtn;
    @FindBy(xpath = "//*[@id=\"coupon_code\"]")
    WebElement couponCodeField;
    @FindBy(xpath = "//*[@id=\"post-7\"]/div/div/form/table/tbody/tr[2]/td/div/button")
    WebElement applyCouponBtn;

    @FindBy(xpath = "//*[@id=\"post-7\"]/div/div/div[1]/ul/li")
    WebElement cartErrorMessage;

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
    public void clearEmailField(){
        emailField.clear();
        log.info("clear email field success");
    }
    public void enterNewEmail(String newEmail){
        type(emailField, newEmail);
        log.info("enter new email success");
    }
    public void enterCurrentPassword(String newPassword){
        type(currentPasswordField, newPassword);
        log.info("enter current password success");
    }
    public void enterNewPassword(String newPassword){
        type(newPasswordField, newPassword);
        log.info("enter new password success");
    }
    public void confirmNewPassword(String newPassword){
        type(confirmPasswordField, newPassword);
        log.info("confirm new password success");
    }
    public void clickOnSaveChangesBtn(){
        clickOn(saveChangesBtn);
        log.info("click on login button Success");
    }
    public void clickOnMenCollectionBtn(){
        clickOn(menCollectionBtn);
        log.info("click on Men Collection Button success");
    }
    public void clickOnBelt(){
        clickOn(beltLink);
        log.info("click on Belt link success");
    }
    public void clickOnAddToCart(){
        clickOn(addToCartBtn);
        log.info("click on Add To Cart Button success");
    }
    public String getConfirmationMessage(){
        String text = getElementText(confirmationMessage);
        log.info("get confirmation message text success");
        return text;
    }
    public void clickOnViewCartBtn(){
        clickOn(viewCartBtn);
        log.info("click on View Cart button Success");
    }
    public void enterCouponCode(String couponCode){
        type(couponCodeField, couponCode);
        log.info("enter coupon code success");
    }
    public void clickOnApplyCouponBtn(){
        clickOn(applyCouponBtn);
        log.info("click on Apply Coupon button Success");
    }
    public String getErrorMessage(){
        String text = getElementText(cartErrorMessage);
        log.info("get Error message text success");
        return text;
    }


}
