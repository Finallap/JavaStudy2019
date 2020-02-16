public class problem12 {
    private int rows;
    private int cols;

    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
        if (array == null || array.length == 0 || rows == 0 || cols == 0 || array.length != rows * cols)
            return false;

        char[][] matrix = new char[rows][cols];
        boolean[][] marked = new boolean[rows][cols];

        this.rows = rows;
        this.cols = cols;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = array[r * cols + c];
            }
        }

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                if (tranceBack(matrix, str, marked, 0, r, c))
                    return true;

        return false;
    }

    public boolean tranceBack(char[][] matrix, char[] str, boolean[][] marked, int pathLength, int r, int c) {
        if (pathLength == str.length) return true;
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] != str[pathLength] || marked[r][c])
            return false;

        marked[r][c] = true;

        boolean hasPath = tranceBack(matrix, str, marked, pathLength + 1, r + 1, c) ||
                tranceBack(matrix, str, marked, pathLength + 1, r - 1, c) ||
                tranceBack(matrix, str, marked, pathLength + 1, r, c + 1) ||
                tranceBack(matrix, str, marked, pathLength + 1, r, c - 1);

        if (hasPath) return true;

        marked[r][c] = false;
        return false;
    }
}
