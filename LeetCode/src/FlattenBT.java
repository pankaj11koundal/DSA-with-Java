public class FlattenBT {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        static void inOrderTraversal(TreeNode root) {
            if (root != null) {
                System.out.print(root.val + " ");
                inOrderTraversal(root.left);
                inOrderTraversal(root.right);
            }
        }

        static void flattenBT(TreeNode root) {
            if (root != null) {
                if (root.left != null) {
                    flattenBT(root.left);
                    TreeNode temp = root.left;
                    TreeNode t = root.right;

                    root.right = temp;
                    root.left = null;

                    while (temp.right != null)
                        temp = temp.right;

                    temp.right = t;
                }

                if (root.right != null)
                    flattenBT(root.right);
            }
        }

        public static void main(String [] args) {
            TreeNode root = new TreeNode(1);

            root.left = new TreeNode(2);
            root.right = new TreeNode(8);

            root.left.left = new TreeNode(3);
            root.left.right = new TreeNode(6);
            root.right.right = new TreeNode(9);

            root.left.left.left = new TreeNode(4);
            root.left.left.right = new TreeNode(5);
            root.left.right.right = new TreeNode(7);

            inOrderTraversal(root);
            flattenBT(root);
            System.out.println();
            inOrderTraversal(root);
        }
    }

}
