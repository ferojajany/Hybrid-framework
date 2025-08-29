package com.cucumber;

import com.cucumber.pages.Loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RushDeliveryStepDefinition {
    WebDriver driver;
    Loginpage loginpage;

    public RushDeliveryStepDefinition() {
        driver = Hooks.driver;
        loginpage = new Loginpage();
    }

    @Given("i am on the rush delivery product page")
    public void iAmOnTheRushDeliveryProductPage() {
        driver.navigate().to("https://www.kapruka.com");
    }

    @When("I want to see rush delivery product")
    public void iWantToSeeRushDeliveryProduct() {
      loginpage.clickRushDelivery();
      loginpage.scrollRushDelivery();
    }

    @Then("I want to check  rush delivery product available")
    public void iWantToCheckRushDeliveryProductAvailable() {

        int i;
        List<WebElement> list = loginpage.gatTableData();
        for (i = 2;i <= list.size(); i++){
         String productName =  loginpage.getText(i).getText();
            System.out.println(productName);
        }
    }
}
