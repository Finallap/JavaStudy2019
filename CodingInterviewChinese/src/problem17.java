public class problem17 {
    public static void print1ToMaxOfNDigits(int n) {
        if (n <= 0) return;

        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    public static void print1ToMaxOfNDigits(char[] number, int index) {
        if (index == number.length) {
            printNumber(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index] = (char) (i + '0');
            print1ToMaxOfNDigits(number, index + 1);
        }
    }

    public static void printNumber(char[] number) {
        boolean isStart = false;
        for (char c : number) {
            if (c != '0') isStart = true;
            if (isStart) System.out.print(c);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print1ToMaxOfNDigits(4);
    }
}
