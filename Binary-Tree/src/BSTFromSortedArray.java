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

    static TreeNode sortedArrayToBST(int [] nums) {
        int start = 0;
        int end = nums.length - 1;

        return createBST(nums, start, end);
    }

    static ArrayList<Integer> inOrderTraversal (TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (root != null) {
            arr.add(root.val);
            inOrderTraversal(root.left);
            inOrderTraversal(root.right);
        }

        return  arr;
    }

    public static void main (String[] args) {
        int [] nums = {-8, 4};
        TreeNode root = sortedArrayToBST(nums);
        inOrderTraversal(root);
    }
}
