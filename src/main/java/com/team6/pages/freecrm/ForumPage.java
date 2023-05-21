package com.team6.pages.freecrm;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForumPage extends CommonAPI {
    Logger log = LogManager.getLogger(ForumPage.class.getName());

    public ForumPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@class=\"item\" and @href=\"/forms\"]\n")
    WebElement formsButton;
    @FindBy(xpath = "//a[@href=\"/forms/new\"]/button[@class=\"ui linkedin button\"]\n")
    WebElement formsAddButton;
    @FindBy(xpath = "//input[@name=\"name\" and @type=\"text\"]\n")
    WebElement formsNameField;
    @FindBy(xpath = "//textarea[@name=\"intro\"]\n")
    WebElement formsIntroField;
    @FindBy(xpath = "//textarea[@name=\"outro\"]\n")
    WebElement formsOutroField;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"save icon\"]\n")
    WebElement formSaveButton;

    public void clickOnFormSaveButton(){
        clickOn(formSaveButton);
        log.info("form is saved");
    }

    public void typeOnFormsOutroField(String simpleOutro){
        type(formsOutroField, simpleOutro);
    }

    public void typeOnFormsIntroField(String simpleIntro){
        type(formsIntroField, simpleIntro);
    }

    public void typeOnFormsNameField(String validName){
        type(formsNameField, validName);
    }

    public void clickOnFormsAddButton(){
        clickOn(formsAddButton);
        log.info("clicked on forms add button");
    }

    public void clickOnFormsButton(){
        clickOn(formsButton);
        log.info("clicked on forum button");
    }


}

