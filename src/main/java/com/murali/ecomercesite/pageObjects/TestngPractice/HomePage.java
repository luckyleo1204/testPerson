package com.murali.ecomercesite.pageObjects.TestngPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;
    @FindBy(xpath = "//a[text()='Murali']")
    private WebElement welcomeMessage;

    @FindBy(xpath = "//a[text()='Sign out']")
    private WebElement logoutButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }

    public void clickLogout() {
        logoutButton.click();
    }
}
