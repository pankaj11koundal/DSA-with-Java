// Java program to find the height of the binary tree
//          1
//         /  \
//        2    3
//       / \
//      4   5
//     / \
//    6   7

public class HeightOfBinaryTree {

    static class Tree {
        Tree left;
        Tree right;
        int data;

        Tree(int data) {
            this.data = data;
        }
    }

    static int findHeight(Tree root) {
        if (root == null)
            return 0;
        else{
            int leftHeight = findHeight(root.left);
            int rightHeight = findHeight(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);

        root.left.left = new Tree(4);
        root.left.right = new Tree(5);

        root.left.left.left = new Tree(6);
        root.left.left.right = new Tree(7);

        System.out.println("Height of the binary tree is " + findHeight(root));

    }
}
