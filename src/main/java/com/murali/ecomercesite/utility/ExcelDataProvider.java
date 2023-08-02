package com.murali.ecomercesite.utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDataProvider {

    XSSFWorkbook wb;
    public ExcelDataProvider()  {
        File f = new File( "./TestData/userData.xlsx");
        try {
            FileInputStream fis = new FileInputStream(f.getAbsoluteFile());
            wb = new XSSFWorkbook(fis);
        } catch (Exception e) {
            System.out.println("Error in loading excel data");
        }
    }

    public String getStringData(String sheetName, int row, int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
        }

    public String getStringData(int index, int row, int column){
        return wb.getSheetAt(index).getRow(row).getCell(column).getStringCellValue();
    }
    public Double getNumericData(String sheetName, int row, int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }


}
