package com.murali.ecomercesite.pageObjects.TestngPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class oneMoreExample {
    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][] {
                { "Cedric",36 },
                { "Anne", 37},
        };
    }

    //This test method declares that its data should be supplied by the Data Provider
//named "test1"
    @Test(dataProvider = "test1",priority = 1)
    public void verifyData1(String n1, Integer n2) {
        System.out.println(n1 + " " + n2);
    }

    @Test(priority = 0)
    public void verifyData2() {
        System.out.println("Welcome");
    }


}
