"""
# Definition for a Node.
class Node:
    def __init__(self, val, left, right, next):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root is not None:
            p = root.next
            while p is not None:
                if p.left is not None:
                    p = p.left
                    break
                if p.right is not None:
                    p = p.right
                    break
                p = p.next

            if root.right is not None:
                root.right.next = p

            if root.left is not None:
                if root.right is not None:
                    root.left.next = root.right
                else:
                    root.left.next = p

            self.connect(root.right)
            self.connect(root.left)
        return root
