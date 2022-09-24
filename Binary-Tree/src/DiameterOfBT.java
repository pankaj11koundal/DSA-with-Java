// Find the diameter of the tree in O(n^2)  time complexity

public class DiameterOfBT {
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

        return Math.max(calcHeight(root.left), calcHeight(root.right)) + 1;
    }

    static int findDiameter(TreeNode root) {
        if (root == null)
            return 0;

        int lHeight = calcHeight(root.left);
        int rHeight = calcHeight(root.right);
        int currentDiameter = lHeight + rHeight + 1;

        int lDiameter = findDiameter(root.left);
        int rDiameter = findDiameter(root.right);

        return Math.max(currentDiameter, Math.max(lDiameter, rDiameter));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(findDiameter(root));
    }
}
