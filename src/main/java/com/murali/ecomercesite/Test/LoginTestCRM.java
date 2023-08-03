package com.murali.ecomercesite.Test;

import com.murali.ecomercesite.pageObjects.freeCRM.BaseTest;
import com.murali.ecomercesite.pageObjects.freeCRM.LoginPage;
import com.murali.ecomercesite.utility.ExcelDataProvider;
import com.murali.ecomercesite.utility.Helper;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginTestCRM extends BaseTest {

    LoginPage loginPage;

    @Test
    public void loginAppTest() {
        logger=report.createTest("login to cRM");
        logger.info("Started Login Application");
        loginPage=new LoginPage(driver);
        loginPage.ClickLoginButton();
        logger.pass("Login Page is loaded, is passed");
        System.out.println("Login Page is loaded, is passed");
        loginPage.logintoCRM( excelDataProvider.getStringData("Login",1,0), excelDataProvider.getStringData("Login",1,1));
        logger.pass("Login is successfull with excel data");

    }
}
