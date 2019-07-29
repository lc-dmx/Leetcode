class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, sum, result, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> temp) {
        if (root == null) return;

        temp.add(root.val);

        if (root.val == sum && root.left == null && root. right == null) {
            result.add(new ArrayList<>(temp));
        }

        helper(root.left, sum - root.val, result, temp);
        helper(root.right, sum - root.val, result, temp);
        temp.remove(temp.size() - 1);
    }
}
