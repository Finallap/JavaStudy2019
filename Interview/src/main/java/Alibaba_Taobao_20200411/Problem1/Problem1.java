package Alibaba_Taobao_20200411.Problem1;

/**
 * @description: Problem1
 * 1.已知整数x，查找整数y，使得y=floor(x^(1/2))，即x的开方的整数部分
 * @date: 2020/4/11 19:13
 * @author: Finallap
 * @version: 1.0
 */
public class Problem1 {
    public static int sqrt(int x){
        long left = 0;
        long right = x / 2 + 1;
        while (left < right) {
            long mid = (left + right + 1) >> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return (int) left;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(399));
        System.out.println(sqrt(400));
        System.out.println(sqrt(401));
        System.out.println(sqrt((int) (Math.pow(2,31)-1)));
        System.out.println(sqrt(1));
        System.out.println(sqrt(0));
        System.out.println(sqrt(-1));
        System.out.println(sqrt(-100));
    }
}
