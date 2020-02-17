public class problem13 {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold <= 0 || rows <= 0 || cols <= 0)
            return 0;

        boolean[][] marked = new boolean[rows][cols];
        return tranceBank(threshold, rows, cols, 0, 0, marked);
    }

    public int tranceBank(int threshold, int rows, int cols, int r, int c, boolean[][] marked) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c])
            return 0;

        marked[r][c] = true;

        int count = 0;
        if (digitalSum(r) + digitalSum(c) <= threshold && marked[r][c]) {
            count = 1 + tranceBank(threshold, rows, cols, r + 1, c, marked) +
                    tranceBank(threshold, rows, cols, r - 1, c, marked) +
                    tranceBank(threshold, rows, cols, r, c + 1, marked) +
                    tranceBank(threshold, rows, cols, r, c - 1, marked);
        }

        return count;
    }

    public int digitalSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
