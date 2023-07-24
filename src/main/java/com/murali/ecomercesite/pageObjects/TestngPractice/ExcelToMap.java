package com.murali.ecomercesite.pageObjects.TestngPractice;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelToMap {

    public Map<String,String> getExcelData() throws IOException {
        File f = new File("Excel/Test1.xlsx");
        FileInputStream fis = new FileInputStream(f);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheet("Sheet1");
        HashMap<String, String> map
                = new HashMap<String, String>();
        for (int r = 0; r <= sh.getLastRowNum(); r++) {
            String key = sh.getRow(r)
                    .getCell(0)
                    .getStringCellValue();
            String value = sh.getRow(r)
                    .getCell(1)
                    .getStringCellValue();
            map.put(key, value);
        }

        return map;
    }

}
