package Sort;

/**
 * @description: shellSort:希尔排序，插入排序的改良版本，不稳定
 * @date: 2020/3/8 20:11
 * @author: Finallap
 * @version: 1.0
 */
public class shellSort {
    public static int[] sort(int[] list) {
        //初试增量为长度的一半，每次增量都减半
        for (int step = list.length / 2; step > 0; step /= 2) {
            //从增量那组开始进行插入排序，直至完毕
            for (int i = step; i < list.length; i++) {
                int j = i;
                int insertVal = list[j];
                while (j - step >= 0 && list[j - step] > insertVal) {
                    list[j] = list[j - step];
                    j = j - step;
                }
                list[j] = insertVal;
            }
        }
        return list;
    }

    public static int[] ShellSort1(int[] list) {
        for (int step = list.length / 2; step > 0; step /= 2) {
            for (int i = step; i < list.length; i++) {
                int j = i;
                int insertVal = list[j];
                while (j - step >= 0 && list[j - step] > insertVal) {
                    list[j] = list[j - step];
                    j = j - step;
                }
                list[j] = insertVal;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] list = {51, 23, 55, 63, 85, 45, 36, 54, 25, 63, 22, 52, 36, 45, 78, 23, 56, 45, 85, 75, 96, 35, 12};
        ShellSort1(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
    }
}
