package com.cucumber;



import com.cucumber.Utilities.Screenshot;
import com.cucumber.pages.Loginpage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class LoginStepDefinition {

    WebDriver driver;
   Loginpage loginPage;
   Screenshot sc;
   public LoginStepDefinition(){
    driver = Hooks.driver;
    loginPage = new Loginpage();
    sc = new Screenshot();
    }



    @Given("URL is launched")
    public void urlIsLaunched() {
     loginPage.launchURL();

     System.out.println("This is given keyword");

    }

    @When("user enters email and password and click on Login button")
    public void userEntersEmailAndPasswordAndClickOnLoginButton() throws InterruptedException, IOException {
    loginPage.setEmail("practice@expandtesting.com");
     Thread.sleep(2000);
    loginPage.setPassword("admin1234");
    Thread.sleep(2000);
    loginPage.setLogin();
    loginPage.varify("Order History");
    sc.ab(driver,"LoginTest1");

    }

    @Then("Login should be successful")
    public void loginShouldBeSuccessful() {
    }

    @And("Attach Screenshot")
    public void attachScreenshot() {
    }
}
