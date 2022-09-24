import java.util.ArrayList;
import java.util.List;

public class NodesAtDistanceK {
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

    static void downNodesAtDistanceK(TreeNode root, int k, List<Integer> l) {
        if (root != null && k >= 0) {
            downNodesAtDistanceK(root.left, k - 1, l);
            downNodesAtDistanceK(root.right, k - 1, l);

            if (k == 0)
                l.add(root.val);
        }
    }

    static int nodesAtDistanceK(TreeNode root, TreeNode target, int k, List<Integer> l) {
        if (root == null) {
            return -1;
        }

        if (root == target) {
            downNodesAtDistanceK(root, k, l);
            return 0;
        }

        int dl = nodesAtDistanceK(root.left, target, k, l);

        if (dl != -1) {
            if (dl + 1 == k)
                l.add(root.val);
            else
                downNodesAtDistanceK(root.right, k - dl - 2, l);

            return dl + 1;
        }

        int dr = nodesAtDistanceK(root.right, target, k, l);

        if (dr != -1){
            if (dr + 1 == k)
                l.add(root.val);
            else
                downNodesAtDistanceK(root.left, k - dr - 2, l);

            return dr + 1;
        }
        return -1;
    }

    static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> l = new ArrayList<>();

        if (root == null)
            return l;

        nodesAtDistanceK(root, target, k, l);
        return l;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);

        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        System.out.println(distanceK(root, root.left, 2));
    }
}
