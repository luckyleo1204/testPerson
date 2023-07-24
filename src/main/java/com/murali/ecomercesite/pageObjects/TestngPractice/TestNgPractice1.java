package com.murali.ecomercesite.pageObjects.TestngPractice;

import org.testng.annotations.Test;

public class TestNgPractice1 {

    @Test(dataProvider="LoginDataProvider",dataProviderClass= dp.class)
    public void loginPage(String uname, String pass){
        System.out.println(uname+ ":"+ pass);
    }
    @Test
    public void valiatePage(){
        System.out.println("Valiate Page");
    }

    @Test
    public void logoutPage(){
        System.out.println("Logout Page");
    }


}
