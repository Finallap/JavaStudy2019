public class MergeSort_1 {
    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            int[] leftHalf = new int[list.length / 2];
            System.arraycopy(list, 0, leftHalf, 0, list.length / 2);
            mergeSort(leftHalf);

            int[] rightHalf = new int[list.length - list.length / 2];
            System.arraycopy(list, list.length / 2, rightHalf, 0, list.length - list.length / 2);
            mergeSort(rightHalf);

            int[] result = merge(leftHalf, rightHalf);
            System.arraycopy(result, 0, list, 0, list.length);
        }
    }

    public static int[] merge(int[] leftHalf, int[] rightHalf) {
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;

        int[] temp = new int[leftHalf.length + rightHalf.length];

        while (index1 < leftHalf.length && index2 < rightHalf.length) {
            if (leftHalf[index1] < rightHalf[index2]) {
                temp[index3] = leftHalf[index1];
                index1++;
            } else {
                temp[index3] = rightHalf[index2];
                index2++;
            }
            index3++;
        }

        while (index1 < leftHalf.length) {
            temp[index3] = leftHalf[index1];
            index1++;
            index3++;
        }

        while (index2 < rightHalf.length) {
            temp[index3] = rightHalf[index2];
            index2++;
            index3++;
        }

        return temp;
    }

    public static void main(String[] args) {
        int[] list = {51, 23, 55, 63, 85, 45, 36, 54, 25, 63, 22, 52, 36, 45, 78, 23, 56, 45, 85, 75, 96, -65, 55, 12, -5};
        mergeSort(list);
        for (int value : list) {
            System.out.print(value + "\t");
        }
    }
}
