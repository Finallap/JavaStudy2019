package simulation_Feb;

/**
 * @description: Kaifang: 给定一个精度求一个数的平方根
 * @date: 2020/3/30 17:04
 * @author: Finallap
 * @version: 1.0
 */
public class Kaifang {
    public static double prescribe(double n, double accuracy) {
        double low = 0, high = n;
        double result = 0;
        while (low < high) {
            double mid = (low + high) / 2;
            double pingFang = Math.pow(mid, 2);
            double gap = Math.abs(pingFang - n);
            if (gap < Math.pow(accuracy, 2)) {
                result = mid;
                break;
            } else if (pingFang > n)
                high = mid;
            else
                low = mid;
        }
        return result;
    }

    public static void main(String[] args) {
        double n = 100, accuracy = 0.00001;
        System.out.println(prescribe(n, accuracy));
    }
}


