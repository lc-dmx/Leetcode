# Solution 1
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int[] nums, int pos){
        result.add(new ArrayList<>(temp));
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            dfs(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}

# Solution 2
首先将这些数组元素排序。这样相同的元素就肯定都挨在一起了。每次取一个位置的元素时就和它前面的元素去比较，如果这个元素和前面的元素不同，
说明是一个新的元素，按照前面的思路，需要从头开始去和每个元素合并生成新结果。否则说明它的前一个元素已经和之前的那些元素生成了一遍结果集，
它就不应该再去重新生成一遍了，而是应该从它前一个元素和之前所有结果开始归并的地方继续进行合并。要实现这一点，
需要用一个变量来记录每次前一个元素合并完之后所在的位置。然后在下一个循环开头的时候判断一下，如果nums[i]  != nums[i - 1]，
则将开始的部分begin = 0，否则就保持begin = 上次合并完所在的位置。

public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    res.add(new ArrayList<>());
    int begin = 0;
    for (int i = 0; i < nums.length; i++) {  // ①从数组中取出每个元素
        if (i >= 1 && nums[i] != nums[i - 1]) {
            begin = 0;
        }
        int size = res.size();

        for (int j = begin; j < size; j++) {
            List<Integer> temp = new ArrayList<>(res.get(j));  // ②逐一取出中间结果集
            temp.add(nums[i]);  // ③将 num 放入中间结果集
            res.add(temp);  // ④加入到结果集中
        }
        begin = size;
    }
    return res;
}
