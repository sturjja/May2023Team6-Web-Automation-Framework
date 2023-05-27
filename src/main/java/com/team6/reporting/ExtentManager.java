package com.team6.reporting;

import com.relevantcodes.extentreports.ExtentReports;
<<<<<<< HEAD
import com.team6.utility.Utility;
import org.testng.ITestContext;
import org.testng.Reporter;
=======
import org.testng.ITestContext;
import org.testng.Reporter;
import com.team6.utility.Utility;
>>>>>>> origin/master

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    private static ITestContext context;

    public synchronized static ExtentReports getInstance(){
        if(extent == null){
            File outputDirectory = new File(context.getOutputDirectory());
            File resultDirectory = new File(outputDirectory.getParentFile(),"html");
            extent = new ExtentReports(Utility.currentDir +"/Extent-Report/ExtentReport.html", true);
            Reporter.log("Extent Report Directory"+ resultDirectory, true);
            extent.addSystemInfo("Host Name", "PNT").addSystemInfo("Environment","QA")
<<<<<<< HEAD
                    .addSystemInfo("User Name", "Ibna Zaman");
=======
                    .addSystemInfo("User Name", "Nacer Zimu");
>>>>>>> origin/master
            extent.loadConfig(new File(Utility.currentDir+ "/report-config.xml"));
        }
        return extent;
    }

    public static void setOutputDirectory(ITestContext context){
        ExtentManager.context = context;

    }
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/master
