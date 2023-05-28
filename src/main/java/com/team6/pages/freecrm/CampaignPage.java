package com.team6.pages.freecrm;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage extends CommonAPI {
    Logger log = LogManager.getLogger(CampaignPage.class.getName());
    public CampaignPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class=\"item\" and @href=\"/campaigns\"]\n")
    WebElement campaignButton;
    @FindBy(xpath = "//a[@href=\"/campaigns/new\"]/button[@class=\"ui linkedin button\"]\n")
    WebElement newCampaignButton;
    @FindBy(xpath = "//input[@name=\"name\" and @type=\"text\"]\n")
    WebElement campaignNameField;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"save icon\"]\n")
    WebElement campaignSaveButton;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"edit icon\"]\n")
    WebElement campaignEditButton;
    @FindBy(xpath = "//input[@class=\"hidden\" and @name=\"active\" and @readonly and @tabindex=\"0\" and @type=\"checkbox\"]\n")
    WebElement campaignActiveButton;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"trash icon\"]\n")
    WebElement campaignDeleteButton;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"remove icon\"]\n")
    WebElement confirmCampaignDeletion;

    public void clickOnConfirmCampaignDeletion(){
        clickOn(confirmCampaignDeletion);
        log.info("campaign is deleted");
    }

    public void clickOnCampaignDeleteButton(){
        clickOn(campaignDeleteButton);
        log.info("campaign deletion initialized");
    }

    public void clickOnCampaignActiveButton(){
        clickOn(campaignActiveButton);
        log.info("campaign is now active");
    }

    public void clickOnEditCampaignButton(){
        clickOn(campaignEditButton);
        log.info("campaign can now be edited");
    }

    public void clickOnSaveCampaignButton(){
        clickOn(campaignSaveButton);
        log.info("campaign is saved");
    }

    public void typeOnCampaignNameField(String campaignName){
        type(campaignNameField, campaignName);
    }

    public void clickOnNewCampaignButton(){
        clickOn(newCampaignButton);
        log.info("new campaign is initiated");
    }

    public void clickOnCampaignButton(){
        clickOn(campaignButton);
        log.info("clicked on campaign button");
    }

}
