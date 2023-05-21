package com.freecrm;

import com.team6.base.CommonAPI;
import com.team6.pages.freecrm.AccountSettingsPage;
import com.team6.pages.freecrm.HomePage;
import com.team6.pages.freecrm.LoginPage;
import org.testng.annotations.Test;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class AccountSettingsItem extends CommonAPI {
    Logger log = LogManager.getLogManager().getLogger(AccountSettingsItem.class.getName());
    String validEmail = "awafzaman@gmail.com";
    String validPassword = "Takeover2022";
    String newValidPassword = "Vision2020";
    String companyAddress = "3110 37th Ave, Queens, NY 11101";
    String companyCity = "New York";
    String companyZipCode = "11106";
    String companyState = "NY";
    String validFirstName = "John";
    String validLastName = "Doe";
    String newValidEmail = "kazizaman@gmail.com";

    @Test
    public void changePassword(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AccountSettingsPage accountSettingsPage = new AccountSettingsPage(getDriver());

        loginPage.clickOnloginLink();
        log.info("enter login page");
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        homePage.clickOnSettingButton();
        accountSettingsPage.clickOnAccountSettingsButton();
        accountSettingsPage.clickOnSettingsAccountButton();
        accountSettingsPage.clickOnChangePasswordButton();
        accountSettingsPage.typeOnOldPasswordField(validPassword);
        accountSettingsPage.typeOnNewPasswordField(newValidPassword);
        accountSettingsPage.typeOnNewPasswordConfirmField(newValidPassword);
        accountSettingsPage.clickOnChangedPasswordSubmitButton();






    }

    @Test
    public void addAddressToCompany(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AccountSettingsPage accountSettingsPage = new AccountSettingsPage(getDriver());

        loginPage.clickOnloginLink();
        log.info("enter login page");
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        homePage.clickOnSettingButton();
        accountSettingsPage.clickOnAccountSettingsButton();
        accountSettingsPage.clickOnSettingsAccountButton();
        accountSettingsPage.typeOnCompanyAddressField(companyAddress);
        accountSettingsPage.typeOnCompanyAddressCityField(companyCity);
        accountSettingsPage.typeOnCompanyAddressZipCodeField(companyZipCode);
        accountSettingsPage.typeOnCompanyAddressStateField(companyState);
        accountSettingsPage.clickOnCompanyAddressSaveButton();


    }


    @Test
    public void addNewUserManager(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AccountSettingsPage accountSettingsPage = new AccountSettingsPage(getDriver());

        loginPage.clickOnloginLink();
        log.info("enter login page");
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        homePage.clickOnSettingButton();
        accountSettingsPage.clickOnAccountSettingsButton();
        accountSettingsPage.clickOnSettingsUserManagerButton();
        accountSettingsPage.clickOnAddNewUserManagerButton();
        accountSettingsPage.typeOnNewUserFirstNameField(validFirstName);
        accountSettingsPage.typeOnNewUserLastNameField(validLastName);
        accountSettingsPage.typeOnNewUserEmailField(newValidEmail);
        accountSettingsPage.clickOnNewUserManagerSaveButton();

    }
}
