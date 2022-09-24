import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();

        if (root != null) {
            Stack<TreeNode> current = new Stack<>();
            Stack<TreeNode> next = new Stack<>();
            Stack<TreeNode> temp;
            boolean leftToRight = true;

            current.push(root);
            while (!current.isEmpty()) {
                TreeNode node = current.pop();
                arr.add(node.val);

                if (leftToRight) {
                    if (node.left != null)
                        next.push(node.left);

                    if (node.right != null)
                        next.push(node.right);
                } else {
                    if (node.right != null)
                        next.push(node.right);
                    if (node.left != null)
                        next.push(node.left);
                }
                if (current.isEmpty()) {
                    temp = current;
                    current = next;
                    next = temp;
                    leftToRight = !leftToRight;
                    List<Integer> t = new ArrayList<>(arr);
                    l.add(t);
                    arr.clear();
                }
            }

        }
        return l;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(zigzagLevelOrder(root));
    }
}
