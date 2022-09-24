
public class BTFromInorderAndPostOrder {
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

    static int search(int[] inorder, int start, int end, int val) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == val)
                return i;
        }
        return -1;
    }

    static void inorderTraversal(Node root) {
        if (root != null){
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    static Node generateTree(int[] in, int[] post, int start, int end) {
        if (start > end)
            return null;

//        System.out.println(idx);
        int val = post[idx];
        Node current = new Node(val);
        idx--;

        if (start == end)
            return current;
        int pos = search(in, start, end, val);

        current.right = generateTree(in, post, pos + 1, end);
        current.left = generateTree(in, post, start, pos - 1);

        return current;
    }

    public static void main(String[] args) {
        int [] post = {4, 2, 5, 3, 1};
        int [] in = {4, 2, 1, 5, 3};
        idx = post.length - 1;
        Node root = generateTree(in, post, 0, in.length - 1);
        inorderTraversal(root);
    }
}
