import java.util.ArrayList;

public class BSTFromSortedArray {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static TreeNode createBST (int []nums, int start, int end) {
        if (end < start)
            return null;

        if (start == end)
            return new TreeNode(nums[start]);

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, start, mid - 1);
        root.right = createBST(nums, mid + 1, end);

        return root;
    }

    static int i = 0;

    static int[] sortedArrayToBST(int [] nums) {
        int start = 0;
        int end = nums.length - 1;
        int []preOrder = new int[nums.length];
        TreeNode root = createBST(nums, start, end);

        preOrderTraversal(root, preOrder);
        return preOrder;
    }

    static void preOrderTraversal(TreeNode root, int[] preOrder) {
        if (root != null) {
            preOrder[i] = root.val;
            i++;
            preOrderTraversal(root.left, preOrder);
            preOrderTraversal(root.right, preOrder);
        }
    }

    public static void main (String[] args) {
        int [] nums = {-8, 4};
        int[] root = sortedArrayToBST(nums);
        for (int i = 0; i < root.length; i++)
            System.out.println(root[i]);
    }
}
