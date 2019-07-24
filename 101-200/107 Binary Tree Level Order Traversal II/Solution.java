class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        helper(result, root, 0);
        return result;
    }

    private void helper(LinkedList<List<Integer>> result, TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level >= result.size()) {
            result.addFirst(new ArrayList<>());
        }

        result.get(result.size() - 1 - level).add(root.val);

        helper(result, root.left, level + 1);
        helper(result, root.right, level + 1);
    }
}
