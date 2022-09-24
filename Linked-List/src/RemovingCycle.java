// Java program to remove the cycle from the linked list and make it a normal linked list.

import java.util.Scanner;

public class RemovingCycle {

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
                temp = ptr;

            count ++;
            ptr = ptr.next;
        }
        ptr.next = temp;
    }

    static Node detectCycle(Node head)
    {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
            {
                return slow;
            }
        }
        return null;
    }

    static void removeCycle(Node head) {
        Node meet = detectCycle(head), start = head;

        if (meet != null){
            while(meet.next != start.next){
                start = start.next;
                meet = meet.next;
            }
        }

        meet.next = null;
    }


    public static void main(String[] args){
        Node head = createLinkedList();
        System.out.println("Linked list before creating the circle: ");
        printLinkedList(head);

        System.out.println();
        System.out.println("Enter the position where you want to join the end of the linked list: ");
        int k = sc.nextInt();

        createCycle(head, k);

        removeCycle(head);
        System.out.println();
        System.out.println("Linked List after removing the cycle: ");
        printLinkedList(head);
    }
}
