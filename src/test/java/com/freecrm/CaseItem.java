package com.freecrm;

import com.team6.base.CommonAPI;
import com.team6.pages.freecrm.CasePage;
import com.team6.pages.freecrm.HomePage;
import com.team6.pages.freecrm.LoginPage;
import org.testng.annotations.Test;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CaseItem extends CommonAPI {
    String validEmail = "awafzaman@gmail.com";
    String validPassword = "Takeover2022";
    String newCaseTitle = "Second Case";
    String caseNote = "this is a case note";

 //----------------------------------------------------------------------------------------------------------
 //*****************************(Test Case to change a password)******************************************

    @Test(priority = 2)
    public void createCase(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        CasePage casePage = new CasePage(getDriver());


        loginPage.clickOnloginLink();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        casePage.clickOnCaseButton();
        casePage.clickOnNewCaseButton();
        casePage.setNewCaseTitle(newCaseTitle);
        casePage.clickOnCaseSaveButton();










    }

//-----------------------------------------------------------------------------------------------------------
//*******************************(Test Case to add note to case)**************************************

    @Test(priority = 1)
    public void addNoteToCase(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        CasePage casePage = new CasePage(getDriver());


        loginPage.clickOnloginLink();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        waitFor(3);

        casePage.clickOnCaseButton();
        casePage.clickOnCaseUnhideButton();
        waitFor(5);
        casePage.clickOnCaseNoteButton();
        casePage.typeOnCaseNoteField(caseNote);
        casePage.clickOnCaseNoteSaveButton();





    }

 //----------------------------------------------------------------------------------------------------------
 //*****************************(Test Case to delete a case)*******************************************


    @Test(priority = 0)
    public void deleteCase(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        CasePage casePage = new CasePage(getDriver());


        loginPage.clickOnloginLink();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        casePage.clickOnCaseButton();
        waitFor(3);
        casePage.clickOnCaseUnhideButton();
        waitFor(3);
        casePage.clickOnCaseDeleteButton();
        waitFor(3);
        casePage.clickOnCaseDeleteConfirmButon();





    }
}
