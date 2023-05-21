package com.team6.pages.freecrm;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSettingsPage extends CommonAPI {
    Logger log = LogManager.getLogger(AccountSettingsPage.class.getName());
    public AccountSettingsPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"settings icon\"]\n")
    WebElement settingsSettingButton;
    @FindBy(xpath = "//a[@class=\"active item\"]\n")
    WebElement settingsAccountButton;
    @FindBy(xpath = "//a[@class=\"item\"]\n")
    WebElement changePasswordButton;
    @FindBy(xpath = "//input[@name=\"oldPassword\" and @type=\"password\"]\n")
    WebElement oldPasswordField;
    @FindBy(xpath = "//input[@name='newPassword' and @type='text' and @value='']\n")
    WebElement newPasswordField;
    @FindBy(xpath = "//input[@name='newPasswordConfirm' and @type='text' and @value='']\n")
    WebElement newPasswordConfirmField;
    @FindBy(xpath = "//button[@class='ui linkedin small button' and text()='Submit']\n")
    WebElement changedPasswordSubmitButton;
    @FindBy(xpath = "//input[@name='address' and @autocomplete='new-password' and @type='text' and @value='']\n")
    WebElement companyAddressField;
    @FindBy(xpath = "//input[@name='city' and @autocomplete='new-password' and @type='text' and @value='']\n")
    WebElement companyAddressCityField;
    @FindBy(xpath = "//input[@name='zip' and @autocomplete='new-password' and @type='text' and @value='']\n")
    WebElement companyAddressZipCodeField;
    @FindBy(xpath = "//input[@name='state' and @autocomplete='new-password' and @type='text' and @value='']\n")
    WebElement companyAddressStateField;
    @FindBy(xpath = "//button[@class='ui button' and text()='Save']\n")
    WebElement companyAddressSaveButton;
    @FindBy(xpath = "//a[@class='item' and text()='User Manager']\n")
    WebElement accountSettingsUserManagerButton;
    @FindBy(xpath = "//div[@class='ui button' and i[@class='plus icon'] and text()='Add New User']\n")
    WebElement addNewUserManagerButton;
    @FindBy(xpath = "//input[@name='first_name' and @placeholder='First Name' and @autocomplete='new-password' and @type='text' and @value='']\n")
    WebElement newUserManagerFirstNameField;
    @FindBy(xpath = "//input[@name='last_name' and @placeholder='Last Name' and @autocomplete='new-password' and @type='text' and @value='']\n")
    WebElement newUserManagerLastNameField;
    @FindBy(xpath = "//input[@name='email' and @autocomplete='new-password' and @type='text' and @value='']\n")
    WebElement newUserManagerEmailField;
    @FindBy(xpath = "//button[@class='ui linkedin small button' and i[@aria-hidden='true' and @class='save small icon'] and text()='Save']\n")
    WebElement newUserInfoSaveButton;

    public void clickOnNewUserManagerSaveButton(){
        clickOn(newUserInfoSaveButton);
        log.info("new user manager  info is saved");
    }

    public void typeOnNewUserEmailField(String newValidEmail){
        type(newUserManagerEmailField, newValidEmail );
    }

    public void typeOnNewUserLastNameField(String validLastName){
        type(newUserManagerLastNameField, validLastName);
    }

    public void typeOnNewUserFirstNameField(String validFirstName){
        type(newUserManagerFirstNameField, validFirstName);
    }

    public void clickOnAddNewUserManagerButton(){
        clickOn(addNewUserManagerButton);
        log.info("new user manager is added");
    }

    public void clickOnSettingsUserManagerButton(){
        clickOn(accountSettingsUserManagerButton);
        log.info("user manager settings is accessed");
    }

    public void clickOnCompanyAddressSaveButton(){
        clickOn(companyAddressSaveButton);
        log.info("company address info is saved");
    }

    public void typeOnCompanyAddressStateField(String companyState){
        type(companyAddressStateField, companyState);
    }

    public void typeOnCompanyAddressZipCodeField(String zipCode){
        type(companyAddressZipCodeField, zipCode);
    }

    public void typeOnCompanyAddressCityField(String companyCity){
        type(companyAddressCityField, companyCity);
    }

    public void typeOnCompanyAddressField(String companyAddress){
        type(companyAddressField , companyAddress);
    }

    public void clickOnChangedPasswordSubmitButton(){
        clickOn(changedPasswordSubmitButton);
        log.info("password is changed");
    }

    public void typeOnNewPasswordConfirmField(String newValidPassword){
        type(newPasswordConfirmField, newValidPassword);
    }

    public void typeOnNewPasswordField(String newValidPassword){
        type(newPasswordField, newValidPassword);
    }

    public void typeOnOldPasswordField(String validPassword){

        type(oldPasswordField, validPassword);
    }

    public void clickOnChangePasswordButton(){
        clickOn(changePasswordButton);
        log.info("change password section is accessed");
    }

    public void clickOnSettingsAccountButton(){
        clickOn(settingsAccountButton);
        log.info("settings of accounts is accessed");
    }

    public void clickOnAccountSettingsButton(){
        clickOn(settingsSettingButton);
        log.info("subsection setting of settings is accessed");
    }
}
