package my.collection;

public interface MyList<E> {
    public void add(E e);
    public void add(int index, E e);
    public void clean();
    public boolean remove(E e);
    public E remove(int index);
    public E get(int index);
    public int indexOf(E e);
    public int lastIndexOf(E e);
    public boolean isEmpty();
    public int size();
    public boolean contains(E e);
    public Object set(int index, E e);
}
