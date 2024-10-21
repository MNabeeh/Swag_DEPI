package ExcelDataReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    private final String filePath ="C:\\Users\\V18MMohamed138\\OneDrive - Vodafone Group\\Documents\\GitHub\\DEPI_Project\\src\\test\\java\\ExcelDataReader\\swaglap.xlsx";

    public FileInputStream getFileInputStream(String filePath) throws FileNotFoundException {
        File srcFile = new File(filePath);
        return new FileInputStream(srcFile);

    }

    // this method to get all the data in the sheet.

    public Object[][] getExcelData(int sheetNumber) throws IOException {
        try {
            FileInputStream fis = getFileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
            int totalNumberOfRows = (sheet.getLastRowNum() + 1);
            int totalNumberOfColumns = (sheet.getRow(0).getLastCellNum());

            Object[][] arrayExcelData = new Object[totalNumberOfRows][totalNumberOfColumns];
            for (int i = 0; i < totalNumberOfRows; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < totalNumberOfColumns; j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null) {
                        arrayExcelData[i][j] = cell.toString();
                    } else {
                        arrayExcelData[i][j] = "";
                    }
                }
            }
            return arrayExcelData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


//        try  FileInputStream fis = getFileInputStream(filePath)
//
//            XSSFWorkbook workbook = new XSSFWorkbook(fis) ;
//            XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
//            int totalNumberOfRows = (sheet.getLastRowNum() + 1);
//            int totalNumberOfColumns = (sheet.getRow(0).getLastCellNum());
//
//            String[][] arrayExcelData = new String[totalNumberOfRows][totalNumberOfColumns];
//            for (int i = 0; i < totalNumberOfRows; i++) {
//                XSSFRow row = sheet.getRow(i);
//                for (int j = 0; j < totalNumberOfColumns; j++) {
//                    arrayExcelData[i][j] = row.getCell(j).toString();
//                }
//            }
//            return arrayExcelData;
//        }
//        catch (IOException es) {
//            throw new RuntimeException("Failed to read data from Excel", es);
//    }

//}

// this method to get a number of sheet and specific row

    public String[][] getExcelSpecificRow(int sheetNum, int rowNumber) {

        try (FileInputStream fis = getFileInputStream(filePath);

             XSSFWorkbook workbook2 = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook2.getSheetAt(sheetNum);
            XSSFRow row = sheet.getRow(rowNumber);


            int totalNumberOfColumns = row.getPhysicalNumberOfCells();
            String[][] rowData = new String[1][totalNumberOfColumns]; // Create a 2D array with 1 row

            for (int j = 0; j < totalNumberOfColumns; j++) {
                XSSFCell cell = row.getCell(j);
                rowData[0][j] = (cell != null) ? cell.toString() : "Cell is empty"; // Handle empty cells
            }
            return rowData;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read specific row data", e);
        }
    }

//    public List<String> readAnyDataFromTheExcel(String excelFilePath, int sheetIndex, Integer rowIndex, Integer[] cellIndices) throws FileNotFoundException {
//        List<String> rowData = new ArrayList<>();
//
//        try (FileInputStream fis = new FileInputStream(filePath);
//             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//            XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
//            XSSFRow row = sheet.getRow(rowIndex);
//
//            if (row == null) {
//                System.out.println("no row found");
//                return rowData;
//            }
//            if (cellIndices == null) {
//                for (Cell cell : row) {
//                    rowData.add(getCellValue(cell));
//                }
//            }
//             else {
//                // Read only the specified cell indices
//                for (int index : cellIndices) {
//                    Cell cell = row.getCell(index);
//                    rowData.add(getCellValue(cell));
//                }
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to read data from Excel", e);
//        }
//        return rowData;
//    }
//
//    // Helper method to get cell value as a string
//    private String getCellValue(Cell cell) {
//        if (cell == null) {
//            return "Cell is empty"; // Handle empty cells
//        }
//        switch (cell.getCellType()) {
//            case STRING:
//                return cell.getStringCellValue();
//            case NUMERIC:
//                return String.valueOf(cell.getNumericCellValue());
//            case BOOLEAN:
//                return String.valueOf(cell.getBooleanCellValue());
//            case FORMULA:
//                return cell.getCellFormula();
//            default:
//                return "Unknown type";
//        }
//    }




}







