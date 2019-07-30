/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

这道题跟I的区别就是binary tree不是完全二叉树。
所以root.right.next就不一定等于root.next.left。
所以，目标就是先确定好root的右孩子的第一个有效next连接点，然后再处理左孩子。

class Solution {
    public Node connect(Node root) {
        if (root != null) {
            Node p = root.next;

            while (p != null) {
                if (p.left != null) {
                    p = p.left;
                    break;
                }

                if (p.right != null) {
                    p = p.right;
                    break;
                }
                p = p.next;
            }

            if (root.right != null) {
                root.right.next = p;
            }

            if (root.left != null) {
                if (root.right != null) {
                    root.left.next = root.right;
                } else {
                    root.left.next = p;
                }
            }

            connect(root.right);
            connect(root.left);
        }
        return root;
    }
}
