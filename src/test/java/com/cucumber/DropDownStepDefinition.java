package com.cucumber;


import com.cucumber.pages.Loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DropDownStepDefinition {
    WebDriver driver;
    Loginpage loginPage;
    public DropDownStepDefinition() {
        driver = Hooks.driver;
        loginPage = new Loginpage();
    }
    @Given("I am on the dropdown page")
    public void i_am_on_the_dropdown_page() {
       loginPage.launchURL();
    }
    @When("I select option from the dropdown")
    public void i_select_option_from_the_dropdown() {
      loginPage.selectOptionByIndex();
    }
    @Then("I should see expected option is selected")
    public void i_should_see_expected_option_is_selected() {
       String actualResult = loginPage.getSelectedOption();
        Assert.assertEquals(actualResult,"සිං");
    }
}