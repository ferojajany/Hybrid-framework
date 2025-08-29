package com.cucumber;


import com.cucumber.pages.Loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ScrollStepDefination {
    WebDriver driver;
    Loginpage loginPage;

    public ScrollStepDefination() {
        driver = Hooks.driver;
        loginPage = new Loginpage();
    }
    @Given("I am on the scrolling page")
    public void iAmOnTheScrollingPage() {
        loginPage.launchURL();
    }

        @When("Webpage is scrolling and click")
        public void webpageIsScrollingAndClick() throws InterruptedException {
           loginPage.scrollingMathod();

        }


}
