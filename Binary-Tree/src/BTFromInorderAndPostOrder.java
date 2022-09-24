
public class BTFromInorderAndPostOrder {
    static int idx;

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

    static int search(int[] inorder, int start, int end, int val) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == val)
                return i;
        }
        return -1;
    }

    static void inorderTraversal(TreeNode root) {
        if (root != null){
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    static TreeNode buildTree(int[] inorder, int[] postOrder, int start, int end) {
        if (start > end)
            return null;

//        System.out.println(idx);
        int val = postOrder[idx];
        TreeNode current = new TreeNode(val);
        idx--;

        if (start == end)
            return current;
        int pos = search(inorder, start, end, val);

        current.right = buildTree(inorder, postOrder, pos + 1, end);
        current.left = buildTree(inorder, postOrder, start, pos - 1);

        return current;
    }

    public static void main(String[] args) {
        int [] postOrder = {4, 2, 5, 3, 1};
        int [] inorder = {4, 2, 1, 5, 3};
        idx = postOrder.length - 1;
        TreeNode root = buildTree(inorder, postOrder, 0, inorder.length - 1);
        System.out.println(root.val);
        inorderTraversal(root);
    }
}
