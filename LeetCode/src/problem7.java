public class problem7 {
    public static int reverse(int x) {
        try {
            if (x >= 0) {
                String numStr = (new StringBuilder(x + "")).reverse().toString();
                return Integer.parseInt(numStr);
            } else {
                String numStr = (new StringBuilder(-x + "")).reverse().toString();
                return -Integer.parseInt(numStr);
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public static int reverse1(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            result = result * 10 + pop;
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int input = 124545454;
        System.out.print(reverse1(input));
    }
}
