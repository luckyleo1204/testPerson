package com.murali.ecomercesite.utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configDataProvider {

    Properties pro;
    public configDataProvider(){
       // File f = new File( "./TestData/userData.xlsx");

        File f = new File( "./config/config.properties");
        try {
           FileInputStream fis = new FileInputStream(f);
           pro=new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Error in loading config data");
        }
    }

    public void getDataFromConfig(String key){
        pro.getProperty(key);

    }

    public String getBrowser(){
       return pro.getProperty("Browser");
    }

    public String getappURl(){
        return pro.getProperty("URL");

    }
}
