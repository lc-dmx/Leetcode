# Solution 1
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int[] nums, int pos){
        result.add(new ArrayList<>(temp));
        for (int i = pos; i < nums.length; i++) {
            temp.add(nums[i]);//① 加入 nums[i]
            dfs(result, temp, nums, i + 1);//② 递归
            temp.remove(temp.size() - 1);//③ 移除 nums[i]
        }
    }
}

# Solution 2
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int num : nums) {  // ①从数组中取出每个元素
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(res.get(i));  // ②逐一取出中间结果集
                temp.add(num);  // ③将 num 放入中间结果集
                res.add(temp);  // ④加入到结果集中
            }
        }
        return res;
    }
}

# Solution 3
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            dfs(result, new ArrayList<>(), nums, i, 0);
        }
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> tempList, int[] nums, int k, int pos) {
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        if (pos >= nums.length) {
            return;
        }

        tempList.add(nums[pos]);
        dfs(result, tempList, nums, k, pos + 1);
        tempList.remove(tempList.size() - 1);
        dfs(result, tempList, nums, k, pos + 1);
    }
}
