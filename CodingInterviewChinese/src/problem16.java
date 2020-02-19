public class problem16 {
    public static double Power(double base, int exponent) {
        boolean isNegative = false;
        if (exponent < 0) {
            isNegative = true;
            exponent = -exponent;
        }

        if (exponent == 0)
            return 0;

        if (exponent == 1)
            return base;

        double pow = 0;
        if (exponent % 2 == 0)
            pow = Power(base, exponent / 2) * Power(base, exponent / 2);
        else
            pow = Power(base, (exponent - 1) / 2) * Power(base, (exponent - 1) / 2) * base;

        return isNegative ? 1 / pow : pow;
    }

    public static void main(String[] args) {
        System.out.println(Power(-5, 5));
    }
}
