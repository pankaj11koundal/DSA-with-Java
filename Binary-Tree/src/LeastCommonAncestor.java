public class LeastCommonAncestor {
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

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root.val == p.val || root.val == q.val)
            return root;

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        if (leftLCA != null && rightLCA != null)
            return root;

        if (leftLCA != null)
            return leftLCA;
        else
            return rightLCA;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left =  new TreeNode(2);
        root.right = new TreeNode(4);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);

        System.out.println(lowestCommonAncestor(null, root, root.left.left).val);
    }
}
