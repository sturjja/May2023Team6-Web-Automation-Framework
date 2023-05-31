package com.freecrm;

import com.team6.base.CommonAPI;
import com.team6.pages.freecrm.ContactsPage;
import com.team6.pages.freecrm.LoginPage;
import com.team6.utility.ExcelReader;
import com.team6.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Properties;

public class ContactsItem extends CommonAPI {

    Properties prop = Utility.loadProperties();
    String currentDir = System.getProperty("user.dir");
    String path = currentDir+ File.separator+"data"+File.separator+"freecrm.xlsx";
    ExcelReader excelReader = new ExcelReader(path);
    String validEmail = prop.getProperty("freecrm.email");
    String validPassword = prop.getProperty("freecrm.password");
    String firstName = excelReader.getDataFromCell("ContactsItem", 0, 0);
    String lastName = excelReader.getDataFromCell("ContactsItem", 1, 0);

//-------------------------------------------------------------------------------------------------------------
//*****************************(Test Case to create a contact from Contacts)*********************************
    @Test(priority = 0)
    public void createContact(){
        LoginPage loginPage = new LoginPage(getDriver());
        ContactsPage contactsPage = new ContactsPage(getDriver());

        //user will click on login link
        loginPage.clickOnloginLink();
        //user will enter a valid email on the email field in the center of the page
        loginPage.enterEmail(validEmail);
        //user will enter a valid password on the password field right below email field
        loginPage.enterPassword(validPassword);
        //user will click on the login button to enter the home page
        loginPage.clickOnLoginButton();
        String expectedHeader = "Cogmento CRM";
        String actualHeader = getCurrentTitle();
        Assert.assertEquals(actualHeader, expectedHeader);

        //user will click on contacts button on the left column to access contacts page
        contactsPage.clickOnContactsButton();
        //user will click on create button to create a new contact
        contactsPage.clickOnCreateContactButton();
        //user will type in desired first name for contact
        contactsPage.typeOnContactFirstName(firstName);
        //user will type in desired last name for contact
        contactsPage.typeOnContactLastName(lastName);
        //user will saved contact by clicking save button
        contactsPage.clickOnContactSaveButton();


    }
    //-------------------------------------------------------------------------------------------------------------
//*****************************(Test Case to export a contact from Contacts)*********************************

    @Test(priority = 1)
    public void exportContact(){
        LoginPage loginPage = new LoginPage(getDriver());
        ContactsPage contactsPage = new ContactsPage(getDriver());

        //user will click on login link
        loginPage.clickOnloginLink();
        //user will enter a valid email on the email field in the center of the page
        loginPage.enterEmail(validEmail);
        //user will enter a valid password on the password field right below email field
        loginPage.enterPassword(validPassword);
        //user will click on the login button to enter the home page
        loginPage.clickOnLoginButton();
        String expectedHeader = "Cogmento CRM";
        String actualHeader = getCurrentTitle();
        Assert.assertEquals(actualHeader, expectedHeader);

        //user will click on contact button on the left column to access contacts page
        contactsPage.clickOnContactsButton();
        //user will click on export button to export any contact
        contactsPage.clickOnContactsExportButton();







    }
//-------------------------------------------------------------------------------------------------------------
    //*******************************(Test Case to delete a contact from Contacts)*****************************

    @Test(priority = 4)
    public void deleteContact(){
        LoginPage loginPage = new LoginPage(getDriver());
        ContactsPage contactsPage = new ContactsPage(getDriver());

        //user will click on login link
        loginPage.clickOnloginLink();
        //user will enter a valid email on the email field in the center of the page
        loginPage.enterEmail(validEmail);
        //user will enter a valid password on the password field right below email field
        loginPage.enterPassword(validPassword);
        //user will click on the login button to enter the home page
        loginPage.clickOnLoginButton();
        String expectedHeader = "Cogmento CRM";
        String actualHeader = getCurrentTitle();
        Assert.assertEquals(actualHeader, expectedHeader);

        //user will click on contacts button to access contact page
        contactsPage.clickOnContactsButton();
        //uer will click on delete button to delete created contact
        contactsPage.clickOnContactDeleteButton();
        //user will confirm deletion of contact by clicking confirm button
        contactsPage.clickOnContactDeleteConfirmButton();

    }

    //-------------------------------------------------------------------------------------------------------------
//*****************************(Test Case to cancel a contact deletion from Contacts)*********************************

    @Test(priority = 3)
    public void cancelDeletionOfContact(){
        LoginPage loginPage = new LoginPage(getDriver());
        ContactsPage contactsPage = new ContactsPage(getDriver());

        //user will click on login link
        loginPage.clickOnloginLink();
        //user will enter a valid email on the email field in the center of the page
        loginPage.enterEmail(validEmail);
        //user will enter a valid password on the password field right below email field
        loginPage.enterPassword(validPassword);
        //user will click on the login button to enter the home page
        loginPage.clickOnLoginButton();
        String expectedHeader = "Cogmento CRM";
        String actualHeader = getCurrentTitle();
        Assert.assertEquals(actualHeader, expectedHeader);

        //user will click on contacts button on the left column to access contacts page
        contactsPage.clickOnContactsButton();
        //user will click on delete button to delete contact
        contactsPage.clickOnContactDeleteButton();
        //user will click on cancel button to cancel contact deletion
        contactsPage.clickOnCancelDeletionButton();

    }
}
