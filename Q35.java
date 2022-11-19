class TreeNode35 {
    int val;
    TreeNode35 left;
    TreeNode35 right;

    TreeNode35() {
    }

    TreeNode35(int val) {
        this.val = val;
    }

    TreeNode35(int val, TreeNode35 left, TreeNode35 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution35 {
    private int height(TreeNode35 root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if (lh == -1 || rh == -1) {
            return -1;
        }
        if (Math.abs(lh - rh) <= 1) {
            return 1 + Math.max(lh, rh);
        }
        return -1;
    }

    public boolean isBalanced(TreeNode35 root) {
        return height(root) != -1;
    }
}

public class Q35 {
    public static void main(String[] args) {
        Solution35 solution = new Solution35();
        TreeNode35 root = new TreeNode35(
                3,
                new TreeNode35(9),
                new TreeNode35(
                        20,
                        new TreeNode35(15),
                        new TreeNode35(7)
                )
        );
        boolean isBalanced = solution.isBalanced(root);
        System.out.println("isBalanced: " + isBalanced);
    }
}
