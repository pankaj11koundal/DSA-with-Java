public class LargestBSTInBT {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static class Info {
        int max;
        int min;
        int size;
        int ans;
        boolean isBST;
        Info() {

        }
        Info(int max, int min, int size, int ans, boolean isBST) {
            this.max = max;
            this.min = min;
            this.size = size;
            this.ans = ans;
            this.isBST = isBST;
        }
    }

    static Info largestBST(TreeNode root) {
        if (root == null)
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, true);

        if (root.left == null && root.right == null)
            return new Info(root.val, root.val, 1, 1, true);

        Info left = largestBST(root.left);
        Info right = largestBST(root.right);

        Info current = new Info();
        current.size = left.size + right.size + 1;
        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            current.max = Math.max(left.max, Math.max(right.max, root.val));
            current.min = Math.min(left.min, Math.min(right.min, root.val));
            current.ans = current.size;
            current.isBST = true;
            return current;
        }

        current.ans = Math.max(left.ans, right.ans);
        current.isBST = false;

        return current;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);

        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(6);

        System.out.println(largestBST(root).ans);
    }
}
