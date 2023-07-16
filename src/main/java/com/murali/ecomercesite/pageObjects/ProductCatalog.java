package com.murali.ecomercesite.pageObjects;

import com.murali.ecomercesite.abstractComponent.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalog extends BaseTest {
    WebDriver driver;
    public ProductCatalog(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
          }
    @FindBy(css=".mb-3")
    List<WebElement> products;

    By productBy=By.cssSelector(".mb-3");
    By toastBy=By.cssSelector(".ng-animating");
    By animated=By.cssSelector(".ng-animating");
    public List<WebElement> getProductList(){
        waitforElement(productBy);
        return products;
    }

    public WebElement getProductByName(String productName){
       WebElement prod= getProductList().stream().filter(n->
                n.findElement(By.cssSelector("b")).getText()
                        .equalsIgnoreCase(productName)).findFirst().orElse(null);
       return prod;
    }

    public void addProductToCart(String productName){
        WebElement prod=getProductByName(productName);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        waitforElement(toastBy);
        waitforElemenDisappear(animated);
    }
}
