import java.util.*;
public class LinkedLists{
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node temp = head;
        Node newNode = new Node(data);
        size++;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public void add(int data) {
        int index = size;
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node temp = head;
        Node newNode = new Node(data);
        size++;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LinkedList Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LinkedList Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int i = 0;
        Node temp = head;
        while (i < size - 2) {
            temp = temp.next;
            i++;
        }
        int val = temp.next.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;

    }

    public void printList() {
        if (head == null) {
            System.out.println("Empty LinkedList");
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int helper(Node temp, int key) {
        if (temp == null) {
            return -1;
        }
        if (temp.data == key) {
            return 0;
        }
        int idx = helper(temp.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int search(int key) {
        return helper(head, key);
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Find and remove nth node from end
    public void removeNthNode(int id) {
        if (size == id) {
            head = head.next;
            return;
        }
        int i = 1;
        int n = size - id;
        Node temp = head;
        while (i < n) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        return;
    }

    // To check if linkedList is Palindrome
    public boolean isPalindrome() {
        if(head.next == null || head == null){
            return true;
        }
        Node mid = findMid(head);

        Node prev = null; 
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public Node findMid(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public boolean isCycle(){ //Floys Cycle detection algorithm
        Node slow = head;
        Node fast = head;
        while(fast!=null &&fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        Node prev = null;
        while(fast!=null &&fast.next != null){
            slow = slow.next;
            prev = fast.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        
        if(cycle){
            if(fast == head){
                prev.next = null;
                return;
            }
            slow = head;
            while(slow != fast){
                prev = fast;
                fast = fast.next;
                slow = slow.next;
            }
            prev.next = null;
        }
    }

    public Node mergeSort(Node head) {
            if (head == null || head.next == null) {
                return head;
            }
            Node mid = findMid(head);
            Node rightHead = mid.next;
            mid.next = null;
            Node newLeft = mergeSort(head);
            Node newRight = mergeSort(rightHead);
            return merge(newLeft, newRight);
    }

    public Node merge(Node head1,Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null){
            temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
        }
        return mergedLL.next;
    }

    public void zigZag(){
        //Find Mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //Reverse Second half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right =prev;
        Node nextL, nextR;

        //zigzag conv
        while(left != null && right != null){
            nextL = left.next;
            nextR = right.next;
            left.next = right;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    public static void main(String[] args) {
        LinkedLists ll = new LinkedLists();

        // Adding nodes to the list
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.addFirst(6);

        // Print the original list
        System.out.println("Original List:");
        ll.printList();

        // Sort the list using merge sort
        ll.head = ll.mergeSort(ll.head);

        // Print the sorted list
        System.out.println("Sorted List:");
        ll.printList();
        ll.zigZag();
        ll.printList();

    }
}
