# Solution 1
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                temp.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }

                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(temp);
        }

        return result;
    }
}

# Solution 2
Class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        int maxLevel = 0;
        while (true) {
            List<Integer> temp = new ArrayList<>();
            dfs(root, temp, 0, maxLevel);
            if (temp.size() == 0) {
                break;
            }
            result.add(temp);
            maxLevel++;
        }

        return result;
    }

    private void dfs(TreeNode root, List<Integer> temp, int currLevel, int maxLevel) {
        if (root == null || currLevel > maxLevel) {
            return;
        }

        if (currLevel == maxLevel) {
            temp.add(root.val);
            return;
        }

        dfs(root.left, temp, currLevel + 1, maxLevel);
        dfs(root.right, temp, currLevel + 1, maxLevel);
    }
}
