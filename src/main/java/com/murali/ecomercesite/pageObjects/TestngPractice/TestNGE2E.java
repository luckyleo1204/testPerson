package com.murali.ecomercesite.pageObjects.TestngPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGE2E {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @DataProvider(name = "loginData",indices = 1)
    public Object[][] getLoginData() {
        return new Object[][]{
                {"cp.murali", "Harshi@123"},
                {"luckyleo1204", "Harshi@123"},
                // Add more test data here as needed
        };
    }

    @Test(priority = 0)
    public void loginurl(){
        driver.get("https://mypage.rediff.com/login/dologin"); // Replace with your website URL
    }

    @Test(dataProvider = "loginData",priority = 1)
    public void loginAndLogoutTest(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLogin();

        String welcomeMessage = homePage.getWelcomeMessage();
        //Assert.assertTrue(welcomeMessage.contains("Welcome"), "Login failed for user: " + username);
    }

    @Test(priority = 3)
    public void logout(){
        homePage.clickLogout();
        // Add assertions or verifications to check if logout was successful if needed
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
