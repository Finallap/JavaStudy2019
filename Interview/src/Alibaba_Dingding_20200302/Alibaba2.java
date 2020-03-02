package Alibaba_Dingding_20200302;

import java.util.HashMap;

/**
 * @description: Alibaba2
 * @date: 2020/3/2 20:56
 * @author: Finallap
 * @version: 1.0
 */

// 题目二：
// 为了能够将map结构保存到mysql，我们需要先将map转化为string类型，再保存到数据库。
// 请实现两个方法：一个为将key,value都是string类型的map转化为string；另一个为将被转化的string反转为key,value都是string类型的map
// 要求：string的标准自由定义，但不允许直接使用json的标准；
public class Alibaba2 {
    public String toString(HashMap<String, String> map) {
        StringBuffer result = new StringBuffer();
        for (String key : map.keySet()) {
            String value = map.get(key);
            result.append(key);
            result.append("%%%");
            result.append(value);
            result.append("|||");
        }

        return result.toString();
    }

    public HashMap<String, String> toMap(String input) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        String[] elements = input.split("|||");

        if (input.length() == 0 || elements.length == 0)
            return map;

        for (String element : elements) {
            String[] zujians = element.split("%%%");
            if (zujians.length != 2)
                throw new Exception("Input error!");

            map.put(zujians[0], zujians[1]);
        }

        return map;
    }
}
