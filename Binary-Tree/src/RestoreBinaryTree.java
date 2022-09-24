
public class RestoreBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }
    }

    static TreeNode first = null, mid = null, last = null, prev = null;

    static void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    static void findPointer(TreeNode root) {
        if (root != null) {
            findPointer(root.left);

            if (prev != null && prev.val >= root.val) {
                if (first == null) {
                    first = prev;
                    mid = root;
                } else
                    last = root;
            }
            prev = root;
            findPointer(root.right);
        }
    }

    static void recoverTree(TreeNode root) {
        if (root != null) {

            findPointer(root);
            if (first != null && last != null) {
                swap(first, last);
            } else if (first != null && mid != null) {
                swap(first, mid);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(2);
//        root.right.right = new TreeNode(20);
//        root.right.right.right = new TreeNode(5);

        inOrderTraversal(root);
        System.out.println();
        recoverTree(root);
        inOrderTraversal(root);
    }
}

//      3
//     / \
//    1   4
//        /
//       2
