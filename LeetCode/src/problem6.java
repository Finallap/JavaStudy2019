import java.util.ArrayList;
import java.util.List;

public class problem6 {
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int currentRow = 0;
        boolean goingDown = false;

        for (char ch : s.toCharArray()) {
            rows.get(currentRow).append(ch);
            if (currentRow == 0 || currentRow == numRows - 1) goingDown = !goingDown;
            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows)
            result.append(row);
        return result.toString();
    }

    public static String convert1(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder result = new StringBuilder();
        int step = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < s.length(); j += step) {
                result.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + step - i < s.length())
                    result.append(s.charAt(j + step - i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 4;
        System.out.println(convert1(s, numRows));
    }
}
