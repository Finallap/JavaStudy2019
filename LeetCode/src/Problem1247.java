/**
 * @description: LeetCode Problem1247: 交换字符使得字符串相同，贪心法统计次数解决
 * @date: 2020/4/24 18:21
 * @author: Finallap
 * @version: 1.0
 */
public class Problem1247 {
    public int minimumSwap(String s1, String s2) {
        int len = s1.length();
        int xy = 0, yx = 0;
        //统计xy和yx的出现次数
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            } else if (s1.charAt(i) == 'x') {
                xy++;
            } else {
                yx++;
            }
        }
        //判断xy和yx的出现次数是不是偶数，如果是的话可以各自直接交换
        boolean restxy = (xy & 1) == 1;
        boolean restyx = (yx & 1) == 1;
        //判断不同的字符数是不是奇数，如果是奇数，则说明无法成功交换至相同
        if ((xy + yx) % 2 == 1) return -1;

        //如果有一组多余的不同，则多余的需要交换两次
        return xy / 2 + yx / 2 + (restxy ? 2 : 0);
    }
}
