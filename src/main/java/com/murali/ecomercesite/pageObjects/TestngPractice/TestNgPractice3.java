package com.murali.ecomercesite.pageObjects.TestngPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class TestNgPractice3 {
    public ExcelToMap map=new ExcelToMap();
    @Test
    public void login() throws IOException {
        System.out.println(map.getExcelData().get("Murali1"));
    }

    @Test
    public void validate(){
        System.out.println("Validate");

    }
   @Test
    public void logout(){
       System.out.println("logout");
    }

    @DataProvider(name="LoginData")
    public Object[][] feedData(String uname, String pass) throws IOException {
           Object[][] obj=new Object[5][5];
        for(Map.Entry<String, String> i: map.getExcelData().entrySet()){

           // return obj={"i.getKey().toString()","i.getValue().toString()"};
        }
        return null;
    }
}
