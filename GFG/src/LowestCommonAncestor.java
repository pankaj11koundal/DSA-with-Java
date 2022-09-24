public class LowestCommonAncestor {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;

            this.left = null;
            this.right = null;
        }
    }

    static Node lca(Node root, int p, int q) {
        if (root == null)
            return null;

        if (root.data == p || root.data == q)
            return root;

        Node leftLCA = lca(root.left, p, q);
        Node rightLCA = lca(root.right, p, q);

        if (leftLCA != null && rightLCA != null)
            return root;

        if (leftLCA != null)
            return leftLCA;
        else
            return rightLCA;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left =  new Node(2);
        root.right = new Node(4);

        root.left.left = new Node(3);
        root.left.right = new Node(5);

        System.out.println(lca(root, 3, 5).data);
    }

}
