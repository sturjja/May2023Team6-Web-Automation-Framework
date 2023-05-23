package com.freecrm;

import com.team6.base.CommonAPI;
import com.team6.pages.freecrm.ContactsPage;
import com.team6.pages.freecrm.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class ContactsItem extends CommonAPI {
    Logger log = LogManager.getLogger(ContactsItem.class.getName());
    String validEmail = "awafzaman@gmail.com";
    String validPassword = "Takeover2022";

//-------------------------------------------------------------------------------------------------------------
//*****************************(Test Case to export a contact from Contacts)*********************************

    @Test
    public void exportContact(){
        LoginPage loginPage = new LoginPage(getDriver());
        ContactsPage contactsPage = new ContactsPage(getDriver());

        loginPage.clickOnloginLink();
        log.info("enter login page");
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        contactsPage.clickOnContactsButton();
        contactsPage.clickOnContactsExportButton();







    }
//-------------------------------------------------------------------------------------------------------------
    //*******************************(Test Case to delete a contact from Contacts)*****************************

    @Test
    public void deleteContact(){
        LoginPage loginPage = new LoginPage(getDriver());
        ContactsPage contactsPage = new ContactsPage(getDriver());

        loginPage.clickOnloginLink();
        log.info("enter login page");
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        contactsPage.clickOnContactsButton();
        contactsPage.clickOnContactDeleteButton();
        contactsPage.clickOnContactDeleteConfirmButton();

    }
}
