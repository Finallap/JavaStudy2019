package sys.collection;

import java.util.*;

public class SetListPerformanceTest {
    public static void main(String[] args) {
        Collection<Integer> set1 = new HashSet<>();
        System.out.println("Time for hash set:" + getTestTime(set1,1000000));

        Collection<Integer> set2 = new LinkedHashSet<>();
        System.out.println("Time for linked hash set:" + getTestTime(set2,1000000));

        Collection<Integer> set3 = new TreeSet<>();
        System.out.println("Time for tree set:" + getTestTime(set3,1000000));

        Collection<Integer> list1 = new ArrayList<>();
        System.out.println("Time for array list:" + getTestTime(list1,100000));

        Collection<Integer> list2 = new LinkedList<>();
        System.out.println("Time for linked list:" + getTestTime(list2,100000));
    }

    public static long getTestTime(Collection<Integer> c , int size){
        long startTime = System.currentTimeMillis();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<size ; i++){
            list.add(i);
        }

        Collections.shuffle(list);

        for (Integer element:list) {
            c.add(element);
        }

        Collections.shuffle(list);

        for (Integer element:list) {
            c.remove(element);
        }

        long endTime = System.currentTimeMillis();

        return  endTime - startTime;
    }
}
