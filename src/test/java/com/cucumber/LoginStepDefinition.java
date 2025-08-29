package com.cucumber;



import com.cucumber.pages.Loginpage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class LoginStepDefinition {

    WebDriver driver;
   Loginpage loginPage;
   public LoginStepDefinition(){
    driver = Hooks.driver;
    loginPage = new Loginpage();
    }



    @Given("URL is launched")
    public void urlIsLaunched() {
     loginPage.launchURL();

     System.out.println("This is given keyword");

    }

    @When("user enters email and password and click on Login button")
    public void userEntersEmailAndPasswordAndClickOnLoginButton() throws InterruptedException {
    loginPage.setEmail("ferojajany@gmail.com");
     Thread.sleep(2000);
    loginPage.setPassword("12345667");
    Thread.sleep(2000);
    loginPage.setLogin();
    }

    @Then("Login should be successful")
    public void loginShouldBeSuccessful() {
    }

    @And("Attach Screenshot")
    public void attachScreenshot() {
    }
}
