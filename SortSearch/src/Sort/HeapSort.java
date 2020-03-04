package Sort;

public class HeapSort {
    public static void main(String[] args) {
        Integer[] list = {51, 23, 55, 63, 85, 45, 36, 54, 25, 63, 22, 52, 36, 45, 78, 23, 56, 45, 85, 75, 96, -65, 55, 12, -5};
        heapSort(list);
        for (int value : list)
            System.out.print(value + "\t");
    }

    public static <E extends Comparable> void heapSort(E[] list) {
        Heap<E> heap = new Heap<E>();

        for (E value : list){
            heap.add(value);
        }

        for (int i = heap.size() - 1; i >= 0 ; i--){
            list[i] = heap.remove();
        }
    }
}
