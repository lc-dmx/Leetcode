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
