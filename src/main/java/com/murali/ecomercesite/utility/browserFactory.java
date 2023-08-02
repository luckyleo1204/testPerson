package com.murali.ecomercesite.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class browserFactory {

    WebDriver driver;


    public static WebDriver startApp(WebDriver driver, String bname, String url) {
        if (bname.equalsIgnoreCase("Chrome")) {
//            WebDriverManager.chromedriver().setup();
//             driver=new ChromeDriver();
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (bname.equalsIgnoreCase("firefox")) {
          //  WebDriverManager.firefoxdriver().setup();
            System.setProperty("webdriver.chrome.driver", "./drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(20000));
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000));
        return driver;
    }

    public static void quitBrowser(WebDriver driver) {
        driver.quit();
    }

    public static void externalWait(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
