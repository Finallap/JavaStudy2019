import java.util.Stack;

/**
 * @description: LeetCode problem42: 接雨水，使用单调栈、DP、双指针解决
 * @date: 2020/4/7 13:18
 * @author: Finallap
 * @version: 1.0
 */
public class problem42 {
    //使用单调递减栈来解决,时间复杂度O(n)
    public int trap(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                ans += distance * boundedHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    //按列计算,时间复杂度O(n^2)
    public int trap1(int[] height) {
        int ans = 0;

        //第一列和最后一列肯定不能接，所以不计算
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0;
            for (int j = 0; j < i - 1; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            int rightMax = 0;
            for (int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            //找到两侧短板
            int min = Math.min(leftMax, rightMax);

            //短板比当前的点高的话可以接雨水
            if (min > height[i]) {
                ans += (min - height[i]);
            }
        }
        return ans;
    }

    //dp来解，还是计算每列能接多少，只不过最左端和最右端的最高高端先用数组储存了，时间复杂度O(n)
    public int trap2(int[] height) {
        int ans = 0;

        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }

        for (int i = height.length - 2; i > 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i])
                ans += (min - height[i]);
        }

        return ans;
    }

    //双指针方法，原理类似上面两种，只不过比较了左右两个指针的数值大小，优化了空间复杂度
    public int trap3(int[] height) {
        int ans = 0;
        int left = 1;
        int right = height.length - 2;
        int maxLeft = 0;
        int maxRight = 0;

        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                maxLeft = Math.max(maxLeft, height[left - 1]);
                int min = maxLeft;
                if (min > height[left]) {
                    ans = ans + (min - height[left]);
                }
                left++;
                //从右到左更
            } else {
                maxRight = Math.max(maxRight, height[right + 1]);
                int min = maxRight;
                if (min > height[right]) {
                    ans = ans + (min - height[right]);
                }
                right--;
            }
        }
        return ans;
    }
}
