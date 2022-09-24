public class DistanceBetweenTwoNodes {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static TreeNode leastCommonFactor(TreeNode root, int t1, int t2) {
        if (root == null) {
            return null;
        }

        if (root.val == t1 || root.val == t2)
            return root;

        TreeNode left = leastCommonFactor(root.left, t1, t2);
        TreeNode right = leastCommonFactor(root.right, t1, t2);

        if (left != null && right != null)
            return root;

        if (left != null)
            return left;
        else
            return right;
    }

    static int calcDistance(TreeNode root, int t, int d) {
        if (root == null)
            return 0;

        if (root.val == t)
            return d;

        int ld = calcDistance(root.left, t, d + 1);
        if (ld != 0)
            return ld;

        return calcDistance(root.right, t, d + 1);
    }

    static int findDist(TreeNode root, int t1, int t2) {
        if (root == null)
            return 0;

        TreeNode leastCommonFactor = leastCommonFactor(root, t1,t2);

        return (calcDistance(leastCommonFactor, t1, 0) + calcDistance(leastCommonFactor, t2, 0));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.right.right.left = new TreeNode(8);

        System.out.println(findDist(root, 4, 8));
    }
}
