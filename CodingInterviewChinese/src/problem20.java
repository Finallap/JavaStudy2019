//正则表达式判断是不是数字
public class problem20 {
    public static boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;

        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    public static void main(String[] args) {
        System.out.println(isNumeric("-125e36".toCharArray()));
    }
}
