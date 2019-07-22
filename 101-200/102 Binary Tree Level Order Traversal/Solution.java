# Solution 1
DFS的过程可以总结为：

1) 将当前层节点的值加入到对应的数组中

2) 先递归处理左子树，再处理右子树

由于我们实现并不知道整个子树的层数，所以我们还需要根据当前的层数去动态增加我们答案的数组数量。

当然这一步的实现也很简单，只要比较一下当前层数和答案数组数量之间的关系就可以。

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    private void helper(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) return;

        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);

        helper(root.left, result, level + 1);
        helper(root.right, result, level + 1);
    }
}

# Solution 2
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

# Solution 3
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
