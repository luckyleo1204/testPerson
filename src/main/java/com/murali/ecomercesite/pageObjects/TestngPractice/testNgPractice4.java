package com.murali.ecomercesite.pageObjects.TestngPractice;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class testNgPractice4 {


    @Test
    public void runwithDataProvier(String uname, String pass){
        System.out.println(uname+":"+pass);
    }

    @DataProvider(name="TestData")
    public Object[][] getDataFromExcelToPassToTest() throws IOException {
        File f = new File("Excel/Test2.xlsx");
        FileInputStream fis = new FileInputStream(f);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheet("Sheet1");

        return null;

    }
}
