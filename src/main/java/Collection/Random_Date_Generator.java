package Collection;

import java.time.LocalDate;

public class Random_Date_Generator {
    public static void main(String[] args) {
        System.out.println(Random_Date_Generator.createRandomDate(1900,2003));
        System.out.println(Random_Date_Generator.createRandomNumBetween(1900,2000));
        for(int i=0;i<10;i++){
            System.out.println(Random_Date_Generator.createRandomDate(2000,2003));
        }

                for(int i=0;i<3;i++){
                    System.out.println(Random_Date_Generator.getRandomNum(1,3));
        }
    }

    public static LocalDate createRandomDate(int startYear,int endYear){
        int day= createRandomNumBetween(1,28);
        int month=createRandomNumBetween(1,12);
        int year=createRandomNumBetween(startYear,endYear);
        return LocalDate.of(year,month,day);
    }

    public static int createRandomNumBetween(int start,int end){
        return start + (int) Math.round(Math.random() * (end-start));
    }

    public static int getRandomNum(int min,int max){
        return (int)(Math.random()*(max-min)+min);

    }
}
