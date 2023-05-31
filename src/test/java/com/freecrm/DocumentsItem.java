package com.freecrm;

import com.team6.base.CommonAPI;
import com.team6.pages.freecrm.CampaignPage;
import com.team6.pages.freecrm.DocumentsPage;
import com.team6.pages.freecrm.HomePage;
import com.team6.pages.freecrm.LoginPage;
import com.team6.utility.ExcelReader;
import com.team6.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Properties;

public class DocumentsItem extends CommonAPI {

    Logger log = LogManager.getLogger(CampaignItem.class.getName());
    String currentDir = System.getProperty("user.dir");
    String path = currentDir+ File.separator+"data"+File.separator+"freecrm.xlsx";
    ExcelReader excelReader = new ExcelReader(path);
    Properties prop = Utility.loadProperties();

    String validEmail = prop.getProperty("freecrm.email");
    String validPassword = prop.getProperty("freecrm.password");
    String documentTitle = excelReader.getDataFromCell("DocumentItem", 0, 0);
    String documentNote = excelReader.getDataFromCell("DocumentItem", 1, 0);
    String folderName = excelReader.getDataFromCell("DocumentItem", 2, 0);


    //-----------------------------------------------------------------------------------------------------------
    //****************************(Test Case to create a Document Functionality)*************************

    @Test(priority = 0)
    public void createDocument(){
        LoginPage loginPage = new LoginPage(getDriver());
        DocumentsPage documentsPage = new DocumentsPage(getDriver());
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);


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

        //user will click on documents button on the left column to access documents page
        documentsPage.clickOnDocumentsButton();
        //user will click on new button to create a new document
        documentsPage.clickOnNewDocumentButton();
        //user will type in a desire title for the document on the title field
        documentsPage.typeOnDocumentTitleField(documentTitle);
        //user will click on save button to save new document
        documentsPage.clickOnSaveDocumentButton();




    }
    //-----------------------------------------------------------------------------------------------------------
    //****************************(Test Case to add notes to Document)****************************************
    @Test(priority = 1)
    public void addNotesToDocument(){
        LoginPage loginPage = new LoginPage(getDriver());
        DocumentsPage documentsPage = new DocumentsPage(getDriver());
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

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

        //user will click on documents button on the left column to access documents page
        documentsPage.clickOnDocumentsButton();
        //user will click on add file button assigned to created document
        documentsPage.clickOnAddFileButton();
        //user will click on add notes button assigned to created document
        documentsPage.clickOnAddNotesButton();
        //uer will type in their desired note on the note text field
        documentsPage.typeOnNoteTextField(documentNote);
        //user will click on save button to save note assigned to created document
        documentsPage.clickOnSaveDocumentNoteButton();


    }
    //-----------------------------------------------------------------------------------------------------------
    //****************************(Test Case to Download contact from Document)******************************
    @Test(priority = 2)
    public void downloadContactDocument(){
        LoginPage loginPage = new LoginPage(getDriver());
        DocumentsPage documentsPage = new DocumentsPage(getDriver());
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

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

        //user will click on documents button on the left column to access documents page
        documentsPage.clickOnDocumentsButton();
        //user will click on export folder button to export folder
        documentsPage.clickOnExportFolder();
        //user will click on download button assigned to created document to download contacts of this document
        documentsPage.clickOnDownloadContactDocumentButton();

    }
    //-----------------------------------------------------------------------------------------------------------
    //****************************(Test Case to create a Document Folder)**************************************
    @Test
    public void createDocumentFolder(){
        LoginPage loginPage = new LoginPage(getDriver());
        DocumentsPage documentsPage = new DocumentsPage(getDriver());
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

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

        //user will click on documents button on the left column to access documents page
        documentsPage.clickOnDocumentsButton();
        //user will click on new folder button to create new folder
        documentsPage.clickOnNewFolderButton();
        //user will type in the desired folder name in folder name field
        documentsPage.typeOnFolderNameField(folderName);
        //user will click on save button to save new folder
        documentsPage.clickOnSaveFolderButton();

    }

}
