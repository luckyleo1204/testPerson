package com.murali.ecomercesite.pageObjects.seleniumPractice;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ReadExcelDataInListOfMap {

    @Test
    public void readExcelData() throws IOException {
        List<LinkedHashMap<String, String>> mapDataList = getExcelDataAsMap("input","login");

        for(int k = 0; k<mapDataList.size() ; k++)
        {
            System.out.println("Data Set "+ (k+1) +" : ");
            for(String s: mapDataList.get(k).keySet())
            {
                System.out.println("Value of "+s +" is  : "+mapDataList.get(k).get(s));
            }
            System.out.println("========================================================");
        }
    }

    public static List<LinkedHashMap<String, String>> getExcelDataAsMap(String excelFileName, String sheetName) throws EncryptedDocumentException, IOException {
        // Create a Workbook
        Workbook wb = WorkbookFactory.create(new File("src\\test\\resources\\excelFiles\\"+excelFileName+".xlsx"));
        // Get sheet with the given name "Sheet1"
        Sheet s = wb.getSheet(sheetName);
        // Initialized an empty List which retain order
        List<LinkedHashMap<String, String>> dataList = new ArrayList<>();
        // Get data set count which will be equal to cell counts of any row
        int countOfDataSet = s.getRow(0).getPhysicalNumberOfCells();
        // Skipping first column as it is field names
        for (int i = 1; i < countOfDataSet; i++) {
            // Creating a map to store each data set individually
            LinkedHashMap<String, String> data  = new LinkedHashMap<>();
            // Get the row i.e field names count
            int rowCount = s.getPhysicalNumberOfRows();
            // Now we need to iterate all rows but cell should increases once all row is done
            // i.e. (1,1),(2,1),(3,1),(4,1),(5,1) - First iteration
            //      (1,2),(2,2),(3,2),(4,2),(5,2) - Second iteration
            //      (1,3),(2,3),(3,3),(4,3),(5,3) - Third iteration
            for(int j = 1; j<rowCount ; j++) {
                Row r = s.getRow(j);
                // Field name is constant as 0th index
                String fieldName = r.getCell(0).getStringCellValue();
                String fieldValue = r.getCell(i).getStringCellValue();
                // Add data in map
                data.put(fieldName, fieldValue);

            }
            // Add map to list after each iteration
            dataList.add(data);

        }
        return dataList;
    }
}
