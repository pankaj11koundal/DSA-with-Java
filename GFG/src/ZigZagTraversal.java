import java.util.ArrayList;
import java.util.Stack;

public class ZigZagTraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static ArrayList<Integer> zigzagLevelOrder(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();

        if (root != null) {
            Stack<Node> current = new Stack<>();
            Stack<Node> next = new Stack<>();
            Stack<Node> temp;
            boolean leftToRight = true;

            current.push(root);
            while (!current.isEmpty()) {
                Node node = current.pop();
                arr.add(node.data);

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
                }
            }

        }
        return arr;
    }

    public static void main(String[] args) {
        Node root = new Node(3);

        root.left = new Node(9);
        root.right = new Node(20);

        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println(zigzagLevelOrder(root));
    }

}
