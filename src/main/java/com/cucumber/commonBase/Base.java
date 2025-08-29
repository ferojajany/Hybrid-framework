package com.cucumber.commonBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {
    public static WebDriver driver;
    public WebDriver browerLunch(String brouser){
        if (brouser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        if (brouser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }

        if (brouser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    return driver;

    }
public String readPropertiesFile(String property) throws IOException {
    FileReader prop = new FileReader("src/test/resources/config.properties");
    Properties properties = new Properties();
    properties.load(prop);
    return properties.getProperty(property);
}


}
