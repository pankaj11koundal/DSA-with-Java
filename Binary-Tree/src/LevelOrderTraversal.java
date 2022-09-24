import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
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

    static void levelOrderTraversal(Queue<TreeNode> q) {
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

    public static void main(String [] args) {
        Queue<TreeNode> q = new LinkedList<>();

        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        q.add(head);
        q.add(null);

        levelOrderTraversal(q);
    }
}
