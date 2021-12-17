package Collection;

import java.util.HashMap;
import java.util.Map;

public class JAVA_EXERCIZES {


    public static void main(String[] args) {
        JAVA_EXERCIZES.repeatedWordsInAString();
    }

    public static void repeatedWordsInAString(){
        String paragraph="I AM TOPA AND TOPA HAS SISTER AND BROTHER AND TOPA IS BRILLIANT";
        String[] stringArrayWords=paragraph.split(" ");

        Map<String,Integer> data=new HashMap<>();

        for(String word:stringArrayWords){
            if (data.containsKey(word)){
                data.put(word,data.get(word)+1);
            }
            else data.put(word,1);
        }

        for(Map.Entry<String,Integer> element:data.entrySet()){
            System.out.println(element.getKey()+ " : "+element.getValue());
        }
    }
}
