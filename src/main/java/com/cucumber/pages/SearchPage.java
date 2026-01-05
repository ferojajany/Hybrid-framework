package com.cucumber.pages;

import com.cucumber.commonBase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchPage extends Base {
    public void enterSearchText(String input) throws InterruptedException {
        WebElement serchbutton = driver.findElement(By.id("search-input"));
        serchbutton.sendKeys(input, Keys.ENTER);
    }

    public Map<String,String>getCake(){
        Map<String,String>cakeDetails = new HashMap<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement>items = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='catalogueV2textBlock']")));
             
        for (WebElement cakeItem : items){
            try {
                String cakeName = cakeItem.findElement(By.xpath("//div[@class='catalogueV2heading']")).getText().trim();
                String cakePrice = cakeItem.findElement(By.xpath("//span[@class='catalogueV2converted']")).getText().trim();

                cakeDetails.put(cakeName, cakePrice);
            }catch (NoSuchElementException e){
                System.out.println("Element not found in this item, skipping to next.");
            }
        } return cakeDetails;
    }
}
