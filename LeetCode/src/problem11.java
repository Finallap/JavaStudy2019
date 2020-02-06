public class problem11 {
    public int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                if (area > result)
                    result = area;
            }
        }
        return result;
    }

    public int maxArea1(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            maxArea = Math.max(Math.min(height[i], height[j]) * (j - i), maxArea);
            if (height[i] < height[j])
                i++;
            else
                j--;
        }

        return maxArea;
    }
}
