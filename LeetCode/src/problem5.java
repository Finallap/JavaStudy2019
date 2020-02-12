public class problem5 {
    //暴力法
    public static String longestPalindrome(String s) {
        String result = "";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String testString = s.substring(i, j);
                if (isPalindrome(testString) && testString.length() > max) {
                    result = testString;
                    max = testString.length();
                }
            }
        }
        return result;
    }

    public static Boolean isPalindrome(String s) {
        boolean result = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome1("babad"));
    }

    //时间复杂度：两层循环 O(n²)。
    //空间复杂度：一个二维数组 O(n²)。
    public static String longestPalindrome1(String s) {
        if (s == null || s.equals("")) return "";
        int length = s.length();
        int maxLen = 0;
        int maxEnd = 0;
        String reverse = new StringBuffer(s).reverse().toString();
        int[][] arr = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (s.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0)
                        arr[i][j] = 1;
                    else
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                }
                if (arr[i][j] > maxLen) {
                    int beforeRev = length - 1 - j;

                    if (beforeRev + arr[i][j] - 1 == i) {
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                }
            }
        }

        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    //时间复杂度：两层循环 O(n²)。
    //空间复杂度：一个二维数组 O(n)。
    public String longestPalindrome2(String s) {
        if (s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[] arr = new int[length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++)
        /**************修改的地方***************************/
            for (int j = length - 1; j >= 0; j--) {
                /**************************************************/
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[j] = 1;
                    } else {
                        arr[j] = arr[j - 1] + 1;
                    }
                    /**************修改的地方***************************/
                    //之前二维数组，每次用的是不同的列，所以不用置 0 。
                } else {
                    arr[j] = 0;
                }
                /**************************************************/
                if (arr[j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[j] - 1 == i) {
                        maxLen = arr[j];
                        maxEnd = i;
                    }

                }
            }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }
}
