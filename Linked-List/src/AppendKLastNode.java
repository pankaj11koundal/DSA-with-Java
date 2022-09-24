// Java program to append the K-last nodes in the front
// ex: 1->2->3->4->5, k=2, 4->5->1->2->3

import java.util.Scanner;

public class AppendKLastNode {
    static Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node createLinkedList(){
        int data;
        char choice;
        System.out.println("Want to create more nodes(y/n): ");
        choice = sc.next().charAt(0);

        if (choice == 'Y' || choice == 'y')
        {
            System.out.print("Enter the data for node: ");
            data = sc.nextInt();
            Node node = new Node(data);
            node.next = createLinkedList();
            return node;
        }
        else
            return null;
    }

    static void printLinkedList(Node head){
        Node nextptr = head;
        while(nextptr != null){
            System.out.print(nextptr.data + " ");
            nextptr = nextptr.next;
        }
    }

    static int findLength(Node head) {
        Node ptr = head;
        int count = 0;

        while(ptr != null){
            ptr = ptr.next;
            count++;
        }

        return count;
    }

    static Node appendKLastNodes(Node head, int k) {
        int length = findLength(head);

        if (length < k) {
            Node nptr = head, ptr = head;

            while (k > 0) {
                nptr = nptr.next;
                k--;
            }

            while (nptr != null && nptr.next != null) {
                nptr = nptr.next;
                ptr = ptr.next;
            }

            nptr.next = head;
            head = ptr.next;
            ptr.next = null;

        }
        return head;
    }


    public static void main(String[] args)
    {
        Node head = createLinkedList();

        System.out.println("Before appending the k nodes: ");
        printLinkedList(head);

        System.out.println();
        int k;
        System.out.println("Enter the k: ");
        k = sc.nextInt();

        head = appendKLastNodes(head, k);
        System.out.println("After appending k nodes: ");
        printLinkedList(head);
    }
}
