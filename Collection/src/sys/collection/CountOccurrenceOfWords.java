package sys.collection;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CountOccurrenceOfWords {
    public static void main(String[] args){
        String text = "Good Morning. Have a good class. " +
                "Have a good visit. Have Fun!";

        TreeMap<String,Integer> map = new TreeMap<>();

        String[] words = text.split("[ \n\t\r.,;:!?(){]");
        for (String key:words) {
            key = key.toLowerCase();

            if (key.length()>0){
                if(map.get(key) == null){
                    map.put(key,1);
                }
                else{
                    int value = map.get(key).intValue();
                    value++;
                    map.put(key,value);
                }
            }
        }

        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();

        for (Map.Entry<String,Integer> entry:
             entrySet) {
            System.out.println(entry.getKey()+"\t"+entry.getValue());
        }
    }
}
