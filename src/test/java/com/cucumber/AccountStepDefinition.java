package com.cucumber;


import com.cucumber.pages.Loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class AccountStepDefinition  {
    WebDriver driver;
    Loginpage loginPage;
    public AccountStepDefinition() {
        driver = Hooks.driver;
        loginPage = new Loginpage();
    }

    @Given("URL is launched and navigate to the account page")
    public void url_is_launched_and_navigate_to_the_account_page() throws InterruptedException {
        loginPage.launchURL();
        Thread.sleep(1000);
        loginPage.navigateAccountPage();

    }
    @When("User enters name, email and password and Click create account button")
    public void user_enters_name_email_and_password_and_click_create_account_button() throws InterruptedException {
     loginPage.createAccountFild("feroja","jany","Ferojajany@gmail.com");
     Thread.sleep(1000);
     loginPage.createAccountPasswerd("12345","1234567");
     Thread.sleep(1000);
    }
    @Then("User should be Unsuccessful")
    public void user_should_be_unsuccessful() {
      loginPage.clickCreateAccount();
    }
    @When("User check language")
    public void user_check_language() {


    }


}
