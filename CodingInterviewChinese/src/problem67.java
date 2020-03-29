/**
 * @description: 剑指 problem67: 把字符串转换成整数
 * 1、考虑空字符串问题
 * 2、考虑正负号问题
 * 3、考虑输入非数字和正负号的问题
 * 4、处理溢出情况（这里先用long存了，再转成Int）
 * @date: 2020/3/29 10:33
 * @author: Finallap
 * @version: 1.0
 */
public class problem67 {
    public int StrToInt(String str) throws Exception {
        if (str.length() == 0) {
//                throw new Exception("Input Error!");
            return 0;
        }

        boolean isNegative = str.charAt(0) == '-';
        long result = 0;

        int index = (str.charAt(0) == '+' || isNegative) ? 1 : 0;
        while (index < str.length()) {
            char ch = str.charAt(index);
            if (ch < '0' || ch > '9') {
                return 0;
//                throw new Exception("Input Error!");
            }

            result = result * 10 + (ch - '0');

            // 溢出判断
            if ((!isNegative && result > Integer.MAX_VALUE) || (isNegative && -result < Integer.MIN_VALUE)) {
//                throw new Exception("Overflow Error!");
                return 0;
            }

            index++;
        }
        return (int) (isNegative ? -result : result);
    }
}
