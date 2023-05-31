package com.team6.pages.orangehrmlive;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends CommonAPI {
    Logger log = LogManager.getLogger(HomepagePage.class.getName());

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span")
    WebElement accountButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[3]/div/div[1]/div/p")
    WebElement quickLaunchText;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[2]/a")
    WebElement SupportButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div/div[2]/p[2]")
    WebElement SupportText;

    @FindBy(xpath = "//button[@title='Help']")
    WebElement HelpButton;

    @FindBy(css = "div.container section.section.knowledge-base:nth-child(1) section.categories.blocks ul.blocks-list li.blocks-item:nth-child(1) a.blocks-item-link > span.blocks-item-title")
    WebElement AdminUserGuide;

    @FindBy(xpath = "//header//h1")
    WebElement UserGuideHeaderText;

    //Methods
    public String GetSupportText() {
        return SupportText.getText();
    }

    public String getCurrentUrl() {
        log.info("Get Current url success");
        return getDriver().getCurrentUrl();


    }

    public void clickOnSupport() {
        accountButton.click();
        SupportButton.click();

        log.info("Click on support Success");
    }

    public void clickOnHelp() {
        clickOn(HelpButton);
        log.info("Click on help Success");

    }

    public void clickOnAdminUserGuide() {
        clickOn(AdminUserGuide);
        log.info("Click on admin user guide Success");

    }

    public String getUserGuideUrl() {
        log.info("Captured header text success");
        return getDriver().getCurrentUrl();
    }

    public String QuickLaunchText() {
        return quickLaunchText.getText();
    }

}