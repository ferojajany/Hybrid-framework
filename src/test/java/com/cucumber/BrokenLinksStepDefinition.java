package com.cucumber;

import com.cucumber.pages.Loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.List;

public class BrokenLinksStepDefinition {
    WebDriver driver;
    Loginpage loginpage;
    public BrokenLinksStepDefinition() {
        driver = Hooks.driver;
        loginpage = new  Loginpage();
    }

    @Given("Navigate to Kapruka rush deoivary page")
    public void navigateToKaprukaRushDeoivaryPage() {
        driver.navigate().to("https://www.kapruka.com/online/samedaydelivery");
    }

    @When("All the links are collected on the page")
    public void allTheLinksAreCollectedOnThePage() {
        List<WebElement> allLinks = loginpage.allLinka();
        System.out.println("total links found :"+allLinks.size());
        Assert.assertTrue(allLinks.size()>0,"NO links found");
    }

    @Then("Verify each link are not broken")
    public void verifyEachLinkAreNotBroken( ) throws IOException {
        for (WebElement list : loginpage.allLinka()) {
            String url = list.getAttribute("href");

// If condition true it stop,If condition false then move next step
            if (url == null)
                continue;
//I need to establish HTTP method  + connection with url
            HttpURLConnection conn = (HttpURLConnection) (new URL(url).openConnection());
            conn.setRequestMethod("GET");
                conn.connect();
                
                int responseCode = conn.getResponseCode();
                Assert.assertTrue(responseCode < 400, "Broken link found :");
            }
        }
    }

