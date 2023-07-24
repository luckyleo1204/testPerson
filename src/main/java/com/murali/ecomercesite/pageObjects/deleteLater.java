package com.murali.ecomercesite.pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class deleteLater {
    WebDriver driver;
    @BeforeMethod
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        URL remoteURL = new URL("http://localhost:4444/wd/hub");
        driver = new RemoteWebDriver(remoteURL, options);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
     @Test
    public void firstTestWithDocker() throws IOException {

        driver.get("https://www.TestingDocs.com/mantis");
        System.out.println(driver.getTitle() +
                " \nwww.TestingDocs.com -Selenium Tutorials");
        System.out.println("Test was run on Docker container.Cheheck the Docker Logs!");

    }
    @Test
    public void firstTest() throws IOException {
//        WebDriverManager.chromedriver().setup();
//        ChromeDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        List<WebElement> al=driver.findElements(By.tagName("a"));
        List<String> finalList=new ArrayList<>();
        for(WebElement i: al){
            finalList.add(i.getAttribute("href"));
        }
        for(String i: finalList){
            System.out.println("href==>"+i+"==>"+linkStatus(new URL(i.toString())));
        }

    }

    @Test
    public void getListOfButtons(){

        driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
        List<WebElement> al=driver.findElements(By.tagName("button"));
        for(WebElement i: al){
            System.out.println(i.isEnabled());
        }

        
    }

    private String linkStatus(URL url) throws IOException {
        String status=null;
         HttpURLConnection conn=(HttpURLConnection) url.openConnection();
         conn.connect();
         status=conn.getResponseMessage();
         conn.disconnect();
        return status;


    }
}
