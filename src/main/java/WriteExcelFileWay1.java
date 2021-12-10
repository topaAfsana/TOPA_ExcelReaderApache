import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WriteExcelFileWay1 {

    //METHOD CALL
    public static void main(String[] args) {
        WriteExcelFileWay1.writeCellValue1();
    }


    //METHOD DEFINITION
    static FileOutputStream fos;
    static XSSFWorkbook workbook;

    public static void writeCellValue1() {
        //WORKS AND WILL FOLLOW THIS ONE
        //WAY1:CREATING DATA STRUCTURE AND ITERATE OVER THE DATA AND CREATING ROW AND CELL AND
        // CREATING NON-EXISTING FILE AND WRITE IN IT


        //1.CREATE BLANK WORKBOOK
        workbook=new XSSFWorkbook();

        //2.CREATE A SHEET WITH NAME
        XSSFSheet sheet=workbook.createSheet("Product Details");


        //A)STEPS FOR WHAT DATA TO ADD
        //3.CREATE SHEET DATA STRUCTURE USING MAP OF KEY AS STRING AND VALUE AS OBJECT ARRAY OF TREEMAP->1 TO MANY DATA STRUCTURE
        Map<String,Object[]> data=new TreeMap<String,Object[]>();

        //4.CREATE DATA TO THAT TREE MAP(FIRST INPUT(KEY) REFER ROW NUMBER,SECOND INPUT(VALUE) IS A LIST OBJECT REPRESENTS COLUMN/CELL OF EACH ROW )
        data.put("1",new Object[]{"ID","NAME","PRICE"});
        data.put("2",new Object[]{"1","APPLE","2.30"});
        data.put("3",new Object[]{"2","ORANGE","4.00"});


        //4.CREATE CELL USING THE SECOND INPUT DATA'S THROUGH ITERATION OF KEY-SET/KEYS OF THE MAP


        //B)STEPS FOR WHERE AND HOW TO ADD DATA
        //5.STORE ALL THE KEY VALUE IN SET(ORDERED AND NON-DUPLICATE/UNIQUE KEY/ELEMENT) DATA STRUCTURE RETRIVED FROM MAP KEY-SET METHOD
        Set<String> keySet=data.keySet();
        //ITERATE ROWS/KEY HERE START FROM 0
        int rowNum=0;
        for(String key:keySet){
        //5.CREATE ROWS> CREATE APACHE ROW OBJECT TO STORE THE KEY AS ROWS IN THE DEFINED SHEET IN EACH ITERATION STARTING FROM 0
            Row row=sheet.createRow(rowNum++);

        //6.CREATE CELL> ONCE EACH ROW CREATED ON SAME ITERATION ADD ALL THE LIST OF DATAS(TREE-MAP VALUE) CORRESPONDING TO EACH KEY/ROW WILL BE ADDED AS CELL
        // TO ITERATE OVER THE LIST OF DATA OF OBJECT[] WE CREATE ANOTHER OBJECT STORAGE TO STORE DATA RETRIEVED FROM EACH KEY/ROW
            Object[] cellArray=data.get(key);
        //ITERATE CELLS HERE START FROM 0
            int cellNum=0;
            for(Object cellObj:cellArray){
                Cell cell=row.createCell(cellNum++);
                if(cellObj instanceof String){cell.setCellValue((String)cellObj);}
                else if(cellObj instanceof Integer){cell.setCellValue((Integer)cellObj);}}
        }

        // 7.AFTER INSERTING DATA IN THE APACHE SHEET OBJECT WE NEED DEFINE FILE AND PATH TO WRITE THE OBJECT TO A XLS EXCEL FILE USING FILE CLASS
        // File xlsDest= new File("/Users/abraartishan/Desktop/writeTest.xlsx");
        File xlsDest= new File("src/main/resources/writeTest.xlsx");

        //8.PROCESS WRITING THAT FILE(INCLUDED THE ROWS AND CELLS OF SHEET) USING FILE-OUTPUT-STREAM
        try {fos=new FileOutputStream(xlsDest);} catch (FileNotFoundException e) {e.printStackTrace();}

        //9.WRITE THE FILE STREAM TO APACHE WORKBOOK THAT WE CREATED STEP 1
        try {workbook.write(fos);
            //CLOSE FILE OUTPUT STREAM ONCE DONE WRITING TO WORKBOOK
            fos.close();System.out.println("NEW EXCEL FILE CREATED SUCCESSFULLY ");} catch (IOException e) {e.printStackTrace();}


    }

}


//MAP(TREE-MAP) PATTERN
//KEY-->VALUES
//1-->(ID,NAME,PRICE)
//2-->(1,APPLE,2.30)
//3-->(1,ORANGE,4.00)



//EXCEL SHEET PATTERN
//row1|ID|NAME|PRICE
//row2|APPLE|2.30|
//row3|ORANGE|4.00|

