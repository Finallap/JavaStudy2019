public class problem14 {
    //竖向扫描法
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        StringBuffer stringBuffer = new StringBuffer();
//        int max_common_len = Integer.MAX_VALUE;
//
//        for (int i =0;i<strs.length;i++){
//            if (strs[i].length() < max_common_len)
//                max_common_len = strs[i].length();
//        }

        for (int common_len = 0; common_len < strs[0].length(); common_len++) {
            char c = strs[0].charAt(common_len);
            for (int i = 1; i < strs.length; i++) {
                if (common_len == strs[i].length() || strs[i].charAt(common_len) != c)
                    return stringBuffer.toString();
            }

            stringBuffer.append(c);
        }

        return stringBuffer.toString();
    }

    //分治法
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    public String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) return strs[start];
        else {
            int mid = (end + start) / 2;
            String leftCommonPrefix = longestCommonPrefix(strs, start, mid);
            String rightCommonPrefix = longestCommonPrefix(strs, mid + 1, end);

            return comparePrefix(leftCommonPrefix, rightCommonPrefix);
        }
    }

    public String comparePrefix(String leftString, String rightString) {
        int min = Math.min(leftString.length(), rightString.length());

        for (int i = 0; i < min; i++) {
            if (leftString.charAt(i) != rightString.charAt(i))
                return leftString.substring(0, i);
        }
        return leftString.substring(0, min);
    }

}
