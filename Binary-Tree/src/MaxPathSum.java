public class MaxPathSum {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static int ans  = Integer.MIN_VALUE;

    static int calPathSum(TreeNode root) {
        if (root == null)
            return 0;

        int leftSum = calPathSum(root.left);
        int rightSum = calPathSum(root.right);

        int sum = leftSum + rightSum + root.val;
        int maxSum = Math.max(leftSum + root.val, rightSum + root.val);

        ans = Math.max(ans, Math.max(sum, maxSum));

        return maxSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(4);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(-10);
        root.left.right = new TreeNode(4);

        System.out.println(calPathSum(root));
    }
}
