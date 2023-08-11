package com.murali.ecomercesite.pageObjects.seleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class HtmlDemoProgram1 {
WebDriver driver;
    @Test
    public void firstTest(){
        Reporter.log("Starting of loading config for Browser");
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        Reporter.log("Starting of Setup of Chrome Browser");
        driver = new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(2000));
        driver.get("https://www.yahoo.com");
        System.out.println(driver.getTitle());
        String str=driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        driver.switchTo().window(str);
        System.out.println(driver.getTitle());
        wait.until(titleIs("Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos"));
    }
}
