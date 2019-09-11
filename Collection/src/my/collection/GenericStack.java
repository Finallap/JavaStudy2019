package my.collection;

import java.util.ArrayList;

public class GenericStack<E> {
    private ArrayList<E> list = new ArrayList<>();

    public int getSize(){
        return list.size();
    }

    public E peek(){
        return list.get(list.size()-1);
    }

    public void push(E e){
        list.add(e);
    }

    public E pop(){
        return list.remove(getSize()-1);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
}
