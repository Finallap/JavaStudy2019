package my.collection;

public class MyArrayList<E> extends MyAbstractList<E> {
    public static final int INITIAL_CAPACITY = 16;
    private E[] data = (E[])new Object[INITIAL_CAPACITY];

    public MyArrayList(){
    }

    public MyArrayList(E[] objects){
        for (int i = 0; i<objects.length; i++){
            add(objects[i]);
        }
    }

    @Override
    public void add(int index, E e) {
        ensureCapacity();

        for (int i = size - 1; i >= index; i--)
            data[i+1] = data[i];

        data[index] = e;
        size++;
    }

    private void ensureCapacity(){
        if(size >= data.length){
            E[] newData = (E[]) new Object[2 * size +1];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    @Override
    public void clean() {
        data = (E[])new  Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public E remove(int index) {
        E e = data[index];

        for (int i = index; i<size; i++)
            data[i] = data[i+1];

        data[size-1] = null;
        size--;

        return e;
    }

    @Override
    public E get(int index) {
        return data[index];
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i<size; i++) {
            if (e.equals(data[i])) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        for (int i = size - 1; i >= 0; i--) {
            if (e.equals(data[i])) return i;
        }
        return -1;
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i<size; i++) {
            if (e.equals(data[i])) return true;
        }
            return false;
    }

    @Override
    public Object set(int index, E e) {
        Object old = get(index);
        data[index] = e;
        return old;
    }

    public String toString(){
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i<size; i++){
            result.append(data[i]);
            if (i < size - 1) result.append(", ");
        }

        return result + "]";
    }

    public void trimToSize(){
        if(data.length != size){
            E[] newData = (E[]) new Object[size];
            System.arraycopy(data , 0, newData, 0, size);
            data = newData;
        }
    }
}
