import java.util.Random;

/**
 * @description: Random:一个打乱有限数字集合的随机数生成器
 * @date: 2020/4/5 12:00
 * @author: Finallap
 * @version: 1.0
 */
public class RandomGet {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int length = 100000000;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = i;
        }

        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(length);
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }

        long endTime = System.currentTimeMillis();

        //Console.WriteLine(string.Join(",", array));
        System.out.println("Done!");
        System.out.println("Time:" + (endTime - startTime) + "ms");
    }
}
