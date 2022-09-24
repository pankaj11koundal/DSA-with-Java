public class BalancedHeightBTInN {
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

    static class Height {
        int height = 0;
    }

    static boolean checkBalancedBT(TreeNode root, Height h) {
        if (root == null)
            return true;

        Height lh = new Height();
        Height rh = new Height();
        if (!checkBalancedBT(root.left, lh))
            return false;

        if (!checkBalancedBT(root.right, rh))
            return false;

        h.height = Math.max(lh.height, rh.height) + 1;
        return Math.abs(lh.height - rh.height) <= 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Height h = new Height();

        System.out.println(checkBalancedBT(root, h));
    }
}
