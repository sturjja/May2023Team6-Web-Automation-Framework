package com.team6.base;

import com.relevantcodes.extentreports.LogStatus;
<<<<<<< HEAD
import com.team6.reporting.ExtentManager;
import com.team6.reporting.ExtentTestManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
=======
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
>>>>>>> origin/master
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
<<<<<<< HEAD
import org.openqa.selenium.Keys;
=======
import org.openqa.selenium.WebElement;
>>>>>>> origin/master
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.team6.reporting.ExtentManager;
import com.team6.reporting.ExtentTestManager;
import com.team6.utility.Utility;
<<<<<<< HEAD

=======
import java.io.File;
import java.io.IOException;
>>>>>>> origin/master
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
public class CommonAPI {
    Logger log = LogManager.getLogger(CommonAPI.class.getName());
    Properties prop = Utility.loadProperties();
    String browserstackUsername = prop.getProperty("browserstack.username");
    String browserstackPassword = prop.getProperty("browserstack.password");
    String implicitWait = prop.getProperty("implicit.wait","5");
    String windowMaximize = prop.getProperty("browser.maximize","true");
    String takeScreenshots = prop.getProperty("take.screenshots","false");

    WebDriver driver;

    //report setup from line 48 to 105
    public static com.relevantcodes.extentreports.ExtentReports extent;

    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }
    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();
<<<<<<< HEAD
     //   if (takeScreenshots.equalsIgnoreCase("true")){
     //       if (result.getStatus() == ITestResult.FAILURE) {
     //           takeScreenshots(result.getName());
     //       }
     //   }
=======
        if (takeScreenshots.equalsIgnoreCase("true")){
            if (result.getStatus() == ITestResult.FAILURE) {
                takeScreenshot(result.getName());
            }
        }
>>>>>>> origin/master
        driver.quit();
    }
    @AfterSuite
    public void generateReport() {
        extent.close();
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

<<<<<<< HEAD
=======

>>>>>>> origin/master
    public void getCloudDriver(String envName, String os, String osVersion, String browserName, String browserVersion, String username, String password) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("os", os);
        cap.setCapability("os_version", osVersion);
        cap.setCapability("browser", browserName);
        cap.setCapability("browser_version", browserVersion);
        if (envName.equalsIgnoreCase("browserstack")){
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://"+username+":"+password+"@hub-cloud.browserstack.com:80/wd/hub"),cap);
        } else if (envName.equalsIgnoreCase("scaledupit")) {
            driver = new RemoteWebDriver(new URL("http://"+username+":"+password+"@ondemand.automation.scaledupit.com:80/wd.hub"),cap);
        }else if (envName.equalsIgnoreCase("freecrm")) {
            driver = new RemoteWebDriver(new URL("http://"+username+":"+password+"@ondemand.freecrm.com:80/wd.hub"),cap);
        }else if (envName.equalsIgnoreCase("mailchimp")) {
            driver = new RemoteWebDriver(new URL("http://"+username+":"+password+"@ondemand.mailchimp.com:80/wd.hub"),cap);
        }
    }

    public void getLocalDriver(String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
            log.info("chrome browser open success");
        }else if (browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            log.info("firefox browser open success");
        }else if (browserName.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
            log.info("edge browser open success");
        }
    }

    @Parameters({"useCloudEnv","envName","os","osVersion","browserName","browserVersion","url"})
    @BeforeMethod
    public void setUp(@Optional("false") String useCloudEnv, @Optional("browserstack") String envName, @Optional("windows") String os,
                      @Optional("10") String osVersion, @Optional("chrome") String browserName, @Optional("110") String browserVersion,
                      @Optional("https://automation.scaledupit.com") String url) throws MalformedURLException {
        if (useCloudEnv.equalsIgnoreCase("true")){
            getCloudDriver(envName,os,osVersion,browserName,browserVersion,"samiurturjja_uXPSKT","DcRHG1dHNfvnD4deAqPT");
        } else if(useCloudEnv.equalsIgnoreCase("false")){
            getLocalDriver(browserName);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }
    @AfterMethod
    public void tearDown(){
        //close browser
        driver.quit();
        log.info("browser close success");
    }


    //------------------------------------------------------------------------------------------------------------------
    //                                              selenium methods
    //------------------------------------------------------------------------------------------------------------------

    public WebDriver getDriver() {
        return driver;
    }
    public String getCurrentTitle(){
        return driver.getTitle();
    }
    public String getElementText(WebElement element){
        return element.getText();
    }
    public void clickOn(WebElement element){
        element.click();
    }
    public void type(WebElement element, String text){
        element.sendKeys(text);

    }
    public void scrollDownThePage(WebElement element) {
        element.sendKeys(Keys.PAGE_DOWN);

    }
    public void pressEnter(WebElement element){
        element.sendKeys(Keys.ENTER);
    }
    public void arrowDownTwiceAndPressEnter(WebElement element){
        element.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
    }
    public void arrowDownThriceAndPressEnter(WebElement element){
        element.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
    }
    public void hoverOver(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
    public void hoverOverAndClickOn(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    public void waitFor(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isVisible(WebElement element){
        return element.isDisplayed();
    }
    public boolean isInteractible(WebElement element){
        return element.isEnabled();
    }
    public boolean isChecked(WebElement element){
        return element.isSelected();
    }
    public void clickWithJavascript(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }
    public void captureScreenshot() {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("screenshots"+File.separator+"screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void takeScreenshot(String screenshotName){
        DateFormat df = new SimpleDateFormat("MMddyyyyHHmma");
        Date date = new Date();
        df.format(date);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(Utility.currentDir+ File.separator +"screenshots"+ File.separator + screenshotName+" "+df.format(date)+".jpeg"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot "+e.getMessage());
        }
    }
}
