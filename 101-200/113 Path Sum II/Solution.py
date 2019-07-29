class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        result = []
        self.helper(root, sum, result, [])
        return result

    def helper(self, root: TreeNode, sum: int, result: list, temp: list):
        if root is None:
            return

        temp.append(root.val)

        if root.val == sum and root.left is None and root.right is None:
            result.append(temp.copy())

        if root.left:
            self.helper(root.left, sum - root.val, result, temp)
        if root.right:
            self.helper(root.right, sum - root.val, result, temp)
        temp.pop()
