package com.team6.pages.automation.scaledupit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.team6.base.CommonAPI;
public class LinksPage extends CommonAPI {

    Logger log = LogManager.getLogger(LinksPage.class.getName());
    public LinksPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //locators

    @FindBy(xpath = "//*[@id=\"menu-primary-menu-1\"]/li[1]/a")
    WebElement quickLinkToHome ;
    @FindBy(xpath = "//*[@id=\"menu-primary-menu-1\"]/li[2]/a")
    WebElement quickLinkToShop ;
    @FindBy(xpath = "//*[@id=\"menu-primary-menu-1\"]/li[3]/a")
    WebElement quickLinkToMenCollection ;
    @FindBy(xpath = "//*[@id=\"menu-primary-menu-1\"]/li[4]/a")
    WebElement quickLinkToWomenCollection ;
    @FindBy(xpath = "//*[@id=\"menu-primary-menu-1\"]/li[5]/a")
    WebElement quickLinkToMyAccount ;
    @FindBy(xpath = "//*[@id=\"menu-primary-menu-1\"]/li[5]/ul/li[1]/a")
    WebElement quickLinkToCart ;
    @FindBy(xpath = "//*[@id=\"menu-primary-menu-1\"]/li[5]/ul/li[2]/a")
    WebElement quickLinkToCheckout ;
    @FindBy(xpath = "//*[@id=\"menu-primary-menu-1\"]/li[6]/a")
    WebElement quickLinkToBlog ;
    @FindBy(xpath = "//*[@id=\"menu-primary-menu-1\"]/li[7]/a")
    WebElement quickLinkToLoginRegister ;



    public void scrollDownPage() {
        scrollDownThePage(quickLinkToHome);
        log.info("scroll down the page success");

    }
    public void clickOnHomePageLink(){
        clickOn(quickLinkToHome);
        log.info("click on link to home page success");
    }
    public void clickOnShopPageLink(){
        clickOn(quickLinkToShop);
        log.info("click on link to shop page success");
    }
    public void clickOnMenCollectionPageLink(){
        clickOn(quickLinkToMenCollection);
        log.info("click on link to men collection page success");
    }
    public void clickOnWomenCollectionPageLink(){
        clickOn(quickLinkToWomenCollection);
        log.info("click on link to women collection page success");
    }
    public void clickOnMyaccountPageLink(){
        clickOn(quickLinkToMyAccount);
        log.info("click on link to my account page success");
    }
    public void clickOnCartPageLink(){
        clickOn(quickLinkToCart);
        log.info("click on link to cart page success");
    }
    public void clickOnCheckoutPageLink(){
        clickOn(quickLinkToCheckout);
        log.info("click on link to checkout page success");
    }
    public void clickOnBlogPageLink(){
        clickOn(quickLinkToBlog);
        log.info("click on link to blog page success");
    }
    public void clickOnLoginSlashRegisterPageLink(){
        clickOn(quickLinkToLoginRegister);
        log.info("click on link to login/register page success");
    }
}

