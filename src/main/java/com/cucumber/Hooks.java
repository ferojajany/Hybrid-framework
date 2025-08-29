package com.cucumber;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.cucumber.commonBase.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.io.IOException;



public class Hooks extends Base {
    public static WebDriver driver;
    public static Scenario scenario;
    @Before
    public void setUp(Scenario scenario) throws IOException {
        Hooks.scenario = scenario;
       String browserIs =  readPropertiesFile("browser");
       System.out.println("Browser name = "+browserIs);
        String URL = readPropertiesFile("URL");
        System.out.println("URL = "+URL);
        driver = browerLunch(browserIs);
        //driver.navigate().to("https://www.kapruka.com");
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            ExtentTest currentStep = ExtentCucumberAdapter.getCurrentStep();
            if (currentStep != null){
                currentStep.fail("Test failed :"+scenario.getName());

            }else {
                System.out.println("Werning : ExtentTest is null, faild setup could not be logged.");
            }
        }
    }


}
