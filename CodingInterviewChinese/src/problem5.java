//problem5：数组，替换空格
public class problem5 {
    //    使用StringBuffer解决问题
    public static String ReplaceBlank(String str) {
        if (str == null || str.length() == 0)
            return null;

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                stringBuffer.append("%20");
            else
                stringBuffer.append(str.charAt(i));
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(ReplaceBlank("I love you. "));
    }

//    使用双指针解决问题
//    public static String ReplaceBlank1(String str){
//        if(str == null ||str.length()==0)
//            return null;
//
//        StringBuffer stringBuffer = new StringBuffer();
//
//        int len = str.length();
//        int blankCount = 0;
//        for (int i = 0;i<len;i++){
//            if (str.charAt(i) == ' ')
//                stringBuffer.append("  ");
//        }
//    }
}
