package com.freecrm;

import com.team6.base.CommonAPI;
import com.team6.pages.freecrm.CampaignPage;
import com.team6.pages.freecrm.DocumentsPage;
import com.team6.pages.freecrm.HomePage;
import com.team6.pages.freecrm.LoginPage;
import com.team6.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class DocumentsItem extends CommonAPI {

    Logger log = LogManager.getLogger(CampaignItem.class.getName());
    Properties prop = Utility.loadProperties();

    String validEmail = prop.getProperty("freecrm.email");
    String validPassword = prop.getProperty("freecrm.password");
    String documentTitle = "Document1";
    String documentNote = "In this note is valuable info";
    String folderName = "Class Folder";
    @Test
    public void createDocument(){
        LoginPage loginPage = new LoginPage(getDriver());
        DocumentsPage documentsPage = new DocumentsPage(getDriver());
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        loginPage.clickOnloginLink();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        documentsPage.clickOnDocumentsButton();
        documentsPage.clickOnNewDocumentButton();
        documentsPage.typeOnDocumentTitleField(documentTitle);
        documentsPage.clickOnSaveDocumentButton();




    }
    @Test
    public void addNotesToDocument(){
        LoginPage loginPage = new LoginPage(getDriver());
        DocumentsPage documentsPage = new DocumentsPage(getDriver());
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        loginPage.clickOnloginLink();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        documentsPage.clickOnDocumentsButton();
        documentsPage.clickOnAddNotesButton();
        documentsPage.typeOnNoteTextField(documentNote);
        documentsPage.clickOnSaveDocumentNoteButton();


    }
    @Test
    public void downloadContactDocument(){
        LoginPage loginPage = new LoginPage(getDriver());
        DocumentsPage documentsPage = new DocumentsPage(getDriver());
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        loginPage.clickOnloginLink();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        documentsPage.clickOnDocumentsButton();
        documentsPage.clickOnExportFolder();
        documentsPage.clickOnDownloadContactDocumentButton();

    }
    @Test
    public void createDocumentFolder(){
        LoginPage loginPage = new LoginPage(getDriver());
        DocumentsPage documentsPage = new DocumentsPage(getDriver());
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        loginPage.clickOnloginLink();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        documentsPage.clickOnDocumentsButton();
        documentsPage.clickOnNewFolderButton();
        documentsPage.typeOnFolderNameField(folderName);
        documentsPage.clickOnSaveFolderButton();

    }

}
