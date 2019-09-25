public class problem59 {
    public static int lengthOfLastWord(String s) {
        int res = 0;
        String[] splitRes = s.split("\\s+");
        if (splitRes.length == 0) return 0;
        res = splitRes[splitRes.length - 1].length();
        return res;
    }

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord1(s));
    }

    public static int lengthOfLastWord1(String s) {
        s = s.trim();
        int end = s.length() - 1;
        if (end == 1) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}
