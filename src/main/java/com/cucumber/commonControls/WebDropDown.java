package com.cucumber.commonControls;

import com.cucumber.commonBase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class WebDropDown extends Base {
    /**
     * Select option by visible text.
     * @param optionTOSelect
     * @return
     */
    public String selectOptionByvisibleText(WebDriver driver, By by, String optionTOSelect){
        Select option  = new Select(driver.findElement(by));
        option.selectByVisibleText(optionTOSelect);
        return  optionTOSelect;
    }

    /**
     * select option by index.
     * @param indexNo
     */
    public void selectOptionByIndex(WebDriver driver,By by, int indexNo ){
        Select option  = new Select(driver.findElement(by));
        option.selectByIndex(indexNo);
    }

    /**
     * select option by value.
     * @param value
     */
    public void selectOptionByValue(WebDriver driver,By by,String value){
        Select option = new Select(driver.findElement(by));
        option.selectByValue(value);
    }

    /**
     * Get select option.
     * @return
     */
    public String getCorrentSelectOption(WebDriver driver,By by){
        Select option  = new Select(driver.findElement(by));
        return option.getFirstSelectedOption().getText().trim();
    }

    /**
     * Get option.
     * @return
     */
    public List<WebElement> getOption(WebDriver driver,By by){
        Select option  = new Select(driver.findElement(by));
        return option.getOptions();
    }
    /**
     * Get first select option.
     */
   public WebElement firstSelectedOption(WebDriver driver,By by){
       Select option  = new Select(driver.findElement(by));
       return option.getFirstSelectedOption();
   }



   }




