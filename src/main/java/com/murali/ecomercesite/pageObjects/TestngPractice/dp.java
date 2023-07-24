package com.murali.ecomercesite.pageObjects.TestngPractice;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class dp {
    @DataProvider(name="LoginDataProvider")
    public Object[][] testDataforLogin(){
        Object[][] obj=new Object[2][2];
        obj[0][0]="Murali";
        obj[0][1]="password1";
        obj[1][0]="Kushi";
        obj[1][1]="password1";
        return obj;
    }

    @DataProvider(name="calculator")
    public Object[][] testDataforLogin(Method m){
        switch (m.getName()) {
            case "Sum":
                return new Object[][] {{2, 3 , 5}, {5, 7, 9}};
            case "Diff":
                return new Object[][] {{2, 3, -1}, {5, 7, -2}};
        }
        return null;
    }
}
