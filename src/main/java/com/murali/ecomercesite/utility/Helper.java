package com.murali.ecomercesite.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    public static String getScreenShot(WebDriver driver) {

        File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath=System.getProperty("user.dir")+"./screenShot/FreeCRM_"+getCurrentDateTime()+".jpg";
        try {
            FileHandler.copy(scr, new File(screenshotPath));
            System.out.println("Screen shot is captured.!!!");
        }catch(Exception e){
            System.out.println("Error taking screen shot"+e.getMessage());
        }
        return screenshotPath;
    }

     public static String getCurrentDateTime(){
        SimpleDateFormat customForamt=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date Currentdate=new Date();
        return customForamt.format(Currentdate).toString();

    }

    public void handleframes(){

    }

    public void handleAlerts(){

    }

    public void javaScriptExecutor(){

    }

    public void externalWait(){

    }
}
