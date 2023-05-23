package com.team6.reporting;

import com.relevantcodes.extentreports.LogStatus;
import io.opentelemetry.api.internal.StringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class TestLogger {
    public static void log(final String message){
        Reporter.log(message,true);

    }
    public static void log(final StringUtils message){
        Reporter.log(message + "<br>",true);

    }
    public static void log(final String message, WebDriver driver){
        Reporter.log(message,true);

    }
}

