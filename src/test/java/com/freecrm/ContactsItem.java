package com.freecrm;

import com.team6.base.CommonAPI;
import com.team6.pages.freecrm.ContactsPage;
import com.team6.pages.freecrm.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class ContactsItem extends CommonAPI {

    String validEmail = "awafzaman@gmail.com";
    String validPassword = "Takeover2022";
    String firstName = "Lionel";
    String lastName = "Messi";

//-------------------------------------------------------------------------------------------------------------
//*****************************(Test Case to export a contact from Contacts)*********************************
    @Test(priority = 0)
    public void createContact(){
        LoginPage loginPage = new LoginPage(getDriver());
        ContactsPage contactsPage = new ContactsPage(getDriver());

        loginPage.clickOnloginLink();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        contactsPage.clickOnContactsButton();
        contactsPage.clickOnCreateContactButton();
        contactsPage.typeOnContactFirstName(firstName);
        contactsPage.typeOnContactLastName(lastName);
        contactsPage.clickOnContactSaveButton();


    }
    @Test(priority = 1)
    public void exportContact(){
        LoginPage loginPage = new LoginPage(getDriver());
        ContactsPage contactsPage = new ContactsPage(getDriver());

        loginPage.clickOnloginLink();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        contactsPage.clickOnContactsButton();
        contactsPage.clickOnContactsExportButton();







    }
//-------------------------------------------------------------------------------------------------------------
    //*******************************(Test Case to delete a contact from Contacts)*****************************

    @Test(priority = 4)
    public void deleteContact(){
        LoginPage loginPage = new LoginPage(getDriver());
        ContactsPage contactsPage = new ContactsPage(getDriver());

        loginPage.clickOnloginLink();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        contactsPage.clickOnContactsButton();
        contactsPage.clickOnContactDeleteButton();
        contactsPage.clickOnContactDeleteConfirmButton();

    }

    @Test(priority = 3)
    public void cancelDeletionOfContact(){
        LoginPage loginPage = new LoginPage(getDriver());
        ContactsPage contactsPage = new ContactsPage(getDriver());

        loginPage.clickOnloginLink();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        contactsPage.clickOnContactsButton();
        contactsPage.clickOnContactDeleteButton();
        contactsPage.clickOnCancelDeletionButton();

    }
}
