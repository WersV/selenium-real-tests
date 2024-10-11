package com.seleniumdemo.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    public static Object[][] readExcel(String fileName) throws IOException {
        File file = new File("src/test/resources/" + fileName);
        FileInputStream inputStream = new FileInputStream(file);

        Workbook workbook = null;
        String fileExt = fileName.substring(fileName.indexOf("."));
        if (fileExt.equals(".xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (fileExt.equals(".xls")) {
            workbook = new HSSFWorkbook(inputStream);
        }

        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][columnCount];

        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < columnCount; j++) {
                Cell cell = row.getCell(j);

                if (cell != null) {
                    // Check the cell type and read accordingly
                    if (cell.getCellType() == CellType.STRING) {
                        data[i - 1][j] = cell.getStringCellValue();
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        // If it's numeric, we convert it to String for consistency
                        data[i - 1][j] = (int) cell.getNumericCellValue();
                    } else {
                        data[i - 1][j] = cell.toString();  // Default case, just in case
                    }
                } else {
                    System.out.println("Cell is null");
                }
            }
        }

        workbook.close();
        inputStream.close();
        return data;
    }

    public static void main(String[] args) throws IOException {
        readExcel("logInData.xlsx");
    }
}