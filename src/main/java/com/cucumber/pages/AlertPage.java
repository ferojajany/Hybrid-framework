package com.cucumber.pages;

import com.cucumber.commonBase.Base;
import org.openqa.selenium.By;

public class AlertPage extends Base {
    private final By firstNameLocator = By.name("firstName");
    private final By lastNameLocator = By.name("lastName");
    private final By accountEmail = By.xpath("//input[@name='email']");
    private final By accountPassord = By.xpath("//input[@name='password']");
    private final By accountConfirmPassord = By.xpath("//input[@name='passwordReConfirm']");
    private final By accountLocator = By.xpath("//button[text()='Create Account']");

    public void createAccount(){
        driver.findElement(firstNameLocator).sendKeys("Feroja");
        driver.findElement(lastNameLocator).sendKeys("jany");
        driver.findElement(accountEmail).sendKeys("asdfgg");
        driver.findElement(accountPassord).sendKeys("12");
        driver.findElement(accountConfirmPassord).sendKeys("123");
        driver.findElement(accountLocator).click();
    }
    public void navigateAccountPage() {
        driver.findElement(accountLocator).click();
    }
    public String getalertText(){
        return driver.switchTo().alert().getText();
    }
    public void alertAccept(){
        driver.switchTo().alert().accept();
    }
}
