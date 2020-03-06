package Tencent_20200306;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: splitString1:不用split分割字符串
 * @date: 2020/3/6 15:31
 * @author: Finallap
 * @version: 1.0
 */
public class Split1 {
    public static List<String> splitString1(String str, char split) {
        List<String> results = new ArrayList<>();
        if (str.length() == 0)
            return results;

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == split) {
                if (sb.length() != 0) {
                    results.add(sb.toString());
                }
                sb.delete(0, sb.length());
            } else {
                sb.append(str.charAt(i));
            }
        }
        if (sb.length() != 0) {
            results.add(sb.toString());
        }
        return results;
    }

    public static void main(String[] args) {
        List<String> results = splitString1("dd|||ds|fd|ds||gdd|||sd|", '|');
        for (String str : results) {
            System.out.println(str);
        }
    }
}
