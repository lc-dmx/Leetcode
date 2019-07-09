class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mi = m - 1, ni = n - 1, i = m + n - 1;
        while (i >= 0 && ni >= 0) {
            if (mi < 0) {
                nums1[i] = nums2[ni];
                ni--;
            } else {
                if (nums1[mi] > nums2[ni]) {
                    nums1[i] = nums1[mi];
                    mi--;
                } else {
                    nums1[i] = nums2[ni];
                    ni--;
                }
            }
            i--;
        }
    }
}
