public class MaxPathSumBetween2Nodes {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class Sum {
        int sum;

        Sum() {
            sum = Integer.MIN_VALUE;
        }
    }

    static int maxSum(Node root, Sum ans) {
        if (root == null)
            return 0;

        int left = maxSum(root.left, ans);
        int right = maxSum(root.right, ans);

        int nodeSum = Math.max(root.data + left + right, Math.max(root.data + left, root.data + right));
        ans.sum = Math.max(ans.sum, nodeSum);

        return Math.max(root.data, Math.max(root.data + left, root.data + right));
    }

    static int maxPathSum(Node root) {
        if (root == null)
            return 0;

        Sum ans = new Sum();
        maxSum(root, ans);

        return ans.sum;
    }

    public static void main(String[] args) {
        Node root = new Node(-15);
        root.left = new Node(5);
        root.right = new Node (6);

        root.left.left = new Node(-8);
        root.left.right = new Node(1);
        root.right.left = new Node(3);
        root.right.right = new Node(9);

        root.left.left.left = new Node(2);
        root.left.left.right = new Node(-3);
        root.right.right.right = new Node(0);

        root.right.right.right.left = new Node(4);
        root.right.right.right.right = new Node(-1);
        root.right.right.right.right.left = new Node(-10);

        System.out.println(maxPathSum(root));
    }
}
