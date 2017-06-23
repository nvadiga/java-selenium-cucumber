package org.nvadiga.testdataextractor;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.nvadiga.objects.BrowserAction;
import org.nvadiga.objects.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * Created by nvadiga on 4/6/2017.
 */
public class ExcelExtractor {

    public static Sheet loadSheet(String fileName, String sheetName){
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(fileName));
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            return workbook.getSheet(sheetName);
        }catch(IOException e){
            System.out.println("Unable to open excel sheet");
            return null;
        }
    }

    public static List<BrowserAction> getActionsFromSheet(Sheet sheet){
        List<BrowserAction> browserActions = new ArrayList<BrowserAction>();
        Iterator<Row> rowIterator = sheet.rowIterator();
        rowIterator.next(); //First row
        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            String actionCell = getStringValue(row.getCell(0));
            String nameCell = getStringValue(row.getCell(1));
            String valueCell = getStringValue(row.getCell(2));
            String typeCell = getStringValue(row.getCell(3));
            String identifierCell = getStringValue(row.getCell(4));
            browserActions.add(new BrowserAction(actionCell,new Data(nameCell,valueCell,typeCell,identifierCell)));
        }
        return browserActions;
    }

    public static Properties getSheetAsProperties(Sheet sheet){
        Properties properties = new Properties();
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            String key = getStringValue(row.getCell(0));
            String value = getStringValue(row.getCell(1));
            properties.setProperty(key,value);
        }
        return  properties;
    }

    private static String getStringValue(Cell cell){
        if(cell == null){
            return "";
        }
        else{
            switch (cell.getCellTypeEnum()) {
                case BLANK:
                    return "";
                case STRING:
                    return cell.getStringCellValue();
                case NUMERIC:
                    return Double.toString(cell.getNumericCellValue());
                default:
                    return "";
            }
        }
    }
}
