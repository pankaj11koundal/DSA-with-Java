public class BTFromInorderAndPreOrder {
    static int idx;

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

    static void inorderTraversal(Node root) {
        if (root != null){
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    static int search(int[] inorder, int start, int end, int val) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == val)
                return i;
        }
        return -1;
    }

    static Node constructTree(int[] inorder, int[] preorder, int start, int end) {
        if (start > end)
            return null;

//        System.out.println(idx);
        int val = preorder[idx];
        Node current = new Node(val);
        idx--;

        if (start == end)
            return current;
        int pos = search(inorder, start, end, val);

        current.right = constructTree(inorder, preorder, pos + 1, end);
        current.left = constructTree(inorder, preorder, start, pos - 1);

        return current;
    }

    static Node buildTree(int[] inorder, int[] preOrder, int n) {
        return constructTree(inorder, preOrder, 0, inorder.length - 1);
    }

    public static void main(String[] args) {
//        int [] preorder = {1 6 8 7};
        int [] inorder = {4, 2, 1, 5, 3};
//        idx = preorder.length - 1;
//        Node root = buildTree(inorder, preorder, inorder.length);
//        System.out.println(root.data);
//        inorderTraversal(root);
    }
}