package com.cucumber.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScript {
    public static void javaScriptMathod(WebDriver driver, WebElement element) throws InterruptedException {
       JavascriptExecutor js = (JavascriptExecutor)driver;
//       js.executeScript("window.scrollTo(0,500);");
//       js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
//       Thread.sleep(2000);
       js.executeScript("arguments[0].scrollIntoView(true);",element);
       js.executeScript("arguments[0].click();",element);
    }

}
