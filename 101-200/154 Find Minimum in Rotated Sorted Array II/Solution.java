当数组中存在大量的重复数字时，就会破坏二分查找法的机制，将无法取得 O(lgn) 的时间复杂度，又将会回到简单粗暴的 O(n)，比如如下两种情况：
{2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2} 和 {2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2}， 
我们发现，当第一个数字和最后一个数字，还有中间那个数字全部相等的时候，二分查找法就崩溃了，因为它无法判断到底该去左半边还是右半边。

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left != right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
            //left++不管用;比如10,1,10,10,10
                right--;
            }
        }
        return nums[left];
    }
}
