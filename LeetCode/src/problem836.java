/**
 * @description: LeetCode problem836:矩形重叠
 * @date: 2020/3/18 12:44
 * @author: Finallap
 * @version: 1.0
 */
public class problem836 {
    //方法一：判断矩阵2完全在矩阵1的左侧、右侧、下侧或者上侧
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec2[2] > rec1[0] &&
                rec2[0] < rec1[2] &&
                rec2[3] > rec1[1] &&
                rec2[1] < rec1[3];
    }

    //方法二：判断在X轴或者Y轴上的投影是否有重合区域，重合时，两条线段起点的最大值会小于终点的最小值
    public boolean isRectangleOverlap1(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }
}
