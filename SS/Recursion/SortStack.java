

import java.util.Stack;
/*
    You are given a stack of integers. Your task is to sort the 
    stack in descending order using recursion, such that the top of the 
    stack contains the greatest element. You are not allowed to use any loop-based
    sorting methods (e.g., quicksort, mergesort). You may only use recursive operations 
    and the standard stack operations (push, pop, peek/top, and isEmpty).
Example 1
Input: stack = [4, 1, 3, 2]
Output: [4, 3, 2, 1]
Explanation:
After sorting, the largest element (4) is at the top, and the smallest (1) is at the bottom.

Example 2
Input: stack = [1]
Output: [1]
Explanation:
A single-element stack is already sorted.

Constraints
1 <= N <= 100 (where N is the number of elements in the stack)
Use recursion to implement the sorting logic.
You may use auxiliary space up to O(N) (call stack).
*/

public class SortStack {
    public static void insert(Stack<Integer> st, int temp){
        if(st.isEmpty() || st.peek()<=temp){
            st.push(temp);
            return;
        }
        int i = st.pop();
        insert(st,temp);
        st.push(i);
    }
    public static void sortStack(Stack<Integer> st) {
        if(!st.isEmpty()){
            int temp = st.pop();
            sortStack(st);
            insert(st,temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        // Testcase 1: random order
        st.push(3);
        st.push(1);
        st.push(4);
        st.push(2);
        System.out.println("Original st: " + st);
        sortStack(st);
        System.out.println("Sorted st:   " + st);

        // Testcase 2: single element
        Stack<Integer> s2 = new Stack<>();
        s2.push(5);
        System.out.println("\nOriginal s2: " + s2);
        sortStack(s2);
        System.out.println("Sorted s2:   " + s2);

        // Testcase 3: reversed order
        Stack<Integer> s3 = new Stack<>();
        s3.push(5);
        s3.push(4);
        s3.push(3);
        s3.push(2);
        s3.push(1);
        System.out.println("\nOriginal s3: " + s3);
        sortStack(s3);
        System.out.println("Sorted s3:   " + s3);
    }
}
