public class problem4 {
    boolean Find(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int len1 = matrix.length;
        int len2 = matrix[0].length;

        int row = 0, column = len2 - 1;
        while (row < len1 && column >= 0) {
            if (matrix[row][column] == target)
                return true;
            else if (matrix[row][column] < target)
                row++;
            else
                column--;
        }
        return false;
    }
}
