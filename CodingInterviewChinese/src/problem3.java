public class problem3 {
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || nums.length == 0)
            return false;
        for (int num : nums) {
            if (num < 0 || num > length - 1)
                return false;
        }

        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, nums[i], i);
            }
        }

        return false;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public boolean duplicate2(int[] nums, int length, int[] duplication) {
        if (nums == null || nums.length == 0)
            return false;
        for (int num : nums) {
            if (num < 0 || num > length - 1)
                return false;
        }

        int start = 1;
        int end = length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(nums, length, start, middle);

            if (start == end) {
                if (count > 1) {
                    duplication[0] = nums[start];
                    return true;
                } else
                    break;
            }

            if (count > (middle - start + 1))
                end = middle;
            else
                start = middle + 1;
        }

        return false;
    }

    public int countRange(int[] nums, int length, int start, int end) {
        int count = 0;
        if (nums == null) return 0;

        for (int num : nums) {
            if (num >= start && num <= end)
                count++;
        }
        return count;
    }
}
