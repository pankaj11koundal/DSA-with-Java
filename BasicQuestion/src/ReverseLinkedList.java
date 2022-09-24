import java.util.Scanner;

public class ReverseLinkedList {
    static Scanner sc = new Scanner(System.in);

    static class Node
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.next = null;
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
        Node curPtr = head, nextPtr = null, prevPtr = null;
        while (curPtr != null){
            nextPtr = curPtr.next;
            if (curPtr != head)
                curPtr.next = prevPtr;
            else
                curPtr.next = null;
            prevPtr = curPtr;
            curPtr = nextPtr;
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
        head = reverseLinkedList(head);
        printLinkedList(head);
    }
}
