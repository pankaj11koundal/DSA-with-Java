// Java program to create cycle in the linked list
// 1->2->3->4->5->6->3

import java.util.Scanner;

public class CreatingCycle {
    static Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
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

    static void createCycle(Node head, int k){
        Node ptr = head, temp = null;
        int count = 1;

        while (ptr.next != null){
            if (count == k)
                temp = head;

            count ++;
            ptr = ptr.next;
        }
        ptr.next = temp;
    }

    public static void main(String[] args) {
        Node head = createLinkedList();
        int k;
        System.out.println("Linked list before creating cycle: ");
        printLinkedList(head);

        System.out.println();
        System.out.print("Enter the position at which you want to join the cycle: ");
        k = sc.nextInt();

        createCycle(head, k);

        System.out.println();
        System.out.println("Linked list after creating cycle");
        printLinkedList(head);
    }
}
