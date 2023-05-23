package com.freecrm;

import com.team6.base.CommonAPI;
import com.team6.pages.freecrm.ForumPage;
import com.team6.pages.freecrm.LoginPage;
import org.testng.annotations.Test;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.sql.DriverManager.getDriver;

public class ForumItem extends CommonAPI {
    String validEmail = "awafzaman@gmail.com";
    String validPassword = "Takeover2022";
    String validName = "Nelson Mandela";
    String simpleIntro = "This is the 5th month of the year";
    String simpleOutro = "That means the time to act is now";

//-------------------------------------------------------------------------------------------------------------
//**********************************(Test Case to add notes to the forum)**************************************


    @Test
    public void addNotesToForm() {
        LoginPage loginPage = new LoginPage(getDriver());
        ForumPage forumPage = new ForumPage(getDriver());

        loginPage.clickOnloginLink();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        forumPage.clickOnFormsButton();
        forumPage.clickOnFormsAddButton();
        forumPage.typeOnFormsNameField(validName);
        forumPage.typeOnFormsIntroField(simpleIntro);
        forumPage.typeOnFormsOutroField(simpleOutro);
        forumPage.clickOnFormSaveButton();
    }
}
