Approach 1: Two Pointers
Algorithm

Since the array is already sorted, we can keep two pointers i and j, where i is the slow-runner while j is the fast-runner. 
As long as nums[i] = nums[j], we increment j to skip the duplicate.

When we encounter nums[j] doesn't equal to nums[i], the duplicate run has ended so we must copy its value to nums[i + 1]. 
i is then incremented and we repeat the same process again until j reaches the end of array.
	
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        
        int len = nums.length;
        int j = 0;
        for(int i = 0; i < len; i++){
        	if(nums[i] != nums[j]){
        		j++;
        		nums[j] = nums[i];
        	}
        }
        
		return j + 1;
    }
}
