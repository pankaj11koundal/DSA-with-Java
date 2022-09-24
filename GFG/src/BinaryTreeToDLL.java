public class BinaryTreeToDLL {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static Node head, prev;

    static void binaryToDoublyLinkedList(Node root) {
        if (root != null) {
            binaryToDoublyLinkedList(root.left);
            if (prev == null) head = root;
            else {
                prev.right = root;
                prev.right.left = prev;
            }
            prev = root;
            binaryToDoublyLinkedList(root.right);
        }
    }

    static Node bToDLL(Node root)
    {
        prev = null;
        head = null;
        binaryToDoublyLinkedList(root);
        return head;
    }


    public static void main(String[] args) {
        Node root = new Node(3);

        root.left = new Node(9);
        root.right = new Node(20);

        root = bToDLL(root);
    }
}
