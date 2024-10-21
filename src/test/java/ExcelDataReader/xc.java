//package data_Excel;
//
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.sql.ResultSet;
//import java.util.LinkedHashMap;
//
//import static jdk.xml.internal.SecuritySupport.getFileInputStream;
//
//public class xc {
//    public String filePath = "C:\\Users\\V18MMohamed138\\OneDrive - Vodafone Group\\Documents\\GitHub\\DEPI_Project\\src\\test\\java\\data_Excel\\swaglap.xlsx";
//
//
//    public Object[][] getDataLinkedHashData(String filePath, String sheetName, String columnNameCheck, String condition) {
//        Object[][] data = null;
//        LinkedHashMap<String, String> table = null;
//        try {
//            FileInputStream fis = getFileInputStream(new File(filePath));
//            XSSFWorkbook workbook = new XSSFWorkbook(fis);
//            XSSFSheet sheet = workbook.getSheet(sheetName);
//            System.out.println("Reading data from Excel file: [ " + filePath + " ] | Sheet: [ " + sheetName + " ]");
//
//            int lastRowIndex = getLastRowNumber();
//            int lastColumnIndex = getLastColumnNumber();
//            int startRowIndex = 1, numberOfTestCases = 0, tableIndex = 0;
//            String key, value;
//            try {
//                for (int rowIndex = startRowIndex; rowIndex <= lastRowIndex; rowIndex++) {
//                    if (getCellData(rowIndex + 1, columnNameCheck).equalsIgnoreCase(condition)) {
//                        numberOfTestCases++;
//                    }
//                }
//                CustomReporter.getInstance().logConsole("Start Row index: [ " + startRowIndex + " ] , last Row index [ " + lastRowIndex + " ], last column index: [ " + lastColumnIndex + " ]");
//                CustomReporter.getInstance().logConsole("Number of records match the condition [ " + condition + " ] in check column name [ " + columnNameCheck + " ] are [ " + numberOfTestCases + " records]");
//                data = new Object[numberOfTestCases][1];
//                for (int rowIndex = startRowIndex; rowIndex <= lastRowIndex; rowIndex++) {
//                    this.rowNumber = rowIndex + 1;
//                    if (getCellData(rowNumber, columnNameCheck).equalsIgnoreCase(condition)) {
//                        table = new LinkedHashMap<>();
//                        tableIndex = tableIndex + 1;
////                        table.put("runid", String.valueOf(tableIndex));
//                        for (int colIndex = 0; colIndex < lastColumnIndex; colIndex++) {
//                            this.columnNumber = colIndex + 1;
//                            key = Helper.replaceAllSpaces(getCellData(1, columnNumber), false).toLowerCase();
//                            value = getCellData(rowNumber, columnNumber);
//                            table.put(key, value);
//                            //  CustomReporter.getInstance().logConsole("Get cell Data from row [" + rowNumber + "], column : [ " + columnNumber + " ] - Key : [ " + key + " ], Value : [ " + value + " ] "); //debugging
//                        }
//                        CustomReporter.getInstance().logConsole("Record [ " + tableIndex + " ] from row [ " + rowNumber + " ]: [ " + table + " ]");
//                        data[tableIndex - 1][0] = table;
//                    }
//                }
//            } catch (Exception e) {
//                CustomReporter.getInstance().logError("Can't read data from File Path [ " + filePath + " ], Sheet: [ " + sheetName + " ]," + " Row: [ " + rowNumber + " ], Column: [ " + columnNumber + " ], data length [ " + data.length + " ] :" + Arrays.toString(data) + EXCEPTION_ERROR_MESSAGE + e.getMessage() + " ]");
//                e.printStackTrace();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            CustomReporter.getInstance().logError("There is no file exist in the path: [ " + filePath + " ] , please check the path and try again. " + e.getMessage());
//            Assert.fail("There is no file exist in the path: [ " + filePath + " ] , please check the path and try again. " + e.getMessage());
//        } catch (Exception e) {
//            e.printStackTrace();
//            CustomReporter.getInstance().logError("There is no file exist in the path: [ " + filePath + " ] , please check the path and try again. " + e.getMessage());
//        }
//        return data;
//    }
//
//    private String getCellData(int rowIndex ,  int colIndex,String columnNameCheck,XSSFSheet sheet) {
//        XSSFRow row = sheet.getRow(rowIndex);
//        if (row == null) {
//            return ""; // Return empty string if the row is null
//
//    }
//
//        XSSFCell cell = row.getCell(colIndex);
//        if (cell == null) {
//            return "Cell is empty"; // Handle empty cells
//        }
//
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
//                return "Unknown type"; // Handle other cell types if needed
//        }
//    }
//
//
//    private int getLastColumnNumber() {
//        ResultSet sheet;
//        XSSFRow row = sheet.getRow(0); // Assuming the first row has the column headers
//        return row != null ? row.getPhysicalNumberOfCells() : 0;
//    }
//
//    private int getLastRowNumber() {
//        return sheet.getLastRowNum();
//    }
//
//}
