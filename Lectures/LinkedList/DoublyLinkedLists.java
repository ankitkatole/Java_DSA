public class DoublyLinkedLists {
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
           Node newNode = new Node(data); 
           if (head == null) {
               head = tail = newNode;
           } else {
               head.prev = newNode;
               newNode.next = head;
               head = newNode;
           }
           size++;
       }

    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "<-->");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        DoublyLinkedLists dll = new DoublyLinkedLists();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addFirst(4);
        dll.addFirst(5);
        dll.printList();
        dll.reverse();
        dll.printList();
    }
}
