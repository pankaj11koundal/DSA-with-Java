import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBT {
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

    static ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (root != null) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()) {
                for (int i = q.size() - 1; i >= 0; i--) {
                    Node node = q.remove();

                    if (i == 0)
                        arr.add(node.data);

                    if (node.left != null)
                        q.add(node.left);

                    if (node.right != null)
                        q.add(node.right);
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Node root = new Node(20);

        root.left = new Node(8);
        root.right = new Node(22);

        root.left.left = new Node(4);
        root.left.right = new Node(12);

        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        System.out.println(rightView(root));
    }

}
