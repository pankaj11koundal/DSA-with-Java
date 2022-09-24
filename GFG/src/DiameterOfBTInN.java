public class DiameterOfBTInN {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    static class Height {
        int height = 0;
    }

    static int findDiameter(Node root, Height h) {
        if (root == null){
            h.height = 0;
            return 0;
        }

        Height lh = new Height();
        Height rh = new Height();

        int lDiameter = findDiameter(root.left, lh);
        int rDiameter = findDiameter(root.right, rh);

        h.height = Math.max(lh.height, rh.height) + 1;

        return Math.max(Math.max(lDiameter, rDiameter), lh.height + rh.height + 1) ;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Height h = new Height();

        root.left = new Node(2);
        root.right = new Node(3);

//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//
//        root.left.left.left = new Node(6);
//        root.left.left.right = new Node(7);
//        root.left.right.left = new Node(8);
//        root.left.right.right = new Node(9);
//
//        root.left.right.left.left = new Node(10);

        System.out.println(findDiameter(root, h));
    }
}


//          1
//         / \
//        2   3
//       /\
//      4  5
//     / \   /\
//    6   7 8  9
//         /
//        10