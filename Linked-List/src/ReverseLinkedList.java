// Java program to reverse the linked list

import java.util.Scanner;

public class ReverseLinkedList {
    static Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;

        }
    }

    static Node createLinkedList()
    {
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

    static void printLinkedList(Node head)
    {
        Node nextptr = head;
        while(nextptr != null){
            System.out.print(nextptr.data + " ");
            nextptr = nextptr.next;
        }
    }

    static Node reverseLinkedList(Node head)
    {
        Node prevPtr = head, ptr = head.next, nPtr;
        head.next = null;
        while (ptr != null) {
            nPtr = ptr.next;
            ptr.next = prevPtr;
            prevPtr = ptr;
            ptr = nPtr;
        }

        head = prevPtr;
        return head;
    }



    public static void main(String[] args)
    {
        Node head = createLinkedList();
        System.out.println("Linked List before reversing: ");
        printLinkedList(head);

        System.out.println("Linked List after reversing: ");
        if (head != null)
            head = reverseLinkedList(head);
        printLinkedList(head);
    }
}
