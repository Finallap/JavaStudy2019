public class problem10 {
    //        递归
    public static long method1(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return method1(n - 1) + method1(n - 2);
    }

    //    循环
    public static long method2(int n) {
        long fn = 0;
        long fn_1 = 1;
        long fn_0 = 0;

        if (n == 0)
            return fn_0;
        if (n == 1)
            return fn_1;

        for (int i = 2; i <= n; i++) {
            fn = fn_0 + fn_1;
            fn_0 = fn_1;
            fn_1 = fn;
        }

        return fn;
    }

    public static void main(String[] args) {
        System.out.println(method2(5500));
    }
}
