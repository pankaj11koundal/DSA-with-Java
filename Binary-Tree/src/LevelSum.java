import java.util.LinkedList;
import java.util.Queue;

public class LevelSum {
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

    static int sum = 0;

    static int sumAtKLevel(Queue<TreeNode> q, int k) {
        if (k == 0)
            return sum;
        else {
            TreeNode node = q.remove();
            if (node != null) {
                sum += node.val;
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            } else {
                q.add(node);
                k--;
                if (k != 0)
                    sum = 0;
            }
            return sumAtKLevel(q, k);
        }
    }

    public static void main(String[] args) {
        Queue<TreeNode> q = new LinkedList<>();

        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
//        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        q.add(head);
        q.add(null);

        System.out.println(sumAtKLevel(q, 3));
    }

}
