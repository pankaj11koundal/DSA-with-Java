// Java program to find the intersection point in the linked list(an optimized approach)

import java.util.Scanner;

public class FindIntersectionPointOptimizedApproach {
    static Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        boolean flag;
        Node next;

        Node(int data) {
            this.data = data;
            this.flag = false;
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

    static void createIntersectionLinkedList (Node head1, Node head2, int k) {
        Node ptr1 = head1, ptr2 = head2;

        while (k > 1) {
            ptr1 = ptr1.next;
            k--;
        }

        while (ptr2.next != null) {
            ptr2 = ptr2.next;
        }

        ptr2.next = ptr1;
    }

    static Node findIntersectionPoint(Node head1, Node head2) {
        if (head1 != null && head2 != null) {
            while (head1 != null) {
                head1.flag = true;
                head1 = head1.next;
            }

            while (head2 != null) {
                if (!head2.flag){
                    head2.flag = true;
                    head2 = head2.next;
                }
                else
                    return head2;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node head1 = createLinkedList();
        Node head2 = createLinkedList();

        System.out.println("Linked list before creating the intersection: ");
        System.out.println("List 1: ");
        printLinkedList(head1);
        System.out.println();
        System.out.println("List 2: ");
        printLinkedList(head2);

        System.out.println();
        System.out.println("Enter the node number at which you want to create the intersection: ");
        int k = sc.nextInt();
        createIntersectionLinkedList(head1, head2, k);

        System.out.println("Linked list after creating the intersection: ");
        System.out.println("List 1: ");
        printLinkedList(head1);
        System.out.println();
        System.out.println("List 2: ");
        printLinkedList(head2);

        Node intersectingNode = findIntersectionPoint(head1, head2);

        System.out.println();
        if (intersectingNode != null)
            System.out.println("Intersection at: " + intersectingNode.data);
        else
            System.out.println("No intersection");
    }
}

