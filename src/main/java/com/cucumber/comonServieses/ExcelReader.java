package com.cucumber.comonServieses;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class ExcelReader {
    /**
     *read an excel file
     */
    public FileInputStream getFileInputStreamPath(String path) throws FileNotFoundException {
    FileInputStream fis = new FileInputStream(path.toString());
    System.out.println("File path :"+fis);
    return fis;
    }

    /**
     * generated an output file
     */

    public FileInputStream getFileOutputStreamPath(String path) throws FileNotFoundException {
    FileInputStream fos = new FileInputStream(path.toString());
        System.out.println("File path :"+fos);
        return fos;
    }
    public XSSFSheet getExcelSheetTabTable(String file, String excelName,String sheetName) {
        try {
            FileInputStream fis = getFileInputStreamPath(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int lastColNum = sheet.getRow(0).getFirstCellNum();
            DataFormatter dataFormatter = new DataFormatter();

            for (Row nextRow : sheet) {
                for (int colNum = 1; colNum < lastColNum; colNum++) {
                    Cell cell = nextRow.getCell(colNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (Objects.requireNonNull(cell.getCellType()) == CellType.BLANK) {
                        cell.setCellValue("");
                    } else if(Objects.requireNonNull(cell.getCellType()) == CellType.NUMERIC) {
                        String numericAsString = dataFormatter.formatCellValue(cell);
                        cell.setCellValue(numericAsString);
                    }
                }

             }
             

            workbook.close();
            fis.close();
            return sheet;
        } catch (Exception e) {
            return null;
        }



    }
    public void WriteDataInOutputFile(Object[] outputValues, XSSFRow OutputValueRow) {
        for (int counter = 0; counter < outputValues.length; counter++) {
            XSSFCell cell = OutputValueRow.createCell(counter);
            cell.setCellValue(outputValues[counter].toString());
        }
    }




}
