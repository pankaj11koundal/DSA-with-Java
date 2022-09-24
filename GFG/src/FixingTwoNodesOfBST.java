public class FixingTwoNodesOfBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    static Node first , mid , last , prev ;

    static void swap(Node a, Node b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }

    static void findPointer(Node root) {
        first = mid = last = prev = null;
        if (root != null) {
            findPointer(root.left);

            if (prev != null && prev.data >= root.data) {
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

    static void recoverTree(Node root) {
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
        Node root = new Node(3);

        root.left = new Node(1);
        root.right = new Node(4);

//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(7);
        root.right.left = new Node(2);
//        root.right.right = new TreeNode(20);
//        root.right.right.right = new TreeNode(5);

        inOrderTraversal(root);
        System.out.println();
        recoverTree(root);
        inOrderTraversal(root);
    }
}
