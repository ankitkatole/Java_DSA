import java.util.*;
public class Stacks{

    static class StackA{
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size() == 0;
        }

        public static void push(int data){
            list.add(data);
        }

        public static int pop(){
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        public static int peek(){
            return list.get(list.size()-1);
        }
    }
    
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class StackL{
        static Node head = null;
        public static boolean isEmpty(){
            return (head == null);
        }
        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int val = head.data;
            head = head.next;
            return val;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }

    
    public static String reverseString(String s){
        Stack<Character> c = new Stack<>();
        for(int i = 0; i<s.length();i++){
            c.push(s.charAt(i));
        }
        String res = "";
        while(!c.isEmpty()){
            res += c.pop();
        }
        return res;
    }
    
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s,top);
    }
     
    public static void pushAtBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void stockSpan(int stocks[],int span[]){
        Stack<Integer> s =new Stack<>();
        span[0] = 1;
        s.push(0);
        for(int i = 1;i<stocks.length;i++){
            int curr = stocks[i];
            while(!(s.isEmpty()) && curr > stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }else{
                span[i] = i-s.peek();
            }
            s.push(i);
        }
    }

    public static void nextGreater(int arr[],int res[]){
        Stack<Integer> s = new Stack<>();
            res[arr.length -1] = -1;
            s.push(arr[arr.length-1]);
        for(int i = arr.length-2;i>=0;i--){
            while(!(s.isEmpty()) && arr[i] >= s.peek()){
                s.pop();
            }
            if(s.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = s.peek();
            }
            s.push(arr[i]);
        }
    }

    public static boolean validParenthesis(String s){
        if(s.length()%2 != 0){
            return false;
        }
        Stack<Character> st = new Stack<>();

        for(int i = 0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                if((st.peek() == '(' && ch == ')') || (st.peek() == '{' && ch == '}') || (st.peek() == '[' && ch == ']')){
                    st.pop();
                }else{
                    return false;
                }
            }
        }

        if(st.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static boolean duplicateParenthesis(String str){
        Stack<Character> s = new Stack<>();
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch != ')'){
                s.push(ch);
            }else{
                if(s.peek() == '('){
                    return true;
                }else{
                    while(s.peek() != '('){
                        s.pop();
                    }
                    s.pop();
                }
            }
        }
        return false;
    }

    public static void maxArea(int arr[]){
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length-1;i>=0;i--){
            while((!s.isEmpty()) && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        s = new Stack<>();
        for(int i = 0;i<arr.length;i++){
            while((!s.isEmpty()) && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        for(int i= 0; i<arr.length;i++){
            int h = arr[i];
            int w = nsr[i]-nsl[i]-1;
            maxArea = Math.max(maxArea, h*w);
        }
        System.out.println("Maximum area is "+maxArea);
    }

    public static int largestRectangleArea(int[] heights) {
        int max = 0;
        int nsl[] = new int[heights.length];
        int nsr[] = new int[heights.length];
        Stack<Integer> s = new Stack<>();

        for(int i = 0;i<heights.length;i++){
            while((!s.isEmpty()) && (heights[s.peek()] >= heights[i])){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        s = new Stack<>();
        for(int i = heights.length-1;i>=0;i--){
            while((!s.isEmpty()) && (heights[s.peek()]  >= heights[i])){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = heights.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        for(int i = 0;i<heights.length;i++){
            int h = heights[i];
            int w = nsr[i]-nsl[i]-1;
            max = Math.max(max,h*w);
        }
        return max;
    }
    public static void main(String[] args) {
        // StackL s = new StackL();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        //By java collection framework
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        pushAtBottom(st,4);
        // while(!st.isEmpty()){
        //     System.out.println(st.peek());
        //     st.pop();
        // }
        // String i = "Hello";
        // System.out.println(reverseString(i));
        // System.out.println(st);
        // reverseStack(st);
        // System.out.println(st);
        int stocks[] = {100,80,60,70,60,85,100};
        int span[] = new int[stocks.length];
        stockSpan(stocks,span);
        // for(int i = 0;i<span.length;i++){
        //     System.out.print(span[i]+" ");
        // }
        int arr[] = {5, 7, 2, 8, 10, 1, 6, 4, 3, 12, 14, 0, 9, 11, 13, 17, 15, 20, 18, 19, 16, 25, 22, 21, 30, 24, 28, 27, 23, 29, 35, 31, 34, 33, 32, 38, 36, 37, 40, 39, 45, 41, 44, 43, 42, 50, 46, 48, 47, 49};
        int res[] = new int[arr.length];
        nextGreater(arr, res);
        for(int i = 0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
        System.out.println(validParenthesis("({[}])[]"));
        System.out.println(duplicateParenthesis("((a+b)+(c+d))"));

        int height[] = {2,1,5,6,2,3};
        maxArea(height);
        System.out.println(largestRectangleArea(height));
    }
}