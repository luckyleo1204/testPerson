package com.murali.ecomercesite.pageObjects.TestngPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryOnlyFailedTests {
    @Test(retryAnalyzer = TestRetryAnalyzer.class)
    public void test1() {
        //Negative Scenario
        Assert.assertEquals(2+2,5,"Addition Problem! 2+2 must be 4!\n");
    }
    @Test(retryAnalyzer = TestRetryAnalyzer.class)
    public void test2() {
        //Negative Scenario
        Assert.assertEquals(2+2,3,"Addition Problem! 2+2 must be 4!\n");
    }
    @Test(retryAnalyzer = TestRetryAnalyzer.class)
    public void test3() {
        //Postive Scenario
        Assert.assertEquals(2+2,4,"Addition Problem! 2+2 must be 4!\n");
    }
}
