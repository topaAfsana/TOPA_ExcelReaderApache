package ExcelDataHandle.ReadExcelData;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelFileWay2 {

    //METHOD CALL
    public static void main(String[] args){
        ReadExcelFileWay2 .readCellValue2("excelFilePath","yourSheetName",2,0);
        //Parameters are just reference that could be parameterized
    }


    //METHOD DEFINITION
    static FileInputStream fis;
    static XSSFWorkbook wb;
    public static void readCellValue2(String filePath,String sheetnmae,int rowNum,int cellNum){
//WAY2:GET THE SPECIFIC ROWS AND CELL TO RUN TEST ON SINGLE SET OF DATA

//    1.DEFINE THE FILE PATH using JAVA File class

//      File XlsSrc= new File("/Users/abraartishan/Desktop/readTest.xlsx");
        File XlsSrc= new File("src/main/resources/ExcelDataFiles/readTest.xlsx");

//    2.ACCESS FILE BYTES USING JAVA FILE INPUT STREAM CLASS SPECIFYING THE FILE OBJECT
        {try {fis = new FileInputStream(XlsSrc);} catch (FileNotFoundException e) {e.printStackTrace();}}

//     3.CREATE WORKBOOK INSTANCE THAT REFERS TO THE XLS FILE
        {try {wb = new XSSFWorkbook(fis);} catch (IOException e) {e.printStackTrace();}}

//     4.CREATE SHEET OBJECT AND GET SHEET BY NAME OF THE DEFINED WORKBOOK OF THE XLS FILE
//      XSSFSheet st= wb.getSheet("Authentication"); //GET SHEET BY NAME
        XSSFSheet st= wb.getSheetAt(0);        //GET SHEET BY INDEX
        System.out.println("LOG: SHEET NAME IS: "+st.getSheetName());

//      5.WITHOUT ITERATING GET THE SPECIFIC CELL VALUE USING INDEX OF ROW AND CELL
//        XSSFCell stringCell= st.getRow(rowNum).getCell(cellNum);
        XSSFCell stringCell= st.getRow(1).getCell(0);
        System.out.println(stringCell.getStringCellValue());

//        XSSFCell numCell= st.getRow(rowNum).getCell(cellNum);
        XSSFCell numCell= st.getRow(1).getCell(1);
        System.out.println(numCell.getNumericCellValue());
    }


}
//EXCEL SHEET PATTERN
//row1|userName|password
//row2|cell1-Index 0|cell2-Index 1|
//row3|cell1|cell2|

