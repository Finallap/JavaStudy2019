package AntFinancial_20200316;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @description: problem1
 * 有char a[n],char b[m]两个数组，n > m > 1000
 * b数组中的元素a中都有，现在需要生成数组c， 将a中有b中没有的元素都放到c里面，要求高效
 * @date: 2020/3/16 20:39
 * @author: Finallap
 * @version: 1.0
 */
public class problem1 {
    void solution(char[] a, char[] b, List<Character> c) {
        HashSet<Character> aSet = new HashSet<>();
        HashSet<Character> bSet = new HashSet<>();
        for (char ach : a) {
            aSet.add(ach);
        }
        for (char bch : b) {
            aSet.add(bch);
        }
        aSet.removeAll(bSet);
        Iterator<Character> iter = aSet.iterator();
        while (iter.hasNext()) {
            c.add(iter.next());
        }
    }
}
