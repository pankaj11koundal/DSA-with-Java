// Program to reverse K nodes
// from 1->2->3->4->5
// to 2->1->4->3->5

import java.util.Scanner;

public class ReverseKNodes {
    static Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            next = null;
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

    static Node reverseKNodes(Node head, int k)
    {
        Node ptr = head, prevPtr = null, nextPtr = null;
        int count = 0;
        while (ptr != null && count < k)
        {
            nextPtr = ptr.next;
            ptr.next = prevPtr;
            prevPtr = ptr;
            ptr = nextPtr;
            count ++;
        }

        if (nextPtr != null)
            head.next = reverseKNodes(nextPtr, k);

        return prevPtr;
    }

    public static void main(String[] args)
    {
        Node head = createLinkedList();
        System.out.println("Linked list before reversing k nodes: ");
        printLinkedList(head);

        head = reverseKNodes(head, 3);
        System.out.println("Linked list after reversing k nodes: ");
        printLinkedList(head);


    }

}
