package com.cucumber;

import com.cucumber.comonServieses.ExcelReader;
import com.cucumber.pages.Loginpage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import java.io.IOException;

public class ExcelStepDefinition {
    ExcelReader excelReader = new ExcelReader();
    Loginpage loginpage = new Loginpage();
   String actual ;
    @When("I login with the website with excel data")
    public void iLoginWithTheWebsiteWithExcelData() {
    }

    @Then("I should see dashboard")
    public void iShouldSeeDashboard() {
        
    }

    @When("read from excel")
    public void readFromExcel() {
        XSSFSheet sheet = excelReader.getExcelSheetTabTable("C:\\Users\\feroj\\IdeaProjects\\RD Automation.xlsx","","Sheet1");
        actual = sheet.getRow(1).getCell(1).getStringCellValue();
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println(rowCount);
        String email;
        String password;
        for (int i = 1;i<rowCount;i++){
            email=sheet.getRow(i).getCell(1).getStringCellValue();
            loginpage.setEmail(email);
            password = sheet.getRow(i).getCell(2).getStringCellValue();
            loginpage.setPassword(password);
        }

        
    }



    @Then("data should display from excel")
    public void dataShouldDisplayFromExcel() {
        Assert.assertEquals(actual,"");
    }

    @When("write to excel")
    public void writeToExcel()throws IOException {
        // create workbook for output result

        XSSFWorkbook outputworkbook;
        //to generate excel file, workbook
        outputworkbook = new XSSFWorkbook();
        //to generate sheet in excel
        XSSFSheet output = outputworkbook.createSheet("Output File");

// Create row for Output//this is hardcoded can be kept in loop
        XSSFRow outputValueRow = output.createRow(1);


// WRITE RESULT VALUE INTO OUTPUT RESULT FILE
        //as per 74th line it would create row as per array of an object
//        Object[] outputValues = {"1", "Baroda", "Test", "Pass"};
//        excelReader.WriteDataInOutputFile(outputValues, outputValueRow);
//        FileOutputStream fos = excelReader.getFileOutputStreamPath();
//        outputworkbook.write(fos);
//        System.out.println("Excel generated Successfully");
//        fos.close();
    }
        


    @Then("data should display")
    public void dataShouldDisplay() {
    }
}
