package com.team6.pages.orangehrmlive;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomepagePage extends CommonAPI {
    Logger log = LogManager.getLogger(HomepagePage.class.getName());

    public HomepagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/button")
    WebElement sideBarMenu;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")
    WebElement logoutLink;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span")
    WebElement accountButton;

    //Leave
    @FindBy(css = "#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(3) > a")
    WebElement Leave;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div[1]/div/div[1]/div/label")
    WebElement selectAllPendingLeaveRequest;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/div/button[1]")
    WebElement approveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
    WebElement confirmApprove;

    @FindBy(xpath = "//li[@class='oxd-main-menu-item-wrapper']")
    List<WebElement> menuOptionList;

    @FindBy(css = ".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module")
    WebElement menuTabConfirmation;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/form[1]/h6[1]")
    WebElement maintenanceText;


    private void waitFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            log.error("InterruptedException occurred while waiting", e);
        }
    }

    public void clickOnLeave() {
        clickOn(Leave);
    }

    public void selectPendingApprovals() {
        selectAllPendingLeaveRequest.click();
    }

    public void approve() {
        waitFor(2);
        approveButton.click();
        waitFor(2);
        confirmApprove.click();
    }

    public void clickOnSidebarMenuIcon() {
        waitFor(1);
        clickOn(sideBarMenu);
    }

    public void clickOnLogoutButton() {
        accountButton.click();
        waitFor(5);
        logoutLink.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void clickonMainMenuOptions(String menuName) {
        List<WebElement> list = menuOptionList;
        for (WebElement element : menuOptionList) {
            String FieldText = element.getText();
            if (FieldText.equalsIgnoreCase(menuName)) {
                element.click();
                log.info("Click on " + menuName + " successful");
                break;
            }
        }
    }

    public String menuTabConfirmation() {
        String optionName = menuTabConfirmation.getText();
        return optionName.toLowerCase();
    }

    public String mainteneanceAccessTitle() {
        return maintenanceText.getText().toLowerCase();
    }
}