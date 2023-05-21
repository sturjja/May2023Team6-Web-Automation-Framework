package com.freecrm;

import com.team6.base.CommonAPI;
import com.team6.pages.freecrm.ForumPage;
import com.team6.pages.freecrm.LoginPage;
import org.testng.annotations.Test;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.sql.DriverManager.getDriver;

public class ForumItem extends CommonAPI {
    Logger log = LogManager.getLogManager().getLogger(ForumItem.class.getName());
    String validEmail = "awafzaman@gmail.com";
    String validPassword = "Takeover2022";
    String validName = "Nelson Mandela";
    String simpleIntro = "This is the 5th month of the year";
    String simpleOutro = "That means the time to act is now";


    @Test
    public void addNotesToForm() {
        LoginPage loginPage = new LoginPage(getDriver());
        ForumPage forumPage = new ForumPage(getDriver());

        loginPage.clickOnloginLink();
        log.info("enter login page");
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
