package com.cucumber.pages;

import com.cucumber.commonBase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class SearchPage extends Base {
    WebDriverWait wait;
   private final By cakeLocator = By.xpath("//div[@class='catalogueV2textBlock']");
//    public List<WebElement> allcakeItem(){
//        return driver.findElements(cakeLocator);
//    }
    public void enterSearchText(String input) throws InterruptedException {
        WebElement serchbutton = driver.findElement(By.id("search-input"));
        serchbutton.sendKeys(input, Keys.ENTER);
    }
    public Map<String,String> getCake(){
        Map<String,String> cakedetails = new HashMap<>();
        //List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cakeLocator));
        List<WebElement> items = driver.findElements(cakeLocator);
        for (WebElement cakeItem : items){
            try {
                String cakeName = cakeItem.findElement(By.xpath("//div[@class='catalogueV2heading']")).getText().trim();
                String cakePrice = cakeItem.findElement(By.xpath("//span[@class='catalogueV2converted']")).getText().trim();
                 cakedetails.put(cakeName,cakePrice);
            }catch (NoSuchElementException e){
                System.out.println("Element not found in one of the cake items");
            }
        }return cakedetails;
    }
}
