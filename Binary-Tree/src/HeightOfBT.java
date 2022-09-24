public class HeightOfBT {
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

    static int calHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = calHeight(root.left);
        int rightHeight = calHeight(root.right);

        return (Math.max(leftHeight, rightHeight) + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Height of the tree: " + calHeight(root));
    }
}
