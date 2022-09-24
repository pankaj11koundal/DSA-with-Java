public class BinaryTreeToDLL {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static TreeNode head, prev = null;

    static void binaryToDoublyLinkedList(TreeNode root) {
        if (root != null){
            binaryToDoublyLinkedList(root.left);
            if (prev == null) head = root;
            else  {
                prev.right = root;
                root.left = prev;
            }
            prev = root;
            binaryToDoublyLinkedList(root.right);
        }
    }

    static void printDoublyLinkedList(TreeNode root) {
        if (root != null) {
            printDoublyLinkedList(root.left);
            System.out.println(root.val);
            printDoublyLinkedList(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

//        root.right.left = new TreeNode(1);
//        root.right.left.left = new TreeNode(4);
//        root.right.left.right = new TreeNode(6);

        binaryToDoublyLinkedList(root);
        printDoublyLinkedList(root);
    }
}
