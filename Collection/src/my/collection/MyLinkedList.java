package my.collection;

public class MyLinkedList<E> extends MyAbstractList<E> {
    private Node<E> head, tail;
    public MyLinkedList(){
    }

    public MyLinkedList(E[] objects){
        super(objects);
    }

    @Override
    public void add(int index, E e) {
        if (index == 0)addFirst(e);
        else if (index > size)addLast(e);
        else {
            Node<E> newNode = new Node<E>(e);
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++)
                current =  current.next;
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    @Override
    public void clean() {
        head = tail = null;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size)return null;
        else if (index == 0)return removeFirst();
        else if (index == size-1)return removeLast();
        else {
            Node<E> current = head;
            for (int i = 1; i < index; i++){
                current = current.next;
            }

            Node<E> opNode = current.next;
            current.next = opNode.next;
            size--;
            return opNode.element;
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || index>=size || size ==0) return null;
        else {
            Node<E> current = head;
            for (int i = 0; i < index; i++){
                current = current.next;
            }
            return current.element;
        }
    }

    @Override
    public int indexOf(E e) {
        if (size == 0)return -1;
        Node<E> current = head;
        for (int i = 1; i < size; i++){
            current = current.next;
            if (e.equals(current.element))return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        if (size == 0)return -1;
        Node<E> current = head;
        int index = -1;
        if (e.equals(current.element))index = 0;
        for (int i = 1; i <size; i++){
            current = current.next;
            if (e.equals(current.element))index = i;
        }
        return index;
    }

    @Override
    public boolean contains(E e) {
        if(indexOf(e)==-1)
            return false;
        else
            return true;
    }

    @Override
    public Object set(int index, E e) {
        Node<E> current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        Object element = current.element;
        current.element = e;
        return element;
    }

    public void addFirst(E e){
        Node<E> newNode = new Node<E>(e);
        newNode.next = head;
        head = newNode;
        size++;

        if (tail == null) tail = newNode;
    }

    public void addLast(E e){
        Node<E> newNode = new Node<E>(e);
        if (tail != null)tail.next = newNode;
        tail = newNode;
        size++;

        if (head == null)head = newNode;
    }

    public E removeFirst(){
        if (size == 0)return null;
        Node<E> temp = head;
        head = head.next;
        if (size == 1)tail = null;
        size--;
        return temp.element;
    }

    public E removeLast(){
        if (size == 0)return null;
        else if (size==1)
        {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        }else
        {
            Node<E> temp = tail;
            Node<E> current = head;

            for (int i = 0; i < size - 2; i++)
                current = current.next;
            tail = current;
            current.next = null;

            size--;
            return temp.element;
        }
    }

    public String toString(){
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;

        for (int i = 0; i<size;i++){
            result.append(current.element);
            current = current.next;
            if (current!=null)
                result.append(", ");
        }
        result.append("]");

        return result.toString();
    }
}
