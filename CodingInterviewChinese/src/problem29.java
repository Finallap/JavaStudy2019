import java.util.ArrayList;

//顺时针打印矩阵（边界条件很重要！！！）
public class problem29 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return null;

        ArrayList<Integer> results = new ArrayList<>();
        int rowStart = 0;
        int columnStart = 0;
        int rowEnd = matrix.length - 1;
        int columnEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && columnStart <= columnEnd) {
            for (int i = columnStart; i <= columnEnd; i++)
                results.add(matrix[rowStart][i]);
            for (int i = rowStart + 1; i <= rowEnd; i++)
                results.add(matrix[i][columnEnd]);
            if (rowStart != rowEnd)
                for (int i = columnEnd - 1; i >= columnStart; i--)
                    results.add(matrix[rowEnd][i]);
            if (columnStart != columnEnd)
                for (int i = rowEnd - 1; i > rowStart; i--)
                    results.add(matrix[i][columnStart]);
            rowStart++;
            columnStart++;
            rowEnd--;
            columnEnd--;
        }
        return results;
    }
}
