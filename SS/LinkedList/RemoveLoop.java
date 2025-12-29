class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveLoop {

    public static ListNode remove_loop(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (slow != fast) return head;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode ptr = slow;
        while (ptr.next != slow) {
            ptr = ptr.next;
        }

        ptr.next = null;
        return head;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Test case 1: No loop
        ListNode a1 = new ListNode(1);
        a1.next = new ListNode(2);
        a1.next.next = new ListNode(3);

        remove_loop(a1);
        printList(a1);

        System.out.println("----");

        // Test case 2: Loop in middle
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(2);
        ListNode b3 = new ListNode(3);
        ListNode b4 = new ListNode(4);

        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b2; // loop here

        remove_loop(b1);
        printList(b1);

        System.out.println("----");

        // Test case 3: Loop at head
        ListNode c1 = new ListNode(10);
        ListNode c2 = new ListNode(20);
        ListNode c3 = new ListNode(30);

        c1.next = c2;
        c2.next = c3;
        c3.next = c1; // loop to head

        remove_loop(c1);
        printList(c1);

        System.out.println("----");

        // Test case 4: Single node with loop
        ListNode d1 = new ListNode(99);
        d1.next = d1;

        remove_loop(d1);
        printList(d1);
    }
}
