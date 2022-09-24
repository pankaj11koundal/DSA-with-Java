import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreePruning {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static class Solution {
        void levelOrderTraversal(Queue<TreeNode> q) {
            if (!q.isEmpty()) {
                TreeNode node = q.poll();

                if (node != null) {
                    if (node.left != null)
                        q.add(node.left);
                    if (node.right != null)
                        q.add(node.right);

                    System.out.print(node.val + " ");
                } else {
                    if (!q.isEmpty())
                        q.add(node);
                }
                levelOrderTraversal(q);
            }
        }


        TreeNode pruningBT(TreeNode root) {
            if (root == null) return null;

            root.left = pruningBT(root.left);
            root.right = pruningBT(root.right);

            if (root.left == null && root.right == null && root.val != 1) return null;

            return root;
        }
    }
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(0);
        t.right = new TreeNode(1);
        t.left.left = new TreeNode(1);
        t.left.right = new TreeNode(0);
        t.right.left = new TreeNode(1);
        t.right.right = new TreeNode(0);

        Queue<TreeNode> q = new LinkedList<>();

        Solution s = new Solution();
        s.pruningBT(t);

        q.add(t);
        q.add(null);
        s.levelOrderTraversal(q);
    }
}
