public class DiameterOfBTInN {
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

    static int findDiameter(TreeNode root, Height h) {
        if (root == null){
            h.height = 0;
            return 0;
        }

        Height lh = new Height();
        Height rh = new Height();

        int lDiameter = findDiameter(root.left, lh);
        int rDiameter = findDiameter(root.right, rh);

        h.height = Math.max(lh.height, rh.height) + 1;

        return Math.max(Math.max(lDiameter, rDiameter), lh.height + rh.height);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        Height h = new Height();

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        root.left.right.left.left = new TreeNode(10);

        System.out.println(findDiameter(root, h));
    }
}
