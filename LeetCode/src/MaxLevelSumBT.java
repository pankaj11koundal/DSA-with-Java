import java.util.Queue;
import java.util.LinkedList;

public class MaxLevelSumBT {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;
        else {
            Queue<TreeNode> q = new LinkedList<>();
            int k = 0, sum = 0, maxSum = Integer.MIN_VALUE, maxLevel = Integer.MIN_VALUE;

            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                TreeNode node = q.remove();
                if (node != null) {
                    sum += node.val;
                    if (node.left != null)
                        q.add(node.left);
                    if (node.right != null)
                        q.add(node.right);
                } else {
                    if (!q.isEmpty())
                        q.add(node);
                    k++;
                    if (sum > maxSum) {
                        maxSum = sum;
                        maxLevel = k;
                    }
                    sum = 0;
                }
            }
            return maxLevel;
        }
    }

    public static void main(String[] args ) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(7);
        root.right = new TreeNode(0);

        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);

        System.out.println(maxLevelSum(root));
    }
}
