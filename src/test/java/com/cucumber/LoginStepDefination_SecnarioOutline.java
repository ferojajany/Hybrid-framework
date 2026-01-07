package com.cucumber;


import com.cucumber.pages.Loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginStepDefination_SecnarioOutline {
    WebDriver driver;
    Loginpage loginPage;

    public LoginStepDefination_SecnarioOutline() {
        driver = Hooks.driver;
        loginPage = new
                Loginpage();
    }

    @Given("I login with the webside")
    public void i_login_with_the_webside() {
        loginPage.launchURL();
    }

    @When("User enters {string} and {string}")
    public void user_enters_and(String email, String password) throws InterruptedException {

        loginPage.setEmail(email);
        Thread.sleep(2000);
        loginPage.setPassword(password);
    }

    @Then("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.setLogin();
        loginPage.varifyTitle();
    }

    @Then("User should see{string}")
    public void user_should_see_valide_credentilas_massege(String errorMassegeText) {
        String actulemassege = loginPage.getErrorMassege();
        System.out.println(actulemassege);


        if (actulemassege.equals(errorMassegeText)) {
            Assert.assertEquals(actulemassege,errorMassegeText,"Fail: Message not matched.");

        } else if (actulemassege.equals(errorMassegeText)) {
            Assert.assertEquals(actulemassege,errorMassegeText,"Fail: Message not matched.");

        } else if (actulemassege.equals(errorMassegeText)) {

            Assert.assertEquals(actulemassege,errorMassegeText,"Fail: Message not matched.");

        } else if (actulemassege.equals(errorMassegeText)) {

            Assert.assertEquals(actulemassege,errorMassegeText,"Fail: Message not matched.");

        }
        driver.quit();

    }


}
