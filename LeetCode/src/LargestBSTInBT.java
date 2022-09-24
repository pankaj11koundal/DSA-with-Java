class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class Solution {
    private int ans = 0;

    public int maxSumBST(TreeNode root) {
        if (root == null) return 0;

        Info info = largestBSTInBT(root);
        return ans;
    }

    private Info largestBSTInBT(TreeNode root) {
        if (root == null) return new Info();

        Info left = largestBSTInBT(root.left);
        Info right = largestBSTInBT(root.right);

        Info current = new Info();

        if (left.isBST && right.isBST) {
            if (left.max < root.val && right.min > root.val) {
                current.maxSum = left.maxSum + right.maxSum + root.val;
                current.max = right.max == Integer.MIN_VALUE ? root.val : right.max;
                current.min = left.min == Integer.MAX_VALUE ? root.val : left.min;
            } else {
                current.isBST = false;
            }
        } else {
            current.isBST = false;
        }

        if (current.isBST) {
            ans = Math.max(ans, current.maxSum);
        }
        return current;
    }

    private class Info {
        int max;
        int min;
        int maxSum;
        boolean isBST;

        Info() {
            this.max = Integer.MIN_VALUE;
            this.min = Integer.MAX_VALUE;
            this.maxSum = 0;
            this.isBST = true;
        }
    }
}

public class LargestBSTInBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-4);
//
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-5);
//
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(2);
//        root.right.left = new TreeNode(2);
//        root.right.right = new TreeNode(5);
//
//        root.right.right.left = new TreeNode(4);
//        root.right.right.right = new TreeNode(6);

        Solution s = new Solution();
        System.out.println(s.maxSumBST(root));
    }
}