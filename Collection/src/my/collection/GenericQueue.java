package my.collection;

import java.util.LinkedList;

public class GenericQueue<E> {
    private LinkedList<E> list = new LinkedList<>();

    public void enqueue(E e){
        list.addLast(e);
    }

    public E depueue(){
        return list.removeFirst();
    }

    public int getSize(){
        return list.size();
    }

    public String toString(){
        return list.toString();
    }
}
