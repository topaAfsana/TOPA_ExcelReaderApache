import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelFileWay2 {

    //METHOD CALL
    public static void main(String[] args) {
        WriteExcelFileWay2.writeCellValue2();
    }


    //METHOD DEFINITION
    static FileOutputStream fos;
    static XSSFWorkbook workbook;

    public static void writeCellValue2() {
        //WAY2:ADDING DATA USING SPECIFIC ROW AND COLUMN,CREATING NON-EXISTING FILE AND WRITE IN IT

        //1.CREATE BLANK WORKBOOK
        workbook= new XSSFWorkbook();
        //2.CREATE SHEET BY  NAME IN THE WORKBOOK
        XSSFSheet sheet=workbook.createSheet("Product Details");

        //3.CREATE ROW
        Row row=sheet.createRow(0);
        //4.CREATE CELL
        Cell cell=row.createCell(0);
        //5.SET  VALUE TO THE CELL
        cell.setCellValue("NAME");

        //6.CREATE FILE DESTINATION PATH
        File xlsDest= new File("src/main/resources/writeTest2.xlsx");
        //7.WRITE STREAM PROCESS USING FILE OUTPUT STREAM CLASS
        try {fos=new FileOutputStream(xlsDest);} catch (FileNotFoundException e) {e.printStackTrace();}

        //8.WRITE TO WORKBOOK AND CLOSE THE FILE OUTPUT STREAM IF DONE
        try {workbook.write(fos);fos.close();} catch (IOException e) {e.printStackTrace();}
        System.out.println(cell.getStringCellValue());

    }


}
