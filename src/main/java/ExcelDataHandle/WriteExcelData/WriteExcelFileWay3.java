package ExcelDataHandle.WriteExcelData;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WriteExcelFileWay3 {

    //METHOD CALL
    public static void main(String[] args) {
        WriteExcelFileWay3.writeCellValue3();
    }

    //METHOD DEFINITION
    static FileInputStream fis;
    static XSSFWorkbook workbook;

    public static void writeCellValue3() {
        //WAY3:ADDING DATA USING SPECIFIC ROW AND COLUMN,ACCESSING EXISTING FILE AND WRITE IN IT\

        //1.DEFINE EXISTING EXCEL FILE PATH USING FILE CLASS
        File xlsSrc= new File("src/main/resources/ExcelDataFiles/writeTest2.xlsx");
        //2.ACCESS THE FILE USING FILE INPUT STREAM
        try {fis=new FileInputStream(xlsSrc);} catch (FileNotFoundException e) {e.printStackTrace();}

        //3.ACCESS THE WORKBOOK OF THAT EXCEL FILE DEFINED ABOVE
        try {workbook= new XSSFWorkbook(fis);} catch (IOException e) {e.printStackTrace();}

        //4.CREATE OR GET SHEET OF THAT WORKBOOK OF THE EXISTING EXCEL FILE
//         XSSFSheet sheet=workbook.getSheet("Product Details");
        // XSSFSheet sheet=workbook.getSheetAt(0);
        XSSFSheet sheet=workbook.createSheet("Product Details2");

        //5.CREATE ROW
        XSSFRow row=sheet.createRow(0);
        //6.CREATE CELL
        XSSFCell cell=row.createCell(0);
        //7.SET VALUE TO THE CELL
        cell.setCellValue("TOMA");
        System.out.println(cell.getStringCellValue());

    }
}
