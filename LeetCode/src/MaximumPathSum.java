public class MaximumPathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static class Sum {
        int sum;

        Sum() {
            sum = Integer.MIN_VALUE;
        }
    }

    static int maxSum(TreeNode root, Sum ans) {
        if (root == null)
            return 0;

        int left = maxSum(root.left, ans);
        int right = maxSum(root.right, ans);

        int nodeSum = Math.max(root.val + left + right, Math.max(root.val + left, root.val + right));
        ans.sum = Math.max(ans.sum, root.val);

        return Math.max(root.val, Math.max(root.val + left, root.val + right));
    }

    static int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;

        Sum ans = new Sum();
        maxSum(root, ans);

        return ans.sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root));
    }
}
