package com.murali.ecomercesite.pageObjects.seleniumPractice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class runTestinParallel {
    @Test
    public void setUp()
    {
        // This will write the log in HTML and on console as well
        Reporter.log("Test1 is executed via Thread and Thread Id is "+Thread.currentThread().getId(), true);
    }

    @Test
    public void loginApplication()
    {
        Reporter.log("Test2 is executed via Thread and Thread Id is "+Thread.currentThread().getId(), true);
    }

    @Test
    public void logoutApplication()
    {
        Reporter.log("Test3 is executed via Thread and Thread Id is "+Thread.currentThread().getId(), true);
    }

    //com/murali/ecomercesite/pageObjects/seleniumPractice/runTestinParallel.java
}
