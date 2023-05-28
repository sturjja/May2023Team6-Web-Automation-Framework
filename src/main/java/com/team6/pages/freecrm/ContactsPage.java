package com.team6.pages.freecrm;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends CommonAPI {
    Logger log = LogManager.getLogger(ContactsPage.class.getName());

    public ContactsPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class=\"item\" and @href=\"/contacts\"]\n")
    WebElement contactsButton;
    @FindBy(xpath = "//button[@class=\"ui linkedin button\"]\n")
    WebElement contactsExportButton;
    @FindBy(xpath = "//i[@aria-hidden='true' and @class='trash icon']\n")
    WebElement contactDeleteButton;
    @FindBy(xpath = "//button[@class='ui red button' and i[@aria-hidden='true' and @class='remove icon'] and text()='Delete']\n")
    WebElement contactDeleteConfirmButton;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"edit icon\"]\n")
    WebElement createContactButton;
    @FindBy(xpath = "//input[@autocomplete=\"new-password\" and @name=\"first_name\" and @type=\"text\"]\n")
    WebElement contactFirstName;
    @FindBy(xpath = "//input[@autocomplete=\"new-password\" and @name=\"last_name\" and @type=\"text\"]\n")
    WebElement contactLastName;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"save icon\"]\n")
    WebElement contactSaveButton;
    @FindBy(xpath = "//button[@class=\"ui left floated button\"]\n")
    WebElement cancelDeletionButton;

    public void clickOnCancelDeletionButton(){
        clickOn(cancelDeletionButton);
        log.info("deletion is cancelled");
    }

    public void clickOnContactSaveButton(){
        clickOn(contactSaveButton);
        log.info("contact is saved");
    }

    public void typeOnContactLastName(String lastName){
        type(contactLastName, lastName);
    }

    public void typeOnContactFirstName(String firstName){
        type(contactFirstName, firstName);
    }

    public void clickOnCreateContactButton(){
        clickOn(createContactButton);
        log.info("contact creation is initiated");
    }

    public void clickOnContactDeleteConfirmButton(){
        clickOn(contactDeleteConfirmButton);
        log.info("contact is deleted");
    }

    public void clickOnContactDeleteButton(){
        clickOn(contactDeleteButton);
        log.info("clicked on contact delete button");
    }

    public void clickOnContactsExportButton(){
        clickOn(contactsExportButton);
        log.info("contacts are exported");
    }

    public void clickOnContactsButton(){
        clickOn(contactsButton);
        log.info("clicked on Contacts button");
    }

}

