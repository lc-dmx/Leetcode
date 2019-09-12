# Solution 1
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(0, nums.length - 1, nums, k);
    }

    private int quickSort(int begin, int end, int[] array, int k) {
        if (begin < end) {
            int partition = partition(begin, end, array);

            if (end - partition == k - 1) {
                return array[partition];
            } else if (end - partition < k - 1) {
                return quickSort(begin, partition - 1, array, k - (end - partition + 1));
            } else {
                return quickSort(partition + 1, end, array, k);
            }
        }
        return array[begin];
    }

    private int partition(int begin, int end, int[] array) {
        int pivot = array[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, end);
        return i + 1;
    }
    
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

# Solution 2
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(0, nums.length - 1, nums, nums.length - k + 1);
    }

    private int quickSort(int begin, int end, int[] array, int k) {
        int pivot = array[end];
        int left = begin;
        int right = end;

        while (true) {
            while (left < right && array[left] < pivot) {
                left++;
            }

            while (left < right && array[right] >= pivot) {
                right--;
            }

            if (left == right) {
                break;
            }

            swap(array, left, right);
        }

        swap(array, left, end);

        if (k == left + 1) {
            return pivot;
        } else if (k < left + 1) {
            return quickSort(begin, left - 1, array, k);
        } else {
            return quickSort(left + 1, end, array, k);
        }
    }
}
