package com.murali.ecomercesite.pageObjects.seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v112.network.Network;
import org.testng.annotations.Test;
import org.openqa.selenium.devtools.v112.network.model.Headers;


import org.apache.commons.codec.binary.Base64;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class chromeDevTool {

    @Test
    public void chromeDevToolDemo(){
        // Use webdrivermanager to handle chrome browser driver
        WebDriverManager.chromedriver().setup();

        // Start Chrome Browser
        ChromeDriver driver=new ChromeDriver();

        // Get devTools
        DevTools chromeDevTools=driver.getDevTools();

        // Create sessions
        chromeDevTools.createSession();

        // Enable network
        chromeDevTools.send(Network.enable(Optional.of(0), Optional.of(0), Optional.of(0)));

        // Create hashmap for storing key value pair
        Map<String, Object> header=new HashMap<>();

        // Create authentication string- please replace with your application username and password - in current case guest is username and password as well.
        String basicAuth ="Basic " + new String(new Base64().encode(String.format("%s:%s", "guest", "guest").getBytes()));

        // add Authorization as key and basicAuth as value
        header.put("Authorization", basicAuth);

        // add authentication as part of header
        chromeDevTools.send(Network.setExtraHTTPHeaders(new Headers(header)));

        // please replace this with your application url
        driver.get("https://jigsaw.w3.org/HTTP/");

        // click on link and your request should be authenticated
        driver.findElement(By.linkText("Basic Authentication test")).click();

    }

    @Test
    public void calendarDemo(){
        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

        //get current date time with Date()
        Date date = new Date();

        // Now format the date
        String date1= dateFormat.format(date);

        // Print the Date
        System.out.println(date1);
    }

    @Test
    public void getDateAndTime(){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss ");

        //get current date time with Date()
        Date date = new Date();

        // Now format the date
        String date1= dateFormat.format(date);

        // Print the Date
        System.out.println(date1);
}

@Test
    public void getDateOnly(){
        DateFormat dateFormat=new SimpleDateFormat("dd");
        Date date=new Date();
        String date1=dateFormat.format(date);
        System.out.println(date1);
    }
}
