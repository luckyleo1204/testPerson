package com.murali.ecomercesite.pageObjects.TestngPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;



    @FindBy(name = "id")
    private WebElement usernameInput;

    @FindBy(name = "num")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"pass_div\"]/input[3]")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

       public void setUsername(String username) {
        usernameInput.sendKeys(username);
          }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }
}
