package ExcelDataReader;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class excel_new {

    public String filePath = "C:\\Users\\V18MMohamed138\\OneDrive - Vodafone Group\\Documents\\GitHub\\DEPI_Project\\src\\test\\java\\data_Excel\\swaglap.xlsx";

    public FileInputStream getFileInputStream(File filePath) throws FileNotFoundException {
        return new FileInputStream(filePath);
    }

    public Object[][] getDataLinkedHashData(String filePath, String sheetName, String columnNameCheck, String condition) {

        Object[][] data = null;
        List<LinkedHashMap<String, String>> tableList = new ArrayList<>();

        try (FileInputStream fis = getFileInputStream(new File(filePath));
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            int lastRowIndex = getLastRowNumber(sheet);
            int lastColumnIndex = getLastColumnNumber(sheet);
            int startRowIndex = 1; // Assuming the first row contains headers
            int numberOfTestCases = 0;
            int columnIndex = getColumnIndexByName(sheet, columnNameCheck);

            if (columnIndex == -1) {
                throw new RuntimeException("Column not found: " + columnNameCheck);
            }

            // Count test cases
            for (int rowIndex = startRowIndex; rowIndex <= lastRowIndex; rowIndex++) {
                if (getCellData(sheet, rowIndex, columnIndex).equalsIgnoreCase(condition)) {
                    numberOfTestCases++;
                }
            }

            data = new Object[numberOfTestCases][1];
            int tableIndex = 0;

            // Collect data for each matching case
            for (int rowIndex = startRowIndex; rowIndex <= lastRowIndex; rowIndex++) {
                if (getCellData(sheet, rowIndex, columnIndex).equalsIgnoreCase(condition)) {
                    LinkedHashMap<String, String> table = new LinkedHashMap<>();
                    for (int colIndex = 0; colIndex < lastColumnIndex; colIndex++) {
                        String key = Helper.Helpers.replaceAllSpaces(getCellData(sheet, 0, colIndex), false).toLowerCase();
                        String value = getCellData(sheet, rowIndex, colIndex);
                        table.put(key, value);
                    }
                    data[tableIndex++] = new Object[]{table}; // Store the table in the data array
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("File not found: " + filePath, e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read Excel file", e);
        }

        return data;
    }


    private String getCellData(XSSFSheet sheet, int rowIndex, int colIndex) {
        XSSFRow row = sheet.getRow(rowIndex);
        if (row == null) {
            return ""; // Return empty string if the row is null
        }

        XSSFCell cell = row.getCell(colIndex);
        if (cell == null) {
            return "Cell is empty"; // Handle empty cells
        }

        return "";

    }


    //    switch (cell.getCellType()) {
//        case STRING:
//            return cell.getStringCellValue();
//        case NUMERIC:
//            return String.valueOf(cell.getNumericCellValue());
//        case BOOLEAN:
//            return String.valueOf(cell.getBooleanCellValue());
//        case FORMULA:
//            return cell.getCellFormula();
//        default:
//            return "Unknown type"; // Handle other cell types if needed
//    }
//}
//
    public int getLastColumnNumber(XSSFSheet sheet) {
        XSSFRow row = sheet.getRow(0); // Get the first row (header row)
        return row != null ? row.getLastCellNum() : 0; // Return the last cell number, or 0 if the row is null
    }

    private int getColumnIndexByName(XSSFSheet sheet, String columnName) {
        XSSFRow headerRow = sheet.getRow(0); // Assuming the first row is the header
        if (headerRow != null) {
            for (int colIndex = 0; colIndex < headerRow.getPhysicalNumberOfCells(); colIndex++) {
                String cellValue = headerRow.getCell(colIndex).getStringCellValue();
                if (cellValue.equalsIgnoreCase(columnName)) {
                    return colIndex; // Return the index if the name matches
                }
            }
        }
        return -1; // Return -1 if the column is not found
    }

    private int getLastRowNumber(XSSFSheet sheet) {
        return sheet.getLastRowNum();
    }

}