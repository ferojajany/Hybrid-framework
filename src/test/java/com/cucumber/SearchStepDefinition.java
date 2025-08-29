package com.cucumber;


import com.cucumber.pages.Loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SearchStepDefinition {
    WebDriver driver;
    Loginpage loginPage;

    public SearchStepDefinition() {
        driver = Hooks.driver;
        loginPage = new Loginpage();
    }

    @Given("I am on the search page")
    public void i_am_on_the_search_page() {
       driver.navigate().to("https://www.kapruka.com");

    }
    @When("User enter text to search and click on search button")
   public void user_enter_text_to_search_and_click_on_search_button() throws InterruptedException {
       loginPage.enterSearchText("cake");

    }

    @Then("User should see {string} in the result")
    public void userShouldSeeInTheResult(String expectedText) {
        boolean foundCake = loginPage.specificResultText(expectedText);
        Assert.assertTrue(foundCake,expectedText + "Expected result not found:");
    }

//    String actualValue = loginPage.getText();
//    String expectedValue = "Happy Birthday Bento Ribbon Cake And 5 Cupcakes";
//        System.out.println(actualValue);
//        Assert.assertEquals(actualValue,expectedValue);


    @Then("verify all items displayed related to Search criteria")
    public void verifyAllItemsDisplayedRelatedToSearchCriteria() {

        List<WebElement> cakeElements = loginPage.allcakeItem();
        ArrayList<String> cakeNames = new ArrayList<>();

        //Convert webElements into arraylist
        // It dynamically grows  as new items are added
        //It  allows easy access to elements by index

        for (WebElement cakeElement : cakeElements){
            cakeNames.add(cakeElement.getText().trim());
        }
        System.out.println("Total cake found : "+ cakeNames.size());
        for (String cake : cakeNames){
            System.out.println(cake);
        }
    }
}


