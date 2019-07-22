# Solution 1
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    private void helper(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) return;

        if (result.size() <= level) {
            result.add(new LinkedList<>());
        }

        if (level % 2 != 0) {
            ((LinkedList<Integer>)result.get(level)).addFirst(root.val);
        } else {
            result.get(level).add(root.val);
        }

        helper(root.left, result, level + 1);
        helper(root.right, result, level + 1);
    }
}

# Solution 2
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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

            if (result.size() % 2 != 0) {
                Collections.reverse(temp);
            }
            result.add(temp);
        }

        return result;
    }
}

# Solution 3
class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return ret;
        sol(root, 0, 0);
        sol(root, 0, 1);
        return ret;
    }
    
    void sol(TreeNode cur, int level, int dir) {
        if (cur == null) return;
        if (level >= ret.size()) ret.add(new ArrayList<>());
        if (level % 2 == dir) ret.get(level).add(cur.val);
        if (dir == 0) {
            sol(cur.left, level + 1, dir);
            sol(cur.right, level + 1, dir);
        } else {
            sol(cur.right, level + 1, dir);
            sol(cur.left, level + 1, dir);
        }
    }
}
