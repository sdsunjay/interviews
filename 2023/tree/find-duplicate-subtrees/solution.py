# https://leetcode.com/problems/find-duplicate-subtrees/
# https://leetcode.com/problems/find-duplicate-subtrees/submissions/906244440/
import collections

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


    def display(self):
        lines, *_ = self._display_aux()
        for line in lines:
            print(line)

    def _display_aux(self):
        """Returns list of strings, width, height, and horizontal coordinate of the root."""
        # No child.
        if self.right is None and self.left is None:
            line = '%s' % self.val
            width = len(line)
            height = 1
            middle = width // 2
            return [line], width, height, middle

        # Only left child.
        if self.right is None:
            lines, n, p, x = self.left._display_aux()
            s = '%s' % self.val
            u = len(s)
            first_line = (x + 1) * ' ' + (n - x - 1) * '_' + s
            second_line = x * ' ' + '/' + (n - x - 1 + u) * ' '
            shifted_lines = [line + u * ' ' for line in lines]
            return [first_line, second_line] + shifted_lines, n + u, p + 2, n + u // 2

        # Only right child.
        if self.left is None:
            lines, n, p, x = self.right._display_aux()
            s = '%s' % self.val
            u = len(s)
            first_line = s + x * '_' + (n - x) * ' '
            second_line = (u + x) * ' ' + '\\' + (n - x - 1) * ' '
            shifted_lines = [u * ' ' + line for line in lines]
            return [first_line, second_line] + shifted_lines, n + u, p + 2, u // 2

        # Two children.
        left, n, p, x = self.left._display_aux()
        right, m, q, y = self.right._display_aux()
        s = '%s' % self.val
        u = len(s)
        first_line = (x + 1) * ' ' + (n - x - 1) * '_' + s + y * '_' + (m - y) * ' '
        second_line = x * ' ' + '/' + (n - x - 1 + u + y) * ' ' + '\\' + (m - y - 1) * ' '
        if p < q:
            left += [n * ' '] * (q - p)
        elif q < p:
            right += [m * ' '] * (p - q)
        zipped_lines = zip(left, right)
        lines = [first_line, second_line] + [a + u * ' ' + b for a, b in zipped_lines]
        return lines, n + m + u, max(p, q) + 2, n + u // 2

def findDuplicateSubtrees(root: TreeNode) -> list[TreeNode]:
    # Define a function to traverse the binary tree and find duplicate subtrees
    def traverse(node):
        # If the node is empty, return -201
        if not node:
            return -201

        # Create a triplet consisting of the left subtree, the node value, and the right subtree
        triplet = (traverse(node.left), node.val, traverse(node.right))

        # If the triplet is not in the dictionary, add it to the dictionary and assign it an ID
        if triplet not in triplet_to_id:
            triplet_to_id[triplet] = len(triplet_to_id) + 1

        # Get the ID of the triplet from the dictionary
        id = triplet_to_id[triplet]

        # Increment the count of the ID in the counter dictionary
        cnt[id] += 1

        # If the count of the ID is 2, add the current node to the result list
        if cnt[id] == 2:
            res.append(node)

        # Return the ID of the triplet
        return id

    # Initialize an empty dictionary to store triplets and their corresponding IDs
    triplet_to_id = {}

    # Initialize a default dictionary to store the count of each ID
    # cnt = collections.Counter() can also be used
    cnt = collections.defaultdict(int)

    # Initialize an empty list to store the duplicate subtrees
    res = []

    # Call the traverse function to find the duplicate subtrees
    traverse(root)

    # Return the list of duplicate subtrees
    return res

roots = [TreeNode(1,TreeNode(2, TreeNode(4), None),TreeNode(3,TreeNode(2,
TreeNode(4)), TreeNode(4))), TreeNode(0, TreeNode(0, TreeNode(0)), TreeNode(0,
None, TreeNode(0,None,TreeNode(0)))), TreeNode(2, TreeNode(1, TreeNode(11)), TreeNode(11, TreeNode(1)))]
for root in roots:
    print("Tree: ")
    root.display()
    list_of_trees = findDuplicateSubtrees(root)
    print("Result: ")
    for output in list_of_trees:
        output.display()
    print("\n")
#printBinaryTree(root)
# root_node = listToTree(root)

#print_tree(root)
