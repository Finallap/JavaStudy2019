public class problem5 {
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
        System.out.println(longestPalindrome("a"));
    }
}
