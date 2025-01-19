import java.util.*;

public class Problems {
    static class Queue1 {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        public static void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public static int remove() {
            if (s1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.pop();
        }
    }

    static class Stack1 {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public static int peek(){
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }


    public static void printNonRepeating(String s){
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;
            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print("-1 ");                
            }else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
    }

    public static void interLeave(Queue<Integer> q){
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();
        for(int i = 0;i<size/2;i++){
            firstHalf.add(q.remove());
        }
        while(!firstHalf.isEmpty()){
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
        for(int i = 0;i<size;i++){
            System.out.print(q.remove()+" ");
        }
    }

    public static void queueReversal(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
    public static void main(String[] args) {
        // Queue1 q = new Queue1();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // while (!q.isEmpty()) {
        //     System.out.println(q.remove());
        // }

        // System.out.println("Stack using Queues");
        // Stack1 s = new Stack1();
        // s.push(1);    
        // s.push(2);
        // s.push(3);
        // while (!s.isEmpty()) {
        //     System.out.println(s.pop());
        // }
        // String str = "aabccxb";
        // printNonRepeating(str);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);    
        q.add(6);
        q.add(7);    
        q.add(8);
        q.add(9);
        q.add(10);
        // interLeave(q);
        queueReversal(q);
    }
}
