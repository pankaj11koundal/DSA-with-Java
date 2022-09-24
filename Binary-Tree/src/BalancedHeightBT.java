// Java program to check whether a binary tree is height balanced or not.

public class BalancedHeightBT {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static int calcHeight(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(calcHeight(root.left) ,calcHeight(root.right)) + 1;
    }

    static boolean checkBalancedBT(TreeNode root) {
        if (root == null)
            return true;

        if (! checkBalancedBT(root.left))
            return false;

        if (! checkBalancedBT(root.right))
            return false;

        int lh = calcHeight(root.left);
        int rh = calcHeight(root.right);

        return Math.abs(lh - rh) <= 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(checkBalancedBT(root));
    }
}
