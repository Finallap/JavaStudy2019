package my.collection;

public class TestMyLinkedList {
    public static void main(String[] args){
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("Amercica");
        System.out.println(list);

        list.add(0,"Canada");
        System.out.println(list);

        list.add("Russia");
        list.addFirst("France");
        list.add("Germany");

        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        list.removeLast();
        list.removeFirst();
        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list.indexOf("Russia"));
        System.out.println(list.indexOf("France"));

        list.addFirst("France");
        list.set(1,"China");
        System.out.println(list);
        System.out.println(list.lastIndexOf("France"));

    }
}
