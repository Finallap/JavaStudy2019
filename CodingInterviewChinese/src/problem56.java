/**
 * @description: 剑指 problem56: 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次，找出这两个数。
 * 使用异或的方法计算，先将所有数字异或，找出不同的那位
 * 再根据那位将数组分成两部分，分别再进行异或，求出不同的数
 * @date: 2020/3/18 14:34
 * @author: Finallap
 * @version: 1.0
 */
public class problem56 {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        int length = array.length;
        if (length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int diff = 0;
        for (int num : array)
            diff ^= num;

        int index = findFirst1(diff);
        for (int num : array) {
            if (isBit1(num, index)) {
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }

    private int findFirst1(int diff) {
        int index = 0;
        while ((diff & 1) == 0 && index < 32) {
            index++;
            diff >>= 1;
        }

        return index;
    }

    private boolean isBit1(int target, int index) {
        return ((target >> index) & 1) == 1;
    }
}
