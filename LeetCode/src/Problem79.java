/**
 * @description: LeetCode Problem79: 单词搜索,二维平面上使用dfs
 * @date: 2020/5/1 19:59
 * @author: Finallap
 * @version: 1.0
 */
public class Problem79 {
    private char[][] board;
    private String word;
    private int xLen;
    private int yLen;
    private int[][] direct = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.xLen = board.length;
        if (xLen == 0) return false;
        this.yLen = board[0].length;
        if (yLen == 0) return false;
        boolean[][] isVisited = new boolean[xLen][yLen];

        for (int x = 0; x < xLen; x++) {
            for (int y = 0; y < yLen; y++) {
                if (dfs(isVisited, x, y, 0))
                    return true;
            }
        }
        return dfs(isVisited, 0, 0, 0);
    }

    private boolean dfs(boolean[][] isVisited, int x, int y, int targetIndex) {
        if (targetIndex == word.length() - 1)
            return board[x][y] == word.charAt(targetIndex);
        if (board[x][y] == word.charAt(targetIndex)) {
            isVisited[x][y] = true;
            if (inArea(x, y)) {
                for (int k = 0; k < 4; k++) {
                    int newX = x + direct[k][0];
                    int newY = y + direct[k][1];
                    if (inArea(newX, newY) && !isVisited[newX][newY] &&
                            dfs(isVisited, newX, newY, targetIndex + 1)) {
                        return true;
                    }
                }
            }
            isVisited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < xLen && y >= 0 && y < yLen;
    }
}
