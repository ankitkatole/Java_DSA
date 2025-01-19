import java.util.*;

public class Queues {
    static class Queue1 {
        static int arr[];
        static int size;
        static int rear;
        static int front = 0;

        Queue1(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            System.out.println("Queue created with size " + n);
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

    }

    static class CircularQueue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        CircularQueue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
            System.out.println("Circular Queue created with size " + n);
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int result = arr[front];

            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class QueueLL{
        static Node head = null;
        static Node tail = null;
        QueueLL(){
            System.out.println("Queue created with Linked List");

            
        }
        public static boolean isEmpty(){
            return head == null && tail == null;
        }
        public static void add(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = tail = newNode;
                return;
        }
        tail.next = newNode;
        tail = newNode;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int result = head.data;
            if(tail == head){
                head = tail = null;
            }else{
                head = head.next;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Queue1 q = new Queue1(5);
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
        CircularQueue cq = new CircularQueue(5);
        cq.add(10);
        cq.add(20);
        cq.add(30);
        cq.add(40);
        cq.add(50);
        // System.out.println(cq.remove());
        cq.remove();
        cq.add(60);
        while (!cq.isEmpty()) {
            System.out.println(cq.remove());
        }

        QueueLL qll = new QueueLL();
        qll.add(10);
        qll.add(20);
        qll.add(30);
        qll.add(40);
        qll.add(50);
        while(!qll.isEmpty()){
            System.out.println(qll.remove());
        }

        Queue<Integer> ql = new LinkedList<>();
        ql.add(1);
        ql.add(2);
        ql.add(3);
        while(!ql.isEmpty()){
            System.out.println(ql.remove());
        }
    }
}