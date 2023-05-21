package com.team6.pages.freecrm;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DealsPage extends CommonAPI {
    Logger log = LogManager.getLogger(DealsPage.class.getName());
    public DealsPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@class=\"item\" and @href=\"/deals\" and i[@class=\"money icon\"] and span[@class=\"item-text\"]]\n")
    WebElement dealsIcon;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"edit icon\"]\n")
    WebElement editDealsButton;
    @FindBy(xpath = "//input[@name=\"commission\" and @placeholder=\"\" and @type=\"text\" and @value=\"\"]\n")
    WebElement dealsCommissionField;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"save icon\"]\n")
    WebElement dealSaveButton;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"unhide icon\"]\n")
    WebElement unhideIcon;
    @FindBy(xpath = "<i aria-hidden=\"true\" class=\"add icon\"></i>")
    WebElement addNotesButton;
    @FindBy(xpath = "//textarea[@rows=\"3\"]\n")
    WebElement notesField;
    @FindBy(xpath = "//button[@class=\"ui green button\" and i[@aria-hidden=\"true\" and @class=\"checkmark icon\"] and contains(text(), \"Save\")]\n")
    WebElement saveNotes;

    public void clickOnSaveNotes(){
        clickOn(saveNotes);
        log.info("notes are saved");
    }

    public void typeOnNotesField(String note){
        type(notesField, note);
    }

    public void clickOnAddNotesButton(){
        clickOn(addNotesButton);
        log.info("clicked on add notes button");
    }

    public void clickOnUnhideIcon(){
        clickOn(unhideIcon);
        log.info("clicked on unhide icon");
    }

    public void clickOnDealSaveButton(){
        clickOn(dealSaveButton);
        log.info("deal is saved");
    }

    public void setDealsCommissionField(String commision){
        type(dealsCommissionField, commision);
    }

    public void clickOnEditDealsButton(){
        clickOn(editDealsButton);
        log.info("clicked on edit deal button");
    }

    public void clickOnDealsButton(){
        clickOn(dealsIcon);
        log.info("deal button is clicked");
    }
}