public class FlattenBT {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        static void inOrderTraversal(Node root) {
            if (root != null) {
                System.out.print(root.data + " ");
                inOrderTraversal(root.left);
                inOrderTraversal(root.right);
            }
        }

        static void flatten(Node root) {
            if (root != null) {
                if (root.left != null) {
                    flatten(root.left);
                    Node temp = root.left;
                    Node t = root.right;

                    root.right = temp;
                    root.left = null;

                    while (temp.right != null)
                        temp = temp.right;

                    temp.right = t;
                }

                if (root.right != null)
                    flatten(root.right);
            }
        }

        public static void main(String [] args) {
            Node root = new Node(1);

            root.left = new Node(3);
            root.right = new Node(4);

            root.right.left = new Node(2);
            root.right.left.right = new Node(5);
//            root.right.right = new TreeNode(6);

//            root.left.left.left = new TreeNode(4);
//            root.left.left.right = new TreeNode(5);
//            root.left.right.right = new TreeNode(7);

            inOrderTraversal(root);
            flatten(root);
            System.out.println();
            inOrderTraversal(root);
        }
    }
}
