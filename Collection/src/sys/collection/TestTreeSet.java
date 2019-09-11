package sys.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args){
        Set<String> set = new LinkedHashSet<>();

        set.add("London");
        set.add("Paris");
        set.add("Beijing");
        set.add("New York");
        set.add("San Francisco");
        System.out.println(set);

        TreeSet<String> treeSet = new TreeSet<>(set);
        System.out.println(treeSet);

        System.out.println("first:"+treeSet.first());
        System.out.println("last:"+treeSet.last());
        System.out.println("headSet:"+treeSet.headSet("Beijing"));
        System.out.println("headSet:"+treeSet.tailSet("Beijing"));
    }
}
