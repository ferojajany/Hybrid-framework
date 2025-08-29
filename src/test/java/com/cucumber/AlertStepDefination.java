package com.cucumber;

import com.cucumber.pages.AlertPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AlertStepDefination {
    WebDriver driver;
    AlertPage alertPage;

    public AlertStepDefination() {
        driver = Hooks.driver;
        alertPage = new AlertPage();
    }

    @Given("User on the account page")
    public void userOnTheAccountPage() {
        driver.navigate().to("https://www.kapruka.com/shops/customerAccounts/accountLogin.jsp");
    }

    @When("User enters invalide information and click creat account button")
    public void userEntersInvalideInformationAndClickCreatAccountButton() {
        alertPage.navigateAccountPage();
        alertPage.createAccount();
    }

    @Then("verify alert text and accept the alert")
    public void verifyAlertTextAndAcceptTheAlert() {
        String alertText = alertPage.getalertText();
        System.out.println(alertText);

       Assert.assertTrue(alertText.contains("Your e-mail address appears to be invalid"));
       Assert.assertTrue(alertText.contains("The password you re-typed do not match"));
        System.out.println(alertText);
        alertPage.alertAccept();
    }
}
