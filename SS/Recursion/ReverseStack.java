import java.util.Stack;

/*
You are given a stack of integers. Your task is to reverse the stack using recursion.
You may only use standard stack operations (push, pop, top/peek, isEmpty).
You are not allowed to use any loop constructs or additional data structures like 
arrays or queues.



Your solution must modify the input stack in-place to reverse the order of its elements.


Example 1

Input: stack = [4, 1, 3, 2]

Output: [2, 3, 1, 4]

Example 2

Input: stack = [10, 20, -5, 7, 15]

Output: [15, 7, -5, 20, 10]
Constraints

1 <= N <= 100 (where N is the number of elements in the stack)
Must use only recursion (no loops or built-in reverse methods)
Auxiliary space allowed: O(N) (due to recursion stack)
 */

class ReverStack {

    public static void insertAtBottom(Stack<Integer> st, int val){
        if(st.isEmpty()){
            st.push(val);
            return;
        }

        int temp = st.pop();
        insertAtBottom(st, val);
        st.push(temp);
    }

    public static void reverseStack(Stack<Integer> st) {
        if(!st.isEmpty()){
            int val = st.pop();
            reverseStack(st);
            insertAtBottom(st, val);
        }
    }

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        System.out.println("Original Stack: " + st);

        reverseStack(st);

        System.out.println("Reversed Stack: " + st);
    }
}