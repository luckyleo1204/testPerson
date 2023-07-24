package com.murali.ecomercesite.pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map.Entry;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class practice {

    @AfterMethod
    public void tearDown() {
        //Run all failed Test cases using testng-failed.xml
//        TestNG runner=new TestNG();
//        List<String> al=new ArrayList<String>();
//        //add the testng-failed.xml to list
//        al.add("C:\\NewWorkSpace\\TesttNgEx\\test-output\\SuiteTest\\testng-failed.xml");
////set as list to setTestSuites
//        runner.setTestSuites(al);
////Execute using run() , method.
//        runner.run();
    }

    @Test
    public void stringPattern(){
        // create a REGEX String
        String REGEX = ".*www.*";

        // create the string
        // in which you want to search
        String actualString
                = "www.geeksforgeeks.org";

        // compile the regex to create pattern
        // using compile() method
        Pattern pattern = Pattern.compile(REGEX);

        // get a matcher object from pattern
        Matcher matcher = pattern.matcher(actualString);

        // check whether Regex string is
        // found in actualString or not
        boolean matches = matcher.matches();

        System.out.println("actualString "
                + "contains REGEX = "
                + matches);


        // Second Approach:
        String REGEX1 = "brave";

        // create the string
        // in which you want to search
        String actualString1
                = "Cat is cute";

        // compile the regex to create pattern
        // using compile() method
        Pattern pattern1 = Pattern.compile(REGEX1);

        // check whether Regex string is
        // found in actualString or not
        boolean matches1 = pattern
                .matcher(actualString1)
                .matches();

        System.out.println("actualString "
                + "contains REGEX = "
                + matches1);

        }

    @Test
    public void StringBufferBuilder(){

        //String is : immutable to increase the performance:
        String str="Murali";
        String str1="Murali";  // Both str and str2= rerfer to same address in String pool in heap
        // if assign new value :
        str1="Rahul";  // it will not update str1, instead create new String str1="Rahul" in string pool
        System.out.println(str+":"+str1);
        // String works on FlyWeight design pattern
        // reuse same object.

        //StringBuffer : Thread safe and  synchorinized
        StringBuffer sb=new StringBuffer("MC");
        sb.append(" Hello");
        System.out.println(sb);
        sb.replace(0,2,"KC");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);

        //StringBuilder :  Not Thread safe and not synchorinized

        StringBuilder sb1=new StringBuilder("MC");
        sb1.append(" Hi Welcome");
        System.out.println(sb1);
        sb1.replace(0,2,"KC");
        System.out.println(sb1);
        sb1.reverse();
        System.out.println(sb1);
    }
    @Test
    public void dragAndDrop(){
        WebDriverManager.chromedriver().setup();;
        WebDriver driver=new ChromeDriver();
        driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
        try {
            Actions act = new Actions(driver);
            WebElement source = driver.findElement(By.xpath("//div/p[contains(text(),'Drag me')]"));
            WebElement destination = driver.findElement(By.xpath("//div/p[contains(text(),'Drop here')]"));
            act.dragAndDrop(source, destination).build().perform();
        }catch(Exception e){
            System.out.println(e.toString());
        }

    }
    @Test
    public void printListOfMapValues() {
        Map<String, List<String>> m = Collections.singletonMap(
                "list1", Arrays.asList("s1", "s2", "s3"));

        for (Map.Entry<String, List<String>> me : m.entrySet()) {
            String key = me.getKey();
            List<String> valueList = me.getValue();
            System.out.println("Key: " + key);
            System.out.print("Values: ");
            for (String s : valueList) {
                System.out.print(s + " ");
            }

            //Java 8
            m.entrySet().forEach(ab->{
                System.out.println("Key:"+ab.getKey());
                System.out.println("Values: ");
                ab.getValue().forEach(n-> System.out.print(n+" "));
            });
            //Java Stream
            m.entrySet().stream().map(cd->{
                return "Key: " + cd.getKey() + "\n"
                        + "Values: " + cd.getValue().stream()
                        .collect(Collectors.joining(" "));
            }).forEach(System.out::print);
        }

    }

    @Test
    public void ReadExcelReturnHashMap() throws IOException {
        File f = new File("Excel/Test.xlsx");
        FileInputStream fis = new FileInputStream(f);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheet("Sheet1");
        HashMap<Integer, String> map
                = new HashMap<Integer, String>();
        for (int r = 0; r <= sh.getLastRowNum(); r++) {
            int key = (int) sh.getRow(r)
                    .getCell(0)
                    .getNumericCellValue();
            String value = sh.getRow(r)
                    .getCell(1)
                    .getStringCellValue();
            map.put(key, value);
        }
        Iterator<Entry<Integer, String>> new_Iterator
                = map.entrySet().iterator();

        while (new_Iterator.hasNext()) {
            Map.Entry<Integer, String> new_Map
                    = (Map.Entry<Integer, String>)
                    new_Iterator.next();

            System.out.println(new_Map.getKey() + "|"
                    + new_Map.getValue());

        }
    }

    @Test
    public void takeScreenShot() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(2000));
        driver.get("http://www.google.com");


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000L));
        //Alert al=new Alert(driver.findElement(By.xpath("//div[@class='WrcADd']")));
        Set<String> wins = driver.getWindowHandles();
        System.out.println(wins.size());
        for (String i : wins) {
            driver.switchTo().window(i);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@aria-label=\"No thanks\"]"))));
            driver.findElement(By.xpath("//button[@aria-label=\"No thanks\"]")).click();
        }
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("screenShot/" + getFileName() + ".jpg"));


    }

    public String getFileName() {
        return UUID.randomUUID().toString().trim().toString();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss");
//        df.setTimeZone(TimeZone.getTimeZone("PST"));
//        return df.format(new Date().toString()).toString();
    }

    @Test(dataProvider = "LoginData")
    public void RegData(String name, int Age, String City) {
        System.out.println(name + "\t" + Age + "\t" + City);
    }

    @DataProvider(name = "LoginData")
    public Object[][] Regdataprov() {
        Object[][] obj = new Object[2][3];
        obj[0][0] = "Murali";
        obj[0][1] = 100;
        obj[0][2] = "Bangalore";

        obj[1][0] = "Kavitha";
        obj[1][1] = 101;
        obj[1][2] = "Bangalore";

        return obj;
    }

    @Test
    public void convertDecimalToHRomanLetter() {
        int num = 125;
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLetters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num = num - values[i];
                sb.append(romanLetters[i]);
            }
        }
        System.out.println(sb);
    }

    @Test
    public void linkStatus() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        List<WebElement> al = driver.findElements(By.tagName("a"));
        List<String> finalList = new ArrayList<>();
        for (WebElement i : al) {
            if (i.getAttribute("href") != null) {
                finalList.add(i.getAttribute("href"));
            }
        }
        for (String i : finalList) {
            System.out.println("Link==>" + i + "==>" + getStatusofLink(new URL(i)));
        }
    }

    private String getStatusofLink(URL url) throws IOException {
        String status = null;
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        status = connection.getResponseMessage();
        connection.disconnect();
        return status;
    }

    @Test
    public void FindDupString() {
        String s = "my bread is sweet bread";
        String[] s1 = s.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String i : s1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }

        }
//        Set<String> set=map.keySet();
//        for(String i: set){
//            System.out.println("Key==>"+i+"\tValue==>"+map.get(i));
//        }

        for (Map.Entry<String, Integer> i : map.entrySet()) {
            System.out.println("Key==>" + i + "\tValue==>" + i.getValue());
        }

    }

    @Test
    public void SingletonDemo() {
        Singleton s = Singleton.initaliatiaztion();
        s.getObjectName();

        //   Singleton s1=new Singleton();
    }

    @Test
    public void reverseString() {
        String s = "Murali";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(s.length() - 1 - i) + "\t");
        }
    }

    @Test
    public void fibSeries() {
        int x = 15;
        int[] fib = new int[x];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < x; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        for (int i : fib)
            System.out.print(i + "\t");
    }

    @Test
    public void isPrime() {
        int x = 7;
        boolean isPrime = true;
        for (int i = 2; i < x / 2; i++) {
            if (x % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime == true)
            System.out.println("given no is prime");
        else
            System.out.println("given no is not prime");
    }

    @Test
    public void testDuplicate() {
        ArrayList<String> al1 = new ArrayList<>(Arrays.asList("Murali", "Kushi", "Ramu", "Murali", "Kushi"));
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 10, 20, 4, 50));
        System.out.println("\n===================Before Remove Dup=========================\n");
        al.stream().forEach(n -> System.out.print(n + "\t"));
        al = removeDup(al);
        System.out.println("\n===================After Remove Dup=========================\n");
        al.stream().forEach(n -> System.out.print(n + "\t"));
        ArrayList<String> alString = new ArrayList<>(Arrays.asList("Murali", "Kushi", "Ramu", "Murali", "Kushi"));
        System.out.println("\n===================Before Remove Dup=========================\n");
        alString.stream().forEach(n -> System.out.print(n + "\t"));
        alString = removeDup(alString);
        System.out.println("\n===================After Remove Dup=========================\n");
        alString.stream().forEach(n -> System.out.print(n + "\t"));
    }

    @Test
    public void testStringAnagram() {
        String s1 = "CURE", s2 = "RUCE";

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        System.out.println(str1);
        System.out.println(str2);
        if (Arrays.toString(str1).equals(Arrays.toString(str2)))
            System.out.println("Given strings are anagram");
        else
            System.out.println("Given Strings are not anangram");
    }

    @Test
    public void bubbleSort() {
        int[] a = {10, 202, 30, 40, 7, 8, 99, 23, 77, 2};
        System.out.println("\n===================Before sort =========================\n");
        for (int m : a) {
            System.out.print(m + "\t");
        }
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println("\n===================After sort =========================\n");
        for (int m : a) {
            System.out.print(m + "\t");
        }
    }

    @Test
    public void isNumPal() {
        int x = 121, temp = x, sum = 0;
        boolean ispal = true;
        while (x > 0) {
            int rem = x % 10;
            sum = sum * 10 + rem;
            x = x / 10;
        }
        if (sum == temp)
            System.out.println("given number is pal");
        else
            System.out.println("given number is not pal");
    }

    @Test
    public void sumOfNumber() {
        int x = 12345678, sum = 0;

        while (x > 0) {
            int rem = x % 10;
            sum = sum + rem;
            x = x / 10;
        }
        System.out.println(sum);

    }

    @Test
    public void countNoofChars() {
        String str = "aaabbcca" + " ";
        char[] a = str.toCharArray();
        String finalString = "";
        int count = 1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1]) {
                count++;
            } else {
                finalString = finalString + a[i] + count;
                count = 1;
            }
        }
        System.out.println(finalString);
    }

    @Test
    public void StringisPal() {
        String str = "LEVEL";
        boolean ispal = true;
        char[] a = str.toCharArray();
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            if (a[start] == a[end]) {
                start++;
                end--;
            } else {
                ispal = false;
                break;
            }
        }
        if (ispal == true)
            System.out.println("given string is palindrome");
        else
            System.out.println("given string is not palindrome");
    }

    @Test
    public void demoComparator() {
        ArrayList<stud> al = new ArrayList<>();
        al.add(new stud(10, "Mra", 488));
        al.add(new stud(02, "Zen", 888));
        al.add(new stud(32, "Kri", 999));
        al.add(new stud(22, "Alex", 999));

        System.out.println("\n=================Before Sort===============\n");
        al.stream().forEach(n -> System.out.print(n + "\t"));
        Collections.sort(al, (a, b) -> {
            return a.getId() - b.getId();
        });
        System.out.println("\n=================After Sort===============\n");
        al.stream().forEach(n -> System.out.print(n + "\t"));

        System.out.println("\n=================Before Sort By Name===============\n");
        al.stream().forEach(n -> System.out.print(n + "\t"));
        Collections.sort(al, (a, b) -> {
            return a.getName().compareTo(b.getName());
        });
        System.out.println("\n=================After Sort By Name===============\n");
        al.stream().forEach(n -> System.out.print(n + "\t"));
    }

    public static <T> ArrayList<T> removeDup(ArrayList<T> t) {
        ArrayList<T> newList = new ArrayList<>();
        for (T i : t) {
            if (!newList.contains(i)) {
                newList.add(i);
            }
        }
        return newList;
    }
}

class stud {
    private int id, marks;
    private String name;

    public stud(int id, String name, int marks) {
        this.id = id;
        this.marks = marks;
        this.name = name;
    }

    @Override
    public String toString() {
        return "stud{" +
                "id=" + id +
                ", marks=" + marks +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Singleton {
    private static Singleton singleton = null;

    private Singleton() {

    }

    public static Singleton initaliatiaztion() {
        if (singleton == null) {
            return singleton = new Singleton();
        }
        return null;
    }

    public void getObjectName() {
        System.out.println(singleton.getClass().getName());
    }
}