import java.util.*;
public class DeQue {
    static class StackDQ{
        static Deque<Integer> dq = new LinkedList<>();
        public StackDQ(){
            System.out.println("Stack created via Deque");
        }
        public static void push(int data){
            dq.addLast(data);
        }

        public static int pop(){
            return dq.removeLast();
        }

        public static boolean isEmpty(){
            return dq.isEmpty();
        }

        public static int peek(){
            return dq.peekLast();
        }

        public static void print(){
            System.out.println(dq);
        }
    }

    static class QueueDQ{
        static Deque<Integer> dq = new LinkedList<>();
        public QueueDQ(){
            System.out.println("Queue created via Deque");
        }
        public static void add(int data){
            dq.addLast(data);
        }
        public static int remove(){
            return dq.removeFirst();
        }
        public static boolean isEmpty(){
            return dq.isEmpty();
        }
        public static int peek(){
            return dq.peekFirst();
        }
        public static void print(){
            System.out.println(dq);
        }
    }
    public static void main(String[] args) {
        // Deque<Integer> dq = new LinkedList<>();
        // dq.addFirst(1);
        // dq.addLast(2);
        // dq.addFirst(3);
        // dq.addLast(4);
        // System.out.println(dq);
        // dq.removeFirst();
        // System.out.println(dq);
        // dq.removeLast();
        // System.out.println(dq);

        StackDQ s = new StackDQ();
        s.push(1);
        s.push(2);        
        s.push(3);
        s.print();
        System.out.println(s.pop());
        s.print();
        System.out.println(s.peek());
        s.print();

        QueueDQ q = new QueueDQ();
        q.add(1);
        q.add(2);        
        q.add(3);
        q.print();
        System.out.println(q.remove());
        q.print();
        System.out.println(q.peek());
        q.print();
    }
}
