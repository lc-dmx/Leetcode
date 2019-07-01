# Solution 1
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // if left sub array is sorted
            if (nums[lo] <= nums[mid]) {
                // if target is in the sorted left sub array
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            // if right sub array is sorted
            if (nums[mid] < nums[hi]) {
                // if target is present in sorted right sub array
                if(nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }

}

# Solution 2
class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        
        int pivot = findPivot(nums);
        if (nums[pivot] == target) {
            return pivot;
        }

        if (pivot == 0) {
            return searchTarget(nums, 0, length - 1, target);
        }

        if (nums[0] > target) {
            return searchTarget(nums, pivot, length - 1, target);
        } else {
            return searchTarget(nums, 0, pivot, target);
        }
    }

    private int findPivot(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums[left] < nums[right]) {
            return 0;
        }

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1]) {
                return pivot + 1;
            } else {
            // 这个等号很重要
                if (nums[pivot] >= nums[left]) {
                    left = pivot + 1;
                } else {
                    right = pivot - 1;
                }
            }
        }
        return 0;
    }

    private int searchTarget(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
