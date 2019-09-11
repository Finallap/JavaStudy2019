package sys.collection;

import java.util.*;

public class TestArrayAndLinkedList {
    public static void main(String[] args){
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(0,10);
        arrayList.add(3,30);

        System.out.println("ArrayList:" + arrayList);

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(arrayList);
        System.out.println("LinkedHashSet:" + linkedHashSet);

        TreeSet<Integer> treeSet = new TreeSet<>(arrayList);
        System.out.println("TreeSet:" + treeSet);

        LinkedList<Object> linkedList = new LinkedList<>(arrayList);
        System.out.println("LinkedList:" + linkedList);

        linkedList.add(1,"red");
        linkedList.removeLast();
        linkedList.addFirst("green");

        ListIterator<Object> iterator = linkedList.listIterator();

        System.out.println("Foeward iterator:");
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();

        System.out.println("Backward iterator:");
        while (iterator.hasPrevious()){
            System.out.print(iterator.previous()+" ");
        }
        System.out.println();
    }
}
