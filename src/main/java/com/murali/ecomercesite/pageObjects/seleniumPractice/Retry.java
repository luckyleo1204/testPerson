package com.murali.ecomercesite.pageObjects.seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Retry implements IRetryAnalyzer {
     int minretryCount=0;
    // set maxcounter value this will execute our test 3 times
    int maxretryCount=2;
    ChromeDriver driver;

    @Override
    public boolean retry(ITestResult result) {
        if(minretryCount<=maxretryCount) {
            System.out.println("Following test is failing===="+result.getName());
            System.out.println("Retrying the test Count is=== "+ (minretryCount+1));
            minretryCount++;
            return true;
        }
        return false;
    }

    @Test(retryAnalyzer = Retry.class)
    public void testRetry(){
        Reporter.log("Launching google site");
        driver.get("https://www.google.com");
        Reporter.log("Launched google site");
        Reporter.log("Asserting google page title");
        Assert.assertEquals(driver.getTitle(),"Murali");
        Reporter.log("Asserting google page title is valid");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @BeforeMethod
    public void setup(){
        Reporter.log("Starting of loading config for Browser");
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        Reporter.log("Starting of Setup of Chrome Browser");
        driver = new ChromeDriver();
    }
}
