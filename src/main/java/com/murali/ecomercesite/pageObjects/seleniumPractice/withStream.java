package com.murali.ecomercesite.pageObjects.seleniumPractice;

import org.apache.poi.hpsf.Array;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class withStream {
    RemoteWebDriver driver;
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @BeforeMethod
    public void setup(){
        Reporter.log("Starting of loading config for Browser");
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        Reporter.log("Starting of Setup of Chrome Browser");
        driver = new ChromeDriver();
    }
    @Test
    public void getTextStream(){
        driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
        //approach 1
        List<String> fl=new ArrayList<>();
//        List<WebElement> list=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
//        list.stream().forEach(n->fl.add(n.getText().toString()));
//        fl.stream().forEach(n-> System.out.println(n));

        //approach 2:
        driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"))
                .stream().forEach(n->fl.add(n.getText().toString()));
        fl.stream().forEach(n-> System.out.println(n));
    }

    @Test
    public void getUniqueTextStream(){
        driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
        Set<String> set=new HashSet<>();
        driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"))
                .stream().distinct().forEach(n->set.add(n.getText().toString()));
        set.stream().forEach(System.out::println);
    }

    @Test
    public void getListOfLoosers() {
        driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
        driver.findElements(By.xpath("//table[@class=\"dataTable\"]/tbody/tr/td[4][text()>'10.00']//preceding::td[3]")).stream()
                .forEach(n-> System.out.println(n.getText()));
    }

    @Test
    public void flipkartProduct() {
        driver.get("https://www.flipkart.com/search?q=iphone&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
        driver.findElements(By.xpath("//div[text()>'₹50,000']/ancestor::div/a/div[3]/div/div[@class=\"_4rR01T\"]")).stream()
                .forEach(n -> System.out.println(n.getText()));
        System.out.println("\n=====================================\n");
        driver.findElements(By.xpath("//div[text()='₹58,499']/preceding::div/div[@class=\"_4rR01T\"]")).stream()
                .forEach(n-> System.out.println(n.getText()));
    }

    @Test
    public void guruEx99(){
        driver.get("https://www.guru99.com/");
        printList("Testing");
        printList("SAP");
        printList("Web");
    }

    public void printList(String str){
        System.out.println("\n==============================================\n");
        driver.findElements(By.xpath("//h4/b[text()='"+str+"']/following::ul[1]/li")).stream()
                .forEach(n-> System.out.println(n.getText()));
    }

    @Test
    public void googleExample(){
        driver.get("https://www.google.com/");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(20000));
        wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.name("q"))));
        driver.findElement(By.name("q")).sendKeys("Selenium");

        driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//following::div/span/b")).stream()
                .forEach(n-> System.out.println("Selenium "+n.getText()));
    }

    @Test
    public void filpkart2(){
        driver.get("https://www.flipkart.com/search?q=iphone&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
        String s = "&21.37";
//        Pattern p = Pattern.compile("[^0-9]*([0-9]+(\\.[0-9]*)?)");
//        Matcher m = p.matcher(s);
//        m.matches();
//        String s = m.group(1)
    }
    @Test
    public void SteamEx1(){
        Stream<String> myStream = Stream.of("Like", "and", "Share","https://www.geeksforgeeks.org/");
        myStream.filter(n->n.startsWith("https://")).forEach(System.out::println);
    }

    @Test
    public void startWithusingFilter(){
        String[] myArray
                = new String[] { "stream",   "is",  "a",
                "sequence", "of",  "elements",
                "like",     "list" };
            Stream.of(myArray).filter(n->n.startsWith("s")).forEach(System.out::println);
    }

    @Test
    public void getEvenNo() {
        Integer[] myArray = new Integer[]{1, 4, 5, 7, 9, 10};
        Stream.of(myArray).filter(n -> n % 2 == 0).forEach(System.out::println);
    }

    @Test
    public void startsWithOvewls(){
        String[] myArray
                = "I am 24 years old and I want to be in Tier I company"
                .split(" ");
        Stream.of(myArray).filter(x->x.matches("(a|e|i|o|u)\\w*")).forEach(System.out::println);
    }

    @Test
    public void palindromeOrNot(){
        String[] myArray
                = new String[] { "madam", "please", "refer",
                "link",  "on",     "racecar" };

    }
    @Test
    public void jsExample1(){
        driver.manage().window().maximize();
        // in case of ChromeDriver driver=new ChromeDriver() or RemoteWebDriver driver=new ChromeDriver, then we don't need below line of code
     //   JavascriptExecutor js= (JavascriptExecutor)driver;
       // driver.executeScript("console.log('Hello.');");
      //  driver.executeScript("console.log('Hello '+arguments[0] +' Welcome to '+arguments[1]);","Murali","MakeSeleniumEasy");
        Object response = driver.executeScript("return 1===2");
        System.out.println(response);
       driver.get("http://www.makeseleniumeasy.com/");
    }
}
