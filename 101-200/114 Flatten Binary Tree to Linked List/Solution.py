class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root is not None:
            if root.left is not None:
                self.flatten(root.left)

            if root.right is not None:
                self.flatten(root.right)

            tmp = root.right
            root.right = root.left
            root.left = None
            while root.right is not None:
                root = root.right

            root.right = tmp
            
class Solution:
    def __init__(self):
        self.prev = None

    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        self.flatten(root.right)
        self.flatten(root.left)
        root.right = self.prev
        root.left = None
        self.prev = root
