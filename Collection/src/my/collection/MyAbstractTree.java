package my.collection;

import java.util.Iterator;

public abstract class MyAbstractTree<E extends Comparable<E>>
        implements Tree<E> {
    public void inorder(){}
    public void postorder(){}
    public void preorder(){}

    public boolean isEmpty(){
        return getSize()==0;
    }

    public Iterator iterator(){
        return null;
    }

}
