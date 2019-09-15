# Solution 1
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

            int j = mid + 1;
            for (int i = left; i <= mid; i++) {
                while (j <= right && nums[i] > 2L * nums[j]) {
                    j++;
                }
                count += j - (mid + 1);
            }

            merge(nums, left, mid, right);
            return count;
        } else {
            return 0;
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; i++)
            L[i] = nums[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = nums[mid + 1 + j];


        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        for (int k = left; k <= right; k++) {
            if (j >= n2 || (i < n1 && L[i] <= R[j])) {
                nums[k] = L[i++];
            } else {
                nums[k] = R[j++];
            }
        }
    }
}

//Solution 2
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

            int j = mid + 1;
            for (int i = left; i <= mid; i++) {
                while (j <= right && nums[i] > 2L * nums[j]) {
                    j++;
                }
                count += j - (mid + 1);
            }

            merge(nums, left, mid, right);
            return count;
        } else {
            return 0;
        }
    }

    
    private void merge(int[] nums, int left, int mid, int right) {
        int temp[] = new int[right - left + 1];
        int ls = left, rs = mid + 1;
        int k = 0;
        while (ls <= mid && rs <= right) {
            if (nums[ls] <= nums[rs]) {
                temp[k++] = nums[ls++];
            } else {
                temp[k++] = nums[rs++];
            }
        }

        while (ls <= mid) {
            temp[k++] = nums[ls++];
        }

        while (rs <= right) {
            temp[k++] = nums[rs++];
        }

        k = 0;
        for (int i = left; i <= right; i++) {
            nums[i] = temp[k++];
        }
    }
}
