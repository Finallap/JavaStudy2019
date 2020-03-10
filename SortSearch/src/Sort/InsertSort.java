package Sort;

/**
 * @description: Sort.InsertSort:插入排序
 * @date: 2020/2/29 16:35
 * @author: Finallap
 * @version: 1.0
 */
public class InsertSort {
    public static void insertSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            //要插入的数
            int insertVal = list[i];
            //开始搜寻的索引
            int index = i - 1;
            //如果没到数组头部而且插入的数目比被插入的小，则把数字都后移
            while (index >= 0 && insertVal < list[index]) {
                list[index + 1] = list[index];
                index--;
            }
            list[index + 1] = insertVal;
        }
    }

    public static void insertSort1(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int insertVal = list[i];
            int index = i - 1;
            while (index >= 0 && list[index] > insertVal) {
                list[index + 1] = list[index];
                index--;
            }
            list[index + 1] = insertVal;
        }
    }

    public static void main(String[] args) {
        int[] list = {51, 23, 55, 63, 85, 36, 54, 25, 63, 22, 52, 36, 45, 78, 23, 56, 45, 85, 75, 96, 35, 12};
        insertSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
    }
}
