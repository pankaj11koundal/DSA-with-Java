public class TransformToSumTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        static void sumReplacement(TreeNode root) {
            if (root != null) {
                if (root.left == null && root.right == null) {
                    root.val = 0;
                }

                sumReplacement(root.left);
                sumReplacement(root.right);

                if (root.left != null)
                    root.val += root.left.val;
                if (root.right != null)
                    root.val += root.right.val;
            }
        }

        static void traverseTree(TreeNode root) {
            if (root != null) {
                traverseTree(root.left);
                System.out.print(root.val + " ");
                traverseTree(root.right);
            }
        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(10);

            root.left = new TreeNode(-2);
            root.right = new TreeNode(6);

            root.left.left = new TreeNode(8);
            root.left.right = new TreeNode(-4);
            root.right.left = new TreeNode(7);
            root.right.right = new TreeNode(5);

            sumReplacement(root);
            traverseTree(root);
        }

    }
}
