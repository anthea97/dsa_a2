class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution23 {
    private int depth;

    private void calculateDepth(TreeNode root, int d) {
        if (root == null) {
            return;
        }
        if (d > depth) {
            depth = d;
        }
        calculateDepth(root.left, d + 1);
        calculateDepth(root.right, d + 1);
    }

    public int maxDepth(TreeNode root) {
        depth = 0;
        calculateDepth(root, 1);
        return depth;
    }
}

public class Q23 {
    public static void main(String[] args) {
        Solution23 solution = new Solution23();
        TreeNode root = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );
        int depth = solution.maxDepth(root);
        System.out.println("Max depth: " + depth);
    }
}
