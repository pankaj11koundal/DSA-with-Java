public class MaxPathSumLeaf2Leaf {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class Ans {
        int res;
        Ans() {
            res = Integer.MIN_VALUE;
        }
    }

    static int findMaxPathSum(Node root, Ans ans) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) return root.data;

        int left = findMaxPathSum(root.left, ans);
        int right = findMaxPathSum(root.right, ans);

        if (root.left == null) return root.data + right;
        if (root.right == null) return root.data + left;

        ans.res = Math.max(left + right + root.data, ans.res);

        return Math.max(left, right) + root.data;
    }
    static int maxPathSum(Node root) {
        Ans ans = new Ans();

        int s = findMaxPathSum(root, ans);

        return root.left == null || root.right == null ? Math.max(ans.res, s) : ans.res;
    }

    public static void main(String[] args) {
        Node root = new Node(5);

        root.left = null;
        root.right = new Node(6);

        root.right.left = new Node(-5);
        root.right.right = new Node(5);

        System.out.println(maxPathSum(root));
    }


}
