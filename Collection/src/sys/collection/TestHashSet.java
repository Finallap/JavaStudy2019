package sys.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestHashSet {
    public static void main(String[] args){
        Set <String> set = new HashSet<String>();
        set.add("London");
        set.add("Paris");
        set.add("Beijing");
        set.add("New York");
        set.add("San Francisco");

        System.out.println(set);

        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()){
            System.out.print(iterator.next().toUpperCase()+",");
        }
        System.out.println();
        System.out.println("Size:"+set.size());

        System.out.println("HashCode:"+set.hashCode());
        set.remove("Beijing");

        for (String s : set) {
            System.out.print(s+",");
        }
        System.out.println();
        System.out.println("Size:"+set.size());

        Set<String> set2 = new HashSet<>(set);
        set2.add("Nanjing");
        System.out.println(set2);

        set2.removeAll(set);
        System.out.println(set2);

        set2.addAll(set);
        System.out.println(set2);

    }
}
