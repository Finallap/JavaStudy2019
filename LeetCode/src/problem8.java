public class problem8 {
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;

        int result = 0;
        boolean isStart = false;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            //判断字符开始
            if (str.charAt(i) != ' ' && !isStart) {
                //判断开始是不是数组
                if ((str.charAt(i) < '0' || str.charAt(i) > '9') && str.charAt(i) != '-' && str.charAt(i) != '+')
                    return 0;
                else {
                    startIndex = i;
                    endIndex = str.length();
                    isStart = true;
                }
            }

            //判断结尾位置
            if (isStart && i > startIndex) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    endIndex = i;
                    break;
                }
            }
        }

        if (startIndex != endIndex) {
            if (str.substring(startIndex, endIndex).equals("-") || str.substring(startIndex, endIndex).equals("+"))
                return 0;

            try {
                result = Integer.parseInt(str.substring(startIndex, endIndex));
            } catch (Exception e) {
                result = str.charAt(startIndex) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-"));
    }
}
