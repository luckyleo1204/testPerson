package com.murali.ecomercesite.pageObjects.freeCRM;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.murali.ecomercesite.utility.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public ExcelDataProvider excelDataProvider;
    public configDataProvider conf;
    public  ExtentTest logger;
    public ExtentReports report;


    @BeforeSuite
    public void suiteLoading(){
        Reporter.log("Suite Config is getting loaded",true);
        excelDataProvider=new ExcelDataProvider();
        conf=new configDataProvider();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./Reports/FreeCRM_"+Helper.getCurrentDateTime()+".html"));
        report = new ExtentReports();
        report.attachReporter(htmlReporter);
        Reporter.log("Suite Config is loaded completely.. Test is getting started hold tight",true);
    }

//    @BeforeMethod
//    public void beforeMethodSetup(){
//        test = extent.createTest(getClass().getSimpleName());
//    }
    @BeforeClass
    public void setup(){
        Reporter.log("Browser and App url is getting loaded",true);
        driver= browserFactory.startApp(driver,conf.getBrowser(),conf.getappURl());
        Reporter.log("Browser and App url is loaded successfully",true);

    }

    @AfterClass
    public void teardown(){
        Reporter.log("Closing the browser!!",true);
        browserFactory.quitBrowser(driver);
        Reporter.log("Closed the browser!!",true);
    }

    @AfterMethod
    public void tearDownAfterMethod(ITestResult iTestResult) throws IOException {
        Reporter.log("Getting your reported based on test Results", true);
        if(iTestResult.getStatus()==ITestResult.FAILURE) {
            logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenShot(driver)).build());
        }else if(iTestResult.getStatus()==ITestResult.SUCCESS){
            logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenShot(driver)).build());

        }else if(iTestResult.getStatus()==ITestResult.SKIP){
            logger.warning("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenShot(driver)).build());
        }
        Reporter.log("Report is ready .. check and feel good", true);
        report.flush();
    }
}
