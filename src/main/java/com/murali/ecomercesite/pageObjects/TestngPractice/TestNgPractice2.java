package com.murali.ecomercesite.pageObjects.TestngPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgPractice2 {

    @Test(dataProvider = "calculator",dataProviderClass = dp.class)
    public void Sum (int a, int b, int result) {
        int sum = a + b;
        Assert.assertEquals(result, sum);
    }

    @Test (dataProvider = "calculator",dataProviderClass = dp.class)
    public void Diff (int a, int b, int result) {
        int diff = a - b;
        Assert.assertEquals(result, diff);
    }
}
