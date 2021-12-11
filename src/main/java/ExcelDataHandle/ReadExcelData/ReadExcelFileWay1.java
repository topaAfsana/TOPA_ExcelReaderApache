package ExcelDataHandle.ReadExcelData;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcelFileWay1 {

//METHOD CALL
public static void main(String[] args){
    ReadExcelFileWay1.readCellValue1();
}


//METHOD DEFINITION

    static FileInputStream fis;
    static XSSFWorkbook workbook;
    public static void readCellValue1(){
//WORKS(EXCEPT NUM VALUE) AND WILL FOLLOW THIS ONE
//WAY1:ITERATE THE ROWS AND CELL TO RUN TEST ON MULTIPLE SET OF DATA


//    1.DEFINE THE FILE PATH using JAVA File class
//      File XlsSrc= new File("/Users/abraartishan/Desktop/readTest.xlsx");
        File XlsSrc= new File("src/main/resources/ExcelDataFiles/readTest.xlsx");



//    2.ACCESS FILE BYTES USING JAVA FILE INPUT STREAM CLASS SPECIFYING THE FILE OBJECT
        {try {fis = new FileInputStream(XlsSrc);} catch (FileNotFoundException e) {e.printStackTrace();}}

//     3.CREATE WORKBOOK INSTANCE THAT REFERS TO THE XLS FILE
        {try {workbook = new XSSFWorkbook(fis);} catch (IOException e) {e.printStackTrace();}}

//     4.CREATE SHEET OBJECT AND GET SHEET BY NAME OF THE DEFINED WORKBOOK OF THE XLS FILE
//      XSSFSheet st= wb.getSheet("Authentication");//GET SHEET BY NAME
        XSSFSheet sheet= workbook.getSheetAt(0);//GET SHEET BY INDEX
        System.out.println("LOG: SHEET NAME IS: "+sheet.getSheetName());

//ITERATION PART
//    5. CREATE ITERATION OBJECT OF APACHE ROW USING JAVA UTIL ITERATOR CLASS THAT RETRIEVED FROM SHEET ITERATOR
        Iterator<Row> sheetRowsItr=sheet.iterator();


//    6.ITERATING OVER ROWS UNTIL IT HAS NEXT ROW AND CREATE ROW OBJECT OF EACH ROW OF THE ITERATION
//      WHILE ON EACH ROW ITERATION ITERATE OVER AGAIN TO ITS ALL CELLS
//      SO CREATE ROW ITERATOR OF CELL OBJECT RETRIVED FROM ROW ITERATOR AND CREATE CELL OBJECT OF CELLS ITERATION
        {while(sheetRowsItr.hasNext()){Row row= sheetRowsItr.next();
            Iterator<Cell> rowCellItr= row.iterator();
            while(rowCellItr.hasNext()){Cell cell=rowCellItr.next();
                // IN EACH CELL ITERATION GET STRING CELL VALUE
                System.out.println(cell.getStringCellValue());
                // IN EACH CELL ITERATION GET NUMERIC CELL VALUE
//                System.out.println(cell.getNumericCellValue());
            }
        }
        }
    }


//CLASS END
}

//EXCEL SHEET PATTERN
//row1|userName|password
//row2|cell1|cell2|
//row3|cell1|cell2|
