package com.cucumber;

import com.cucumber.pages.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class MultipleSearchDefinition {
    WebDriver driver;
    SearchPage searchPage;

    public MultipleSearchDefinition() {
        driver = Hooks.driver;
        searchPage = new SearchPage();
    }

    @Given("User am on the search page")
    public void i_am_on_the_search_page() {
        driver.navigate().to("https://www.kapruka.com");
    }
    @When("User enter input to search and click on search button")
    public void user_enter_text_to_search_and_click_on_search_button() throws InterruptedException {
        searchPage.enterSearchText("cake");
    }
    @Then("Verify all items displayed related to text")
    public void varifyAllItemsDisplayedRelatedToText() {
        Map<String,String> cakeDetails = searchPage.getCake();
        System.out.println("Total cake Found : "+cakeDetails.size());
        //cakeDetails.forEach(cake,price) ->System.out.println(cake +" = "+price);
        for (Map.Entry<String,String> set : cakeDetails.entrySet()){
            System.out.println(set.getKey()+" = "+set.getValue());
        }

    }
}
