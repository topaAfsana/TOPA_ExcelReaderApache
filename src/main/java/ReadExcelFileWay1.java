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
public static void main(String[] args){
    ReadExcelFileWay1.readCellValue1();
}
    static FileInputStream fis;
    static XSSFWorkbook wb;
    public static void readCellValue1(){
//WAY1:ITERATE THE ROWS AND CELL TO RUN TEST ON MULTIPLE SET OF DATA


//    1.DEFINE THE FILE PATH using JAVA File class
//      File XlsSrc= new File("/Users/abraartishan/Desktop/readTest.xlsx");
        File XlsSrc= new File("src/main/resources/readTest.xlsx");



//    2.ACCESS FILE BYTES USING JAVA FILE INPUT STREAM CLASS SPECIFYING THE FILE OBJECT
        {try {fis = new FileInputStream(XlsSrc);} catch (FileNotFoundException e) {e.printStackTrace();}}

//     3.CREATE WORKBOOK INSTANCE THAT REFERS TO THE XLS FILE
        {try {wb = new XSSFWorkbook(fis);} catch (IOException e) {e.printStackTrace();}}

//     4.CREATE SHEET OBJECT AND GET SHEET BY NAME OF THE DEFINED WORKBOOK OF THE XLS FILE
//      XSSFSheet st= wb.getSheet("Authentication");//GET SHEET BY NAME
        XSSFSheet st= wb.getSheetAt(0);       //GET SHEET BY INDEX
        System.out.println("LOG: SHEET NAME IS: "+st.getSheetName());

//    5. CREATE ITERATION OBJECT OF APACHE ROW USING JAVA UTIL ITERATOR CLASS THAT RETRIEVED FROM SHEET ITERATOR
        Iterator<Row> rowItr=st.iterator();


//    6.ITERATING OVER ROWS UNTIL IT HAS NEXT ROW AND CREATE ROW OBJECT OF EACH ROW OF THE ITERATION
//      WHILE ON EACH ROW ITERATION ITERATE OVER AGAIN TO ITS ALL CELLS
//      SO CREATE ROW ITERATOR OF CELL OBJECT RETRIVED FROM ROW ITERATOR AND CREATE CELL OBJECT OF CELLS ITERATION
        {while(rowItr.hasNext()){Row row= rowItr.next();
            Iterator<Cell> cellItr= row.iterator();
            while(cellItr.hasNext()){Cell cell=cellItr.next();
                // IN EACH CELL ITERATION GET STRING CELL VALUE
                System.out.println(cell.getStringCellValue());
                // IN EACH CELL ITERATION GET NUMERIC CELL VALUE
                System.out.println(cell.getNumericCellValue());
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
