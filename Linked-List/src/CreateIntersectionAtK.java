// Java program to intersect two linked lists at K point.

import java.util.Scanner;

public class CreateIntersectionAtK {
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

    static void intersectLinkedLists(Node head1, Node head2, int k) {
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

    public static void main(String[] args) {
        Node head1 = createLinkedList();
        Node head2 = createLinkedList();

        System.out.println("Linked list without intersections");
        System.out.println("List 1: ");
        printLinkedList(head1);
        System.out.println();
        System.out.println("List 2: ");
        printLinkedList(head2);

        System.out.println();
        System.out.println("Enter the node number where you want to intersect: ");
        int k = sc.nextInt();
        intersectLinkedLists(head1, head2, k);

        System.out.println("Linked list after intersections");
        System.out.println("List 1: ");
        printLinkedList(head1);
        System.out.println();
        System.out.println("List 2: ");
        printLinkedList(head2);
    }

}
