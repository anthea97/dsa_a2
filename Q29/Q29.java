/* Topic: Tree
Given the root of a binary tree, return the lowest common ancestor of its deepest leaves.
Recall that:
The node of a binary tree is a leaf if and only if it has no children
The depth of the root of the tree is 0. if the depth of a node is d, the depth of each of its children is d + 1.
The lowest common ancestor of a set S of nodes, is the node A with the largest depth such that every node in S is in the subtree with root A.
 */

class TreeNode29 {
    int val;
    TreeNode29 left;
    TreeNode29 right;

    TreeNode29() {
    }

    TreeNode29(int val) {
        this.val = val;
    }

    TreeNode29(int val, TreeNode29 left, TreeNode29 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution29 {
    private int height(TreeNode29 root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private TreeNode29 traverse(TreeNode29 root, int height, int maxHeight) {
        if (height == maxHeight) {
            return root;
        }

        if (root.left != null && root.right != null) {
            TreeNode29 left = traverse(root.left, height + 1, maxHeight);
            TreeNode29 right = traverse(root.right, height + 1, maxHeight);
            if (left != null && right != null) {
                return root;
            } else {
                return left != null ? left : right;
            }
        } else if (root.left != null) {
            return traverse(root.left, height + 1, maxHeight);
        } else if (root.right != null) {
            return traverse(root.right, height + 1, maxHeight);
        } else {
            return null;
        }
    }

    public TreeNode29 lcaDeepestLeaves(TreeNode29 root) {
        int height = height(root);
        return traverse(root, 1, height);
    }
}

public class Q29 {
    public static void main(String[] args) {
        Solution29 solution = new Solution29();
        TreeNode29 root = new TreeNode29(
                3,
                new TreeNode29(
                        5,
                        new TreeNode29(6),
                        new TreeNode29(
                                2,
                                new TreeNode29(7),
                                new TreeNode29(4)
                        )
                ),
                new TreeNode29(
                        1,
                        new TreeNode29(0),
                        new TreeNode29(8)
                )
        );
        TreeNode29 ans = solution.lcaDeepestLeaves(root);
        System.out.println("Lowest Common Ancestor of Deepest Leaves has node value: " + ans.val);
    }
}
