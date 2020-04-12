package Alibaba_Dingding_20200302;

/**
 * @description: Alibaba1
 * @date: 2020/3/2 20:55
 * @author: Finallap
 * @version: 1.0
 */
// 题目一：
// 现有x瓶啤酒，每3个空瓶子换一瓶啤酒，每7个瓶盖子也可以换一瓶啤酒，问最后可以喝多少瓶啤酒?
// 实现该方法。入参：x为开始的啤酒数；返回：最后可以喝的啤酒瓶数
public class Alibaba1 {
    public static int bears(int x) {
        int result = x;
        int pingzi = x;
        int pinggai = x;
        int canChange = 0;
        while (pingzi / 3 != 0 || pinggai / 7 != 0) {
            //换瓶子
            if (pingzi / 3 != 0) {
                canChange = pingzi / 3;//计算能换多少啤酒
                result += canChange;//累加啤酒
                pinggai += canChange;//喝完把瓶盖加上
                pingzi = pingzi % 3 + canChange;//重新计算瓶子数量
            }
            //换瓶盖
            if (pinggai / 7 != 0) {
                canChange = pinggai / 7;//计算能换多少啤酒
                result += canChange;//累加啤酒
                pingzi += canChange;//喝完把瓶子加上
                pinggai = pinggai % 7 + canChange;//重新计算瓶盖数量
            }
        }
        return result;
    }
}
