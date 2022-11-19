/* Topic: Tree
Given the root of a binary tree, the depth of each node is the shortest distance to the root.
Return the smallest subtree such that it contains all the deepest nodes in the original tree.
A node is called the deepest if it has the largest depth possible among any node in the entire tree.
The subtree of a node is a tree consisting of that node, plus the set of all descendants of that node.
 */

class TreeNode28 {
    int val;
    TreeNode28 left;
    TreeNode28 right;

    TreeNode28() {
    }

    TreeNode28(int val) {
        this.val = val;
    }

    TreeNode28(int val, TreeNode28 left, TreeNode28 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution28 {
    private int height(TreeNode28 root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private TreeNode28 traverse(TreeNode28 root, int height, int maxHeight) {
        if (height == maxHeight) {
            return root;
        }

        if (root.left != null && root.right != null) {
            TreeNode28 left = traverse(root.left, height + 1, maxHeight);
            TreeNode28 right = traverse(root.right, height + 1, maxHeight);
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

    public TreeNode28 subtreeWithAllDeepest(TreeNode28 root) {
        int height = height(root);
        return traverse(root, 1, height);
    }
}

public class Q28 {
    public static void main(String[] args) {
        Solution28 solution = new Solution28();
        TreeNode28 root = new TreeNode28(
                3,
                new TreeNode28(
                        5,
                        new TreeNode28(6),
                        new TreeNode28(
                                2,
                                new TreeNode28(7),
                                new TreeNode28(4)
                        )
                ),
                new TreeNode28(
                        1,
                        new TreeNode28(0),
                        new TreeNode28(8)
                )
        );
        TreeNode28 ans = solution.subtreeWithAllDeepest(root);
        System.out.println("Smallest Subtree with all the Deepest Nodes has node value: " + ans.val);
    }
}
