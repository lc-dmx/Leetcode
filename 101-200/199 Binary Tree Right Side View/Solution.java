/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();
        levelOrder(root, 0, list);

        for (List<Integer> l : list) {
            result.add(l.get(l.size() - 1));
        }

        return result;
    }

    private void levelOrder(TreeNode root, int level, List<List<Integer>> list) {
        if (root == null) {
            return;
        }

        if (list.size() <= level) {
            list.add(new ArrayList<>());
        }

        list.get(level).add(root.val);
        levelOrder(root.left, level + 1, list);
        levelOrder(root.right, level + 1, list);
    }
}
