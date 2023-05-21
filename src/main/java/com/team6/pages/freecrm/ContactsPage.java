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

