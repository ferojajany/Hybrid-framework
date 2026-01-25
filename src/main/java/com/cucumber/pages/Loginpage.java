package com.cucumber.pages;

import com.cucumber.commonBase.Base;
import com.cucumber.commonControls.WebDropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Loginpage extends Base {
    WebDropDown dropDown = new WebDropDown();


    private final By email = By.id("exampleInputEmail1");
    private final By password = By.xpath("//*[@id='exampleInputPassword1']");
    private final By login = By.xpath("//input[@type='submit']");
    private final By errorMassege = By.xpath("//font[@color='red']");
    private final By accountLocator = By.xpath("//button[text()='Create Account']");
    private final By firstNameLocator = By.name("firstName");
    private final By lastNameLocator = By.name("lastName");
    private final By accountEmail = By.xpath("//input[@name='email']");
    private final By accountPassord = By.xpath("//input[@name='password']");
    private final By accountConfirmPassord = By.xpath("//input[@name='passwordReConfirm']");
    private final By languageLocator = By.xpath("//select[@aria-label='Select language']");
    private final By allCakeLocator = By.xpath("//div[@class='catalogueV2heading']");
    private final By singleCakaLocator = By.xpath("(//div[@class='catalogueV2heading'])[2]");
    private final By linkLocator = By.tagName("a");
    public void setEmail(String username) {
        driver.findElement(email).sendKeys(username);
    }

    public void setPassword(String passwordID) {
        driver.findElement(password).sendKeys(passwordID);
    }

    public void setLogin() {
        driver.findElement(login).click();
    }

    public void launchURL() {
        driver.navigate().to("https://www.kapruka.com/shops/customerAccounts/accountLogin.jsp");
    }

    public String getErrorMassege() {
        return driver.findElement(errorMassege).getText();

    }

    /**
     * varify title
     */
    public void varifyTitle() {
        Assert.assertEquals(driver.getTitle(), "Account Login / New Account Creation");
    }

    /**
     * Navigate account page
     */
    public void navigateAccountPage() {
        driver.findElement(accountLocator).click();
    }

    /**
     * Filing out account page
     */
    public void createAccountFild(String firstNa, String lastNa, String email) {
        driver.findElement(firstNameLocator).sendKeys(firstNa);
        driver.findElement(lastNameLocator).sendKeys(lastNa);
        driver.findElement(accountEmail).sendKeys(email);
    }

    /**
     * Creat password
     */
    public void createAccountPasswerd(String password, String confirmPass) {
        driver.findElement(accountPassord).sendKeys(password);
        driver.findElement(accountConfirmPassord).sendKeys(confirmPass);
    }

    public void clickCreateAccount() {
        driver.findElement(accountLocator).click();

    }


    /**
     * Dropdown
     */

    public void selectOptionByIndex() {
        dropDown.selectOptionByIndex(driver, languageLocator, 1);
    }

    /**
     * Get dropdown text & assertion
     */

    public String getSelectedOption() {
        return dropDown.getCorrentSelectOption(driver, languageLocator);
    }

    /**
     * Java script + scrolling
     */

    public void scrollingMathod() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//span[text()='Join Our Whatsapp Channel']"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);

    }

    /**
     * search button
     * @param input
     */
    public void enterSearchText(String input) throws InterruptedException {
        WebElement serchbutton = driver.findElement(By.id("search-input"));
        serchbutton.sendKeys(input,Keys.ENTER);

    }
   public List<WebElement> allcakeItem(){
        return driver.findElements(allCakeLocator);
    }

    /**
     * get all product name
     * @param expectedText
     * @return
     */
    public boolean specificResultText(String expectedText) {
        for (WebElement item : allcakeItem()) {
            if (item.getText().toLowerCase().contains(expectedText.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    public void clickRushDelivery(){
        WebElement rushDelivery = driver.findElement(By.xpath("//span[normalize-space()='Rush delivery']"));
        rushDelivery.click();
    }
    public void scrollRushDelivery(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
       WebElement clickbutton = driver.findElement(By.xpath("//h2[normalize-space()='Top Same Day Delivery Products on Kapruka']"));
       js.executeScript("arguments[0].scrollIntoView(true);",clickbutton);

    }
    public List<WebElement> gatTableData(){
     return driver.findElements(By.xpath("//h2[normalize-space()='Top Same Day Delivery Products on Kapruka']//following::table//tr"));
    }
    public WebElement getText(int i){
        return driver.findElement(By.xpath("//h2[normalize-space()='Top Same Day Delivery Products on Kapruka']//following::table//tr["+i+"]"));
    }

      public List<WebElement> allLinka() {
        return driver.findElements(By.tagName("a"));

       }

    public void varify(String result) {
        String actule = null;
        try {
            actule = driver.findElement(By.xpath("//b[text()='Order History']")).getText();
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        Assert.assertEquals(actule, result, "not match");
    }




}
