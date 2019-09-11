package sys.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args){
        Map<String,Integer> hashMap = new HashMap<>();
        hashMap.put("FANG",23);
        hashMap.put("LAN",22);
        hashMap.put("CHEN",50);
        hashMap.put("LIU",40);

        System.out.println(hashMap);

        Map<String,Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println(treeMap);

        Map<String,Integer> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
        linkedHashMap.put("FANG",23);
        linkedHashMap.put("LAN",22);
        linkedHashMap.put("CHEN",50);
        linkedHashMap.put("LIU",40);

        System.out.println("The age of Chen is:" + linkedHashMap.get("CHEN"));
        System.out.println(linkedHashMap);
    }
}
