package Collection;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.STIconSetType;

import java.util.*;

public class CollectionTest {


    public static void main(String[] args) {

//        CollectionTest.mapTest();
//        CollectionTest.listTest();
//        CollectionTest.setTest();
    }

    public static void mapTest(){
        //A)CREATE MAP
        Map<String,String> siblings=new HashMap<String,String >();
        siblings.put("1","Topa");
        siblings.put("2","Toma");
        siblings.put("3","Tanjim");
        siblings.put("4","Jafrin");

        //B)ITERATE AND PRINT DATA:

        //WAY 1: ACCESSING ENTRY SET
        for(Map.Entry<String,String> row : siblings.entrySet()){
            System.out.println(row.getKey());
            System.out.println(row.getValue());
        }

        //WAY 2: STORING KEYS IN SET OBJECT
        Set<String> keys=siblings.keySet();
        for(String key: keys){
            System.out.println(key);
            System.out.println(siblings.get(key));
        }

    }

    public static void listTest(){
        //A)CREATE LIST
        //WAY 1
        List<String> subjects= new ArrayList<>();
        subjects.add("ENGLISH");
        subjects.add("BENGALI");
        subjects.add("MATH");

        //WAY 2
        List<String> courses= Arrays.asList("AWS,JAVA,RUBY");


        //B)ITERATE AND PRINT DATA:

        //WAY 1:FOR LOOP
        for(int i=0;i<subjects.size();i++){
            System.out.println(subjects.get(i));
        }

        //WAY 1: ENHANCED FOOR LOOP
        for(String course:courses){
            System.out.println(course);
        }





    }

    public static void setTest(){

        //A)CREATE SET
        Set<String> ssns=new HashSet<>();
        ssns.add("123");
        ssns.add("456");
        ssns.add("789");


        //B)ITERATE AND PRINT DATA:

        //WAY 1: ENHANCED FOR LOOP
        for(String ssn: ssns){
            System.out.println(ssn);
        }

        //WAY 2: IMPLEMENTING ITERATOR INTERFACE

        Iterator<String> ssnITR=ssns.iterator();
        while(ssnITR.hasNext()){
            String ssn=ssnITR.next();
            System.out.println(ssn);}





    }



}
