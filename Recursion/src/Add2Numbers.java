// You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order, and each of their nodes contains a single digit.
// Add the two numbers and return the sum as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.

public class Add2Numbers {
      static class ListNode {
          int val;
          ListNode next;
//          ListNode() {}
          ListNode(int val) { this.val = val; }
//          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    static int carry = 0;

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum;
        if (l1 == null && l2 == null) {
            if (carry != 0)
                return new ListNode(carry);
            return null;
        }

        if (l1 == null)
            sum = carry + l2.val;
        else if (l2 == null)
            sum = carry + l1.val;
        else
            sum = carry + l1.val + l2.val;

        if (sum >= 10) {
            carry = 1;
            sum = sum - 10;
        } else
            carry = 0;

        ListNode head = new ListNode(sum);

        if (l1 == null)
            head.next = addTwoNumbers(null, l2.next);
        else if (l2 == null)
            head.next = addTwoNumbers(l1.next, null);
        else
            head.next = addTwoNumbers(l1.next, l2.next);

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);

        ListNode head = addTwoNumbers(l1, l2);

        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
