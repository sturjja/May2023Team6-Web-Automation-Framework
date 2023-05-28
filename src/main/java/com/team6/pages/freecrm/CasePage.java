package com.team6.pages.freecrm;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CasePage extends CommonAPI {
    Logger log = LogManager.getLogger(CasePage.class.getName());
    public CasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class=\"item\" and @href=\"/cases\"]\n")
    WebElement caseButton;
    @FindBy(xpath = "//a[@href=\"/cases/new\"]/button[@class=\"ui linkedin button\"]\n")
    WebElement createNewCaseButton;
    @FindBy(xpath = "//div[@class=\"ui right corner labeled input\"]/input[@name=\"title\" and @type=\"text\"]\n")
    WebElement newCaseTitleField;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"save icon\"]\n")
    WebElement newCaseSaveButton;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"unhide icon\"]\n")
    WebElement caseUnhideButton;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"add icon\"]\n")
    WebElement caseNoteButton;
    @FindBy(xpath = "//textarea[@rows=\"3\"]\n")
    WebElement caseNoteField;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"checkmark icon\"]\n")
    WebElement caseNoteSaveButton;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"trash icon\"]\n")
    WebElement caseDeleteButton;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"remove icon\"]\n")
    WebElement caseDeleteConfirmButton;

    public void clickOnCaseDeleteConfirmButon(){
        clickOn(caseDeleteConfirmButton);
        log.info("case is deleted");
    }

    public void clickOnCaseDeleteButton(){
        clickOn(caseDeleteButton);
    }

    public void clickOnCaseNoteSaveButton(){
        clickOn(caseNoteSaveButton);
        log.info("case note is saved");
    }

    public void clickOnCaseUnhideButton(){
        clickOn(caseUnhideButton);
        log.info("case is unhidden ");
    }

    public void typeOnCaseNoteField(String caseNote){
        type(caseNoteField, caseNote);
    }

    public void clickOnCaseNoteButton(){
        clickOn(caseNoteButton);
    }

    public void clickOnCaseSaveButton(){
        clickOn(newCaseSaveButton);
        log.info("new case saved");
    }

    public void setNewCaseTitle(String newCaseTitle){
        type(newCaseTitleField, newCaseTitle);
    }

    public void clickOnNewCaseButton(){
        clickOn(createNewCaseButton);
        log.info("new case initiated");
    }


    public void clickOnCaseButton (){
        clickOn(caseButton);
        log.info("Case button clicked");
    }

}
