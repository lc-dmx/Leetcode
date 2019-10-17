class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // floor()方法返set中小于等于给定元素的最大元素；如果不存在这样的元素，则返回 null
        // ceiling()方法返回set中大于等于给定元素的最小元素；如果不存在这样的元素，则返回 null
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if ((set.floor(temp) != null && temp <= t + set.floor(temp)) ||
                    (set.ceiling(temp) != null && set.ceiling(temp) <= t + temp )) {
                return true;
            }
            set.add(temp);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
