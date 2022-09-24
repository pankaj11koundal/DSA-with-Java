public class LargestBSTInBT {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class Info {
        int max;
        int min;
        int size;
        int ans;
        boolean isBST;
        Info() {

        }
        Info(int max, int min, int size, int ans, boolean isBST) {
            this.max = max;
            this.min = min;
            this.size = size;
            this.ans = ans;
            this.isBST = isBST;
        }
    }

    static Info largestBSTInBT(Node root) {
        if (root == null)
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, true);

        if (root.left == null && root.right == null)
            return new Info(root.data, root.data, 1, 1, true);

        Info left = largestBSTInBT(root.left);
        Info right = largestBSTInBT(root.right);

        Info current = new Info();
        current.size = left.size + right.size + 1;
        if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
            current.max = Math.max(left.max, Math.max(right.max, root.data));
            current.min = Math.min(left.min, Math.min(right.min, root.data));
            current.ans = current.size;
            current.isBST = true;
            return current;
        }

        current.ans = Math.max(left.ans, right.ans);
        current.isBST = false;

        return current;

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(4);
        root.right = new Node(3);

        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(2);
        root.right.right = new Node(5);

        root.right.right.left = new Node(4);
        root.right.right.right = new Node(6);

        System.out.println(largestBSTInBT(root).ans);
    }
}
