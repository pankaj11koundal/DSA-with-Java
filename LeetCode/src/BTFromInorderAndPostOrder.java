import java.util.HashMap;

public class BTFromInorderAndPostOrder {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static void inorderTraversal(TreeNode root) {
        if (root != null){
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    static int idx;
    static HashMap<Integer, Integer> map = new HashMap<>();

    static TreeNode attachChildren(int []postOrder, int start, int end) {
        if (start > end)
            return null;

        int val = postOrder[idx];
//        System.out.print(val + " ");
        idx--;

        TreeNode current = new TreeNode(val);
        if (start == end)
            return current;

        int pos = map.get(val);
//        System.out.print(pos + " ");
//        System.out.println();
        current.right = attachChildren(postOrder,pos + 1, end);
        System.out.println(idx);
        current.left = attachChildren(postOrder, start, pos - 1);

        return current;
    }

    static TreeNode buildTree(int [] inorder, int []postOrder) {
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        idx = postOrder.length - 1;
        System.out.println(idx);
        return attachChildren(postOrder,0, postOrder.length - 1);
    }

    public static void main(String[] args) {
        int [] postOrder = {4, 2, 5, 3, 1};
        int [] inorder = {4, 2, 1, 5, 3};
        TreeNode root = buildTree(inorder, postOrder);
//        System.out.println(root.val);
        inorderTraversal(root);
    }

}
