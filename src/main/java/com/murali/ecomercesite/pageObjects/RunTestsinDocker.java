package com.murali.ecomercesite.pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RunTestsinDocker {

    @Test
    public void DockerLogin() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        URL remoteURL = new URL("http://localhost:4444/wd/hub");
        WebDriver driver = new RemoteWebDriver(remoteURL, options);
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }
}
