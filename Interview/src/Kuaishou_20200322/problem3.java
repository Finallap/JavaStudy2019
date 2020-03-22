package Kuaishou_20200322;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @description: problem3
 * @date: 2020/3/22 19:50
 * @author: Finallap
 * @version: 1.0
 * <p>
 * 寻找手机号后8位的豹子和顺子
 * <p>
 * 输入:[15112347234,15176313245,15176313346,15176313325,15166667234,15188847234]
 * 输出:[15166667234,15112347234,15188847234]
 */
public class problem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] inputStrings = input.split(",");
        if (inputStrings == null || inputStrings.length == 0) {
            System.out.print("null");
            return;
        }

        //统计结果
        int[] increaseSeqCount = new int[inputStrings.length];
        int[] repeatNumCount = new int[inputStrings.length];
        int[] finalValue = new int[inputStrings.length];

        for (int i = 0; i < inputStrings.length; i++) {
            int[] numSeq = stringToIntArray(inputStrings[i]);
            increaseSeqCount[i] = findLongestIncreaseSeq(numSeq);
            repeatNumCount[i] = findLongestSame(numSeq);
            finalValue[i] = (int) (Math.pow(10.0, increaseSeqCount[i]) * 1 + Math.pow(10.0, repeatNumCount[i]) * 1.1);
        }

        PriorityQueue<PhoneNum> queue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
        for (int i = 0; i < inputStrings.length; i++) {
            if (finalValue[i] > 2) {
                queue.offer(new PhoneNum(inputStrings[i], finalValue[i]));
            }
        }

        if (queue.size() == 0) {
            System.out.print("null");
        } else {
            StringBuffer sb = new StringBuffer();
            while (queue.size() != 0) {
                PhoneNum phoneNum = queue.poll();
                sb.append(phoneNum.phoneNum + ",");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.print(sb.toString());
        }
    }

    public static class PhoneNum {
        public String phoneNum;
        public int value;

        public PhoneNum(String phoneNum, int value) {
            this.phoneNum = phoneNum;
            this.value = value;
        }
    }

    public static int[] stringToIntArray(String str) {
        char[] chars = str.toCharArray();
        int[] array = new int[chars.length - 3];
        for (int i = 3; i < chars.length; i++) {
            array[i - 3] = Integer.parseInt(String.valueOf(chars[i]));
        }
        return array;
    }

    public static int findLongestSame(int[] nums) {
        int result = 1;
        int lastNum = nums[0];
        int lastIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != lastNum) {
                result = Math.max(result, i - lastIndex);
                lastNum = nums[i];
                lastIndex = i;
            }
        }
        return result >= 3 ? result : 0;
    }

    public static int findLongestIncreaseSeq(int[] nums) {
        int result = 1;
        int lastIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[i] - nums[i - 1]) != 1) {
                result = Math.max(result, i - lastIndex);
                lastIndex = i;
            }
        }
        return result >= 3 ? result : 0;
    }
}
