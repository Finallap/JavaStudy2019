package Tencent_20200306;

/**
 * @description: splitString:分割字符
 * @date: 2020/3/6 15:18
 * @author: Finallap
 * @version: 1.0
 */
public class Split {
    public static char[] splitString(String str, char split) {
        if (str.length() == 0) {
            return new char[0];
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != split) {
                count++;
            }
        }

        char[] results = new char[count];
        int resultsIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != split) {
                results[resultsIndex] = str.charAt(i);
                resultsIndex++;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        char[] chars = splitString("dd||ds", '|');
        for (char ch : chars) {
            System.out.println(ch);
        }
    }
}
