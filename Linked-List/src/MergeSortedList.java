// Program to merge the two sorted linked list using the merging algorithm

import java.util.Scanner;

public class MergeSortedList {
    static Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node next;

        Node(){}

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

    static Node mergeSort(Node head1, Node head2) {
        Node ptr3 = new Node(), newHead = ptr3;
        if (head1 != null && head2 != null) {
            while (head1 != null && head2 != null) {
                if (head1.data < head2.data) {
                    ptr3.next = head1;
                    head1 = head1.next;
                } else {
                    ptr3.next = head2;
                    head2 = head2.next;
                }
                ptr3 = ptr3.next;
            }

            while(head1 != null) {
                ptr3.next = head1;
                head1 = head1.next;
                ptr3 = ptr3.next;
            }

            while(head2 != null) {
                ptr3.next = head2;
                head2 = head2.next;
                ptr3 = ptr3.next;
            }

            return newHead.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Node head1 = createLinkedList();
        Node head2 = createLinkedList();

        System.out.println("The two sorted linked list are: ");
        System.out.println("List 1: ");
        printLinkedList(head1);
        System.out.println();
        printLinkedList(head2);
        System.out.println();

        Node head = mergeSort(head1, head2);

        System.out.println("The sorted linked list is-");
        printLinkedList(head);
    }
}
