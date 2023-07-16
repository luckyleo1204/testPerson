package com.murali.ecomercesite.pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


public class practice {

    @Test
    public void linkStatus() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.google.com");
        List<WebElement> al=driver.findElements(By.tagName("a"));
        List<String> finalList=new ArrayList<>();
        for(WebElement i: al){
            if(i.getAttribute("href")!=null){
                finalList.add(i.getAttribute("href"));
            }
        }
        for(String i : finalList){
            System.out.println("Link==>"+i+"==>"+getStatusofLink(new URL(i)));
        }
    }

    private String getStatusofLink(URL url) throws IOException {
        String status=null;
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        status =connection.getResponseMessage();
        connection.disconnect();
        return  status;
    }

    @Test
    public void FindDupString(){
        String s="my bread is sweet bread";
        String[] s1=s.split(" ");
        Map<String,Integer> map=new HashMap<>();
        for(String i: s1){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }

        }
//        Set<String> set=map.keySet();
//        for(String i: set){
//            System.out.println("Key==>"+i+"\tValue==>"+map.get(i));
//        }

        for(Map.Entry<String,Integer> i: map.entrySet())
        {
            System.out.println("Key==>"+i+"\tValue==>"+i.getValue());
        }

    }
    @Test
    public void SingletonDemo(){
        Singleton s=Singleton.initaliatiaztion();
        s.getObjectName();

     //   Singleton s1=new Singleton();
    }
    @Test
    public void reverseString(){
        String s="Murali";
        for(int i=0;i<s.length();i++){
            System.out.print(s.charAt(s.length()-1-i)+"\t");
        }
    }
    @Test
    public void fibSeries(){
        int x=15;
        int[] fib=new int[x];
        fib[0]=1; fib[1]=1;
        for(int i=2;i<x;i++){
            fib[i]=fib[i-1]+fib[i-2];
        }
        for(int i: fib)
            System.out.print(i+"\t");
    }
    @Test
    public void isPrime(){
        int x=7; boolean isPrime=true;
        for(int i=2;i<x/2;i++){
            if(x%i==0){
                isPrime=false;
                break;
            }
        }
        if(isPrime==true)
            System.out.println("given no is prime");
        else
            System.out.println("given no is not prime");
    }
    @Test
    public void testDuplicate(){
        ArrayList<String> al1=new ArrayList<>(Arrays.asList("Murali","Kushi","Ramu","Murali","Kushi"));
        ArrayList<Integer> al=new ArrayList<>(Arrays.asList(10,20,30,40,10,20,4,50));
        System.out.println("\n===================Before Remove Dup=========================\n");
        al.stream().forEach(n-> System.out.print(n+"\t"));
        al=removeDup(al);
        System.out.println("\n===================After Remove Dup=========================\n");
        al.stream().forEach(n-> System.out.print(n+"\t"));
        ArrayList<String> alString=new ArrayList<>(Arrays.asList("Murali","Kushi","Ramu","Murali","Kushi"));
        System.out.println("\n===================Before Remove Dup=========================\n");
        alString.stream().forEach(n-> System.out.print(n+"\t"));
        alString=removeDup(alString);
        System.out.println("\n===================After Remove Dup=========================\n");
        alString.stream().forEach(n-> System.out.print(n+"\t"));
    }

    @Test
    public void testStringAnagram(){
        String s1="CURE", s2="RUCE";

        char[] str1=s1.toCharArray();
        char[] str2=s2.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        System.out.println(str1);
        System.out.println(str2);
        if(Arrays.toString(str1).equals(Arrays.toString(str2)))
            System.out.println("Given strings are anagram");
        else
            System.out.println("Given Strings are not anangram");
    }
    @Test
    public void bubbleSort(){
        int[] a={10,202,30,40,7,8,99,23,77,2};
        System.out.println("\n===================Before sort =========================\n");
        for( int m : a){
            System.out.print(m+"\t");
        }
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        System.out.println("\n===================After sort =========================\n");
        for( int m : a){
            System.out.print(m+"\t");
        }
    }

    @Test
    public void isNumPal(){
        int x=121, temp=x, sum=0;
        boolean ispal=true;
        while(x>0){
            int rem=x%10;
            sum=sum*10+rem;
            x=x/10;
        }
        if(sum==temp)
            System.out.println("given number is pal");
        else
            System.out.println("given number is not pal");
    }
    @Test
    public void sumOfNumber(){
        int x=12345678, sum=0;

        while (x>0){
            int rem=x%10;
            sum=sum+rem;
             x=x/10;
        }
        System.out.println(sum);

    }

    @Test
    public void countNoofChars(){
        String str="aaabbcca"+" ";
        char[] a=str.toCharArray();
        String finalString="";
        int count=1;
        for(int i=0;i<a.length-1;i++){
            if(a[i]==a[i+1]){
                count++;
            }else{
                finalString=finalString+a[i]+count;
                count=1;
            }
        }
        System.out.println(finalString);
    }

    @Test
    public void StringisPal(){
        String str="LEVEL";
        boolean ispal=true;
        char[] a=str.toCharArray();
        int start=0;
        int end=a.length-1;
        while(start<end){
            if(a[start]==a[end]){
                start++; end--;
            }else{
                ispal=false;
                break;
            }
        }
        if(ispal==true)
            System.out.println("given string is palindrome");
        else
            System.out.println("given string is not palindrome");
    }

    @Test
    public void demoComparator(){
        ArrayList<stud> al=new ArrayList<>();
        al.add(new stud(10,"Mra",488));
        al.add(new stud(02,"Zen",888));
        al.add(new stud(32,"Kri",999));
        al.add(new stud(22,"Alex",999));

        System.out.println("\n=================Before Sort===============\n");
        al.stream().forEach(n-> System.out.print(n+"\t"));
        Collections.sort(al, (a,b)->{
            return a.getId()-b.getId();
        });
        System.out.println("\n=================After Sort===============\n");
        al.stream().forEach(n-> System.out.print(n+"\t"));

        System.out.println("\n=================Before Sort By Name===============\n");
        al.stream().forEach(n-> System.out.print(n+"\t"));
        Collections.sort(al, (a,b)->{
            return a.getName().compareTo(b.getName());
        });
        System.out.println("\n=================After Sort By Name===============\n");
        al.stream().forEach(n-> System.out.print(n+"\t"));
    }

    public static <T>ArrayList<T> removeDup(ArrayList<T> t){
        ArrayList<T> newList=new ArrayList<>();
        for(T i: t){
            if(!newList.contains(i)){
                newList.add(i);
            }
        }
        return newList;
    }
}

class stud{
    private int id, marks;
    private String name;

    public stud(int id, String name,int marks) {
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

class Singleton{
    private static Singleton singleton=null;

    private Singleton(){

    }

    public static Singleton  initaliatiaztion(){
        if(singleton==null) {
            return  singleton=new Singleton();
        }
        return null;
    }

    public void getObjectName(){
        System.out.println(singleton.getClass().getName());
    }
}