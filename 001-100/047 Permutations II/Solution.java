class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        permutation(result, nums, 0);
        return result;
    }

    private void permutation(List<List<Integer>> result, int nums[], int start) {
        if (start == nums.length - 1) {
            ArrayList<Integer> array = new ArrayList<>();
            for (int i= 0; i < nums.length; i++) {
                array.add(nums[i]);
            }
            if (!result.contains(array)) {
                result.add(array);
            }
        }
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[start]) {
                swap(nums, i, start);
                permutation(result, nums, start + 1);
                swap(nums, i, start);
            }
        }
    }
    
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

public class Solution {
    
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if(len==0||nums==null)  return res;
        
        boolean[] used = new boolean[len];
        List<Integer> list = new ArrayList<Integer>();
        
        Arrays.sort(nums);
        dfs(nums, used, list, len);
        return res;
    }
    
    public void dfs(int[] nums, boolean[] used, List<Integer> list, int len) {
        if(list.size()==len) {
            res.add(new ArrayList<Integer>(list));
            return ;
        }
        for (int i=0; i<len; i++) {
            // 当前位置的数已经在List中了
            if(used[i]) continue;
            // 当前元素与其前一个元素值相同 且 前元素未被加到list中，跳过该元素
            if(i>0 && nums[i]==nums[i-1] && !used[i-1])   continue;
            // 深度优先搜索遍历
            used[i]=true;
            list.add(nums[i]);
            dfs(nums, used, list, len);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }
}
