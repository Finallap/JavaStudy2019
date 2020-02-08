public class problem4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {//时间复杂度O(n+m)
        int len1 = nums1.length;
        int len2 = nums2.length;
        int num = (len1 + len2) / 2;
        int left = -1, right = -1;
        int indexA = 0, indexB = 0;
        for (int i = 0; i <= num; i++) {
            left = right;
            if (indexA < len1 && (indexB >= len2 || nums1[indexA] < nums2[indexB])) {
                right = nums1[indexA++];
            } else
                right = nums2[indexB++];
        }

        if (((len1 + len2) & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {//时间复杂度O(log(m+n))
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;

        return (getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left) + getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j])
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        else
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
    }
}
