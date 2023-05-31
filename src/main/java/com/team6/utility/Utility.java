package com.team6.utility;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Base64;
import java.util.Properties;

public class Utility {
    public static String currentDir = System.getProperty("user.dir");

    public static Properties loadProperties(){
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(currentDir+File.separator+"config.properties");
            properties.load(fis);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String decode(String key){
        byte[] decodedBytes = Base64.getDecoder().decode(key);
        return new String(decodedBytes);
    }

    public static void main(String[] args) {
//       String originalInput = "";
//        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
//        System.out.println(encodedString);

        byte[] decodedBytes = Base64.getDecoder().decode("");
        String decodedString = new String(decodedBytes);
        System.out.println(decodedString);
    }


    @DataProvider(name = "info")
    public Object[][] personalDetails(Method mirror) throws Exception {

        String excelSheetName = mirror.getName();
        String currentDir = System.getProperty("user.dir");
        String path = currentDir + File.separator + "data" + File.separator + "orangehrm.xlsx";
        FileInputStream excelFile = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(excelFile);
        Sheet sheetName = wb.getSheet(excelSheetName);

        int totalRows = sheetName.getLastRowNum();
        System.out.println(totalRows);

        Row rowCells = sheetName.getRow(0);
        int totalColumn = rowCells.getLastCellNum();

        DataFormatter format = new DataFormatter();

        String[][] testData = new String[totalRows][totalColumn];
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalColumn; j++) {
                testData[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
                System.out.print(testData[i - 1][j] + " ");
            }
        }
        return testData;
    }
    @DataProvider(name = "registration")
    public Object[][] registrationDetails(Method mirror) throws Exception {

        String excelSheetName = mirror.getName();
        String currentDir = System.getProperty("user.dir");
        String path = currentDir + File.separator + "data" + File.separator + "scaledupit.xlsx";
        FileInputStream excelFile = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(excelFile);
        Sheet sheetName = wb.getSheet(excelSheetName);

        int totalRows = sheetName.getLastRowNum();
        System.out.println(totalRows);

        Row rowCells = sheetName.getRow(0);
        int totalColumn = rowCells.getLastCellNum();

        DataFormatter format = new DataFormatter();

        String[][] testData = new String[totalRows][totalColumn];
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalColumn; j++) {
                testData[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
                System.out.print(testData[i - 1][j] + " ");
            }
        }
        return testData;
    }
}