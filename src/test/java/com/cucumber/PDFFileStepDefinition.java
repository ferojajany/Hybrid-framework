package com.cucumber;

import com.cucumber.comonServieses.PDFReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class PDFFileStepDefinition {
    PDFReader pdfReader = new PDFReader();

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
    }

    @When("I login with the website")
    public void iLoginWithTheWebsite() {

    }

    @Then("I should see dashbord")
    public void iShouldSeeDashbord() {

    }

    @When("Read the excel")
    public void readTheExcel() throws IOException {
        System.out.println(pdfReader.getPDFMathod("path"));
    }

    @Then("Varify text in excel")
    public void varifyTextInExcel() {
        try {
            List<String> pdf = pdfReader.getPDFMathod("path");
            boolean flag = false;

            for (String str : pdf) {
                if (str.contains("feroja")) {
                    flag = true;
                    System.out.println("Text found");
                }
                else {
                    Assert.fail("Assert failed - Text is not found");
                }
            }
            Assert.assertTrue(flag);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
