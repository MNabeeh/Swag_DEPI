//package data_Excel;
//
//import org.apache.poi.EmptyFileException;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.testng.Assert;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class excelWork {
//
//    private FileInputStream fis;
//    private FileOutputStream fos;
//    private XSSFWorkbook workbook;
//    private XSSFSheet sheet;
//    private XSSFRow row;
//    private XSSFCell cell;
//    private String excelFilePath;
//    private int columnNumber = 0, rowNumber = 0;
//
//    private void initializeVariables() {
//        fis = null;
//        fos = null;
//        workbook = null;
//        sheet = null;
//        row = null;
//        cell = null;
//        excelFilePath = "";
//    }
//
//    public excelWork() {
//        initializeVariables();
//    }
//
//    public excelWork(String excelFilePath) {
//        initializeVariables();
//        this.excelFilePath = excelFilePath;
//        try {
//            fis = new FileInputStream(excelFilePath);
//            workbook = new XSSFWorkbook(fis);
//            fis.close();
//        }
//        catch (EmptyFileException e) {
//            System.out.println("The file [" + excelFilePath + "] is empty.");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        List<List<Object>> attachments = new ArrayList<>();
//        List<Object> testDataFileAttachment = null;
//        try {
//            testDataFileAttachment = Arrays.asList("Test Data", "Excel", new FileInputStream(excelFilePath));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            //unreachable code because if the file was not found then the reader would have failed at a previous step
//        }
//        attachments.add(testDataFileAttachment);
//    }
//
//    public ExcelFileManager(String excelFilePath, String sheetName) {
//        initializeVariables();
//        this.excelFilePath = excelFilePath;
//        try {
//            fis = new FileInputStream(excelFilePath);
//            workbook = new XSSFWorkbook(fis);
//            CustomReporter.getInstance().logConsole("Reading test data from the following file [ " + excelFilePath + " ],and sheet [ " + sheetName + " ].");
//            switchToSheet(sheetName);
//            fis.close();
//        } catch (IOException | OutOfMemoryError e) {
//            CustomReporter.getInstance().logError("There is no file exist in the path: [ " + excelFilePath + " ], and sheet: [ " + sheetName + " ] , please check the path and try again." + EXCEPTION_ERROR_MESSAGE + e.getMessage());
//            Assert.fail("Couldn't find the desired file. [" + excelFilePath + "] and sheet: [ " + sheetName + " ] ,  " + EXCEPTION_ERROR_MESSAGE + e.getMessage(), e);
//        } catch (EmptyFileException e) {
//            CustomReporter.getInstance().logError("There is no file exist in the path: [ " + excelFilePath + " ] as it may be corrupted, and sheet: [ " + sheetName + " ] ,   please check the path and try again." + EXCEPTION_ERROR_MESSAGE + e.getMessage());
//            Assert.fail("Please check the target file, as it may be corrupted. [" + excelFilePath + "]. and sheet: [ " + sheetName + " ] ,   " + EXCEPTION_ERROR_MESSAGE + e.getMessage(), e);
//        }
//        List<List<Object>> attachments = new ArrayList<>();
//        List<Object> testDataFileAttachment = null;
//        try {
//            testDataFileAttachment = Arrays.asList("Test Data", "Excel", new FileInputStream(excelFilePath));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            //unreachable code because if the file was not found then the reader would have failed at a previous step
//        }
//        attachments.add(testDataFileAttachment);
//    }
//
//
//}
