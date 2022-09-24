// Put all the even placed node after the odd placed node
// Ex: 1->3->5->7->2->4->6 ::: 1->2->3->4->5->6->7

import java.util.Scanner;

public class PutEvenNodeAfterOddNode {
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

    static void putEvenNodesAfterOddNodes(Node head) {
        Node odd = head, even = odd.next, evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

    }

    public static void main(String[] args) {
        Node head = createLinkedList();
        System.out.println("The linked list before putting even node at the back of odd nodes");
        printLinkedList(head);
        System.out.println();

        putEvenNodesAfterOddNodes(head);
        System.out.println("The linked list after putting even node at the back of odd nodes");
        printLinkedList(head);
    }

}
