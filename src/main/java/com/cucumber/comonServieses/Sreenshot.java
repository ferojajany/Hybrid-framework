package com.cucumber.comonServieses;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    static void ab(WebDriver driver, String abFilename) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File pictur = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(pictur, new File("./sc/" + abFilename + ".png"));
    }
}
