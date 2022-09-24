public class MaxPathSum {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static int ans;

    static int calPathSum(TreeNode root) {
        if (root == null)
            return 0;

        int leftSum = calPathSum(root.left);
        int rightSum = calPathSum(root.right);

        if (root.left == null && root.right == null)
            return root.data;

        if (root.left == null)
            return root.data + rightSum;

        if (root.right == null)
            return root.data + leftSum;

        ans = Math.max(ans, leftSum + rightSum + root.data);
        return Math.max(root.data + leftSum, root.data + rightSum);
    }

    static int maxSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        int max = calPathSum(root);
        if (root.left == null || root.right == null)
            return Math.max(ans, max);
        return ans;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//
//        root.right = new TreeNode(6);
//
//        root.right.left = new TreeNode(-5);
//        root.right.right = new TreeNode(5);

        TreeNode root = new TreeNode(-9);
        root.left = new TreeNode(6);
        root.right = new TreeNode(-10);

        System.out.println(maxSum(root));
    }
}
