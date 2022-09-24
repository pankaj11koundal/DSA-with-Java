import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelTraversal {
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

    static List<List<Integer>> levelTraversal(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node != null) {
                arr.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            } else {
                List<Integer> temp = new ArrayList<>(arr);
                l.add(temp);
                arr.clear();
                if (!q.isEmpty()) {
                    q.add(node);
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
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(levelTraversal(root));
    }
}
