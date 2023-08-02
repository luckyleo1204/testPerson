package com.murali.ecomercesite.pageObjects.freeCRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {

    WebDriver driver;


    @FindBy(xpath="//a/span[text()='Log In']")
    private WebElement login;

    @FindBy(name="email")
    private WebElement username;

    @FindBy(name="password")
    private WebElement pass;

    @FindBy(xpath="//div[text()='Login']")
    private WebElement LoginButton;

    public LoginPage(WebDriver driver){
       // super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void ClickLoginButton(){
        driver.navigate().refresh();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(2000));
        wait.until(ExpectedConditions.visibilityOf(login));
        login.click();
    }

    public void logintoCRM(String uname,String pas){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(2000));
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(uname);
        pass.sendKeys(pas);
        LoginButton.click();
    }

}
