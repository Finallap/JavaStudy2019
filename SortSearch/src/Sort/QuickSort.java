package Sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] list = {51, 23, 55, 63, 85, 45, 36, 54, 25, 63, 22, 52, 36, 45, 78, 23, 56, 45, 85, 75, 96, -65, 55, 12, -5};
        quickSort(list);
        for (int value : list)
            System.out.print(value + "\t");
    }

    public static void quickSort(int[] list) {
        quickSort(list,0,list.length-1);
    }

    private static void quickSort(int[] list, int first, int last){
        if(last > first){
            int pivotIndex = partition(list, first, last);
            quickSort(list, first,pivotIndex-1);
            quickSort(list,pivotIndex+1, last);
        }
    }

    private static int partition(int[] list, int first, int last){
        int pivot = list[first];
        int low = first + 1;
        int high = last;

        while (low < high){
            while (list[low] <= pivot && low <= high)
                low++;

            while (list[high] > pivot && high >= low)
                high--;

            if (high > low){
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high] >= pivot)
            high--;

        if (pivot > list[high]){
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else return first;
    }
}
