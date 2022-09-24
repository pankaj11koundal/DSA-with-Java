
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewOfBT {
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

    static List<Integer> leftViewTree(TreeNode root) {
        List<Integer> l = new LinkedList<>();

        if (root != null) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                int n = q.size();
                for (int i = 0; i < n; i++) {
                    TreeNode node = q.remove();

                    if (i == 0)
                        l.add(node.val);

                    if (node.right != null)
                        q.add(node.right);

                    if (node.left != null)
                        q.add(node.left);
                }
            }
        }

        return l;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);

        System.out.println(leftViewTree(root));
    }
}
