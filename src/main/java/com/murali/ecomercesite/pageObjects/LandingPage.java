package com.murali.ecomercesite.pageObjects;

import com.murali.ecomercesite.abstractComponent.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BaseTest {
WebDriver driver;
   public  LandingPage(WebDriver driver){
       super(driver);
       this.driver=driver;
       PageFactory.initElements(driver, this);
    }
    @FindBy(id="userEmail")
    WebElement useremail;
    @FindBy(id="userPassword")
    WebElement pwd;
    @FindBy(id="login")
    WebElement loginbutton;

    public void loginApp(String uname, String password){
        useremail.sendKeys(uname);
        pwd.sendKeys(password);
        loginbutton.click();
    }

}
