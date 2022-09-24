public class CloneLinkedListWithRandomNext {
    static class Node {
        int data;
        Node next, arb;

        Node(int d)
        {
            data = d;
            next = arb = null;

        }
    }

    static Node copyList(Node head) {
        Node curr = head;
        while(curr != null) {
            Node nextptr = curr.next;
            Node newp = new Node(curr.data);
            curr.next = newp;
            newp.next = nextptr;
            curr = nextptr;
        }

        curr = head;
        while (curr != null) {
            if (curr.next != null)
                curr.next.arb = (curr.arb != null) ? curr.arb.next : curr.arb;
            curr = curr.next.next;
        }

        Node org = head;
        Node dup = head.next;
        head = dup;

        while (org.next != null && dup.next != null ) {
            org.next = org.next.next;
            org = org.next;
            dup.next = dup.next.next;
            dup = dup.next;
        }

        return head;
    }

    static boolean check(Node head, Node duplicate) {
        if (head == null || duplicate == null)
            return false;
        Node p1 = head, p2 = duplicate;
        while (p1 != null && p2 != null) {
            if (p1.data != p2.data && p1.arb.data != p2.arb.data) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    static void traverseLinkedList(Node head) {
        Node ptr = head;
        while (ptr != null) {
            System.out.println(ptr.data + ": " + ptr.arb.data);
            ptr = ptr.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head.arb = head.next.next;
        head.next.arb = head;
        head.next.next.arb = head.next.next;
        head.next.next.next.arb = head.next;

        traverseLinkedList(head);

        Node duplicate = copyList(head);
        System.out.println("duplicate list: ");

        System.out.println(check(head, duplicate));
        traverseLinkedList(duplicate);
    }
}
