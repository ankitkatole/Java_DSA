import java.util.*;

public class Questions {
    /*
     * Question 1: K’th largest element in a stream
     * We have an infinite stream of integers, find the k’th largest element at any
     * point of time.
     * Input : stream[] = {10, 20, 11, 70, 50, 40, 100, 5, ...} k = 3
     * Output : {_, _, 10, 11, 20, 40, 50, 50, ...}
     */
    public static void kThLargestElement(int k) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> arr = new ArrayList<>();
        while (true) {
            int x = sc.nextInt();
            arr.add(x);
            System.out.println(arr);
            if (x == -1) {
                break;
            }
            if (pq.size() < k) {
                pq.add(x);
                if (pq.size() == k) {
                    System.out.println(pq.peek());
                } else {
                    System.out.println("X");
                }
            } else {
                if (pq.peek() < x) {
                    pq.poll();
                    pq.add(x);
                }
                System.out.println(pq.peek());
            }
        }
    }

    /*
     * Question 2: K’th smallest element in a streamQuestion 2 :
     * Minimum time required to fill given N slots
     * We have an integer N which denotes the number of slots, and an array arr[]
     * consisting of K
     * integers in the range [1, N] repreand. Each element of the array are in the
     * range [1, N] which
     * represents the indices of the filled slots. At each unit of time, the index
     * with filled slot fills the
     * adjacent empty slots. The task is to find the minimum time taken to fill all
     * the N slots..
     * Sample Input 1 : N = 5, K = 5, arr[] = {1, 2, 3, 4, 5}
     * Sample Output 1 : 1
     * Sample Input 1 : N = 6, K = 2, arr[] = {2, 6}
     * Sample Output 1 : 2
     */
    public static int minTimeToFillSlots(int N, int K, int arr[]) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> currFilled = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            visited[arr[i]] = true;
            currFilled.add(arr[i]);
        }
        int time = 0;
        while (!currFilled.isEmpty()) {
            int size = currFilled.size();
            Queue<Integer> nextFilled = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                int curr = currFilled.poll();
                if (curr - 1 >= 1 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    nextFilled.add(curr - 1);
                }
                if (curr + 1 <= N && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    nextFilled.add(curr + 1);
                }
            }
            currFilled = nextFilled;
            if (!currFilled.isEmpty())
                time++;
        }
        return time;
    }
    // public static int minTimeToFillSlots(int N,int K,int arr[]){
    // PriorityQueue<Integer> pq = new PriorityQueue<>();
    // int time = 0;
    // boolean visited[] = new boolean[N+1];
    // for(int i=0;i<K;i++){
    // pq.add(arr[i]);
    // visited[arr[i]] = true;
    // }
    // while(pq.size() > 0){
    // int size = pq.size();
    // for(int i = 0; i < size; i++){
    // int curr = pq.poll();
    // if(curr-1 >= 1 && !visited[curr-1]){
    // visited[curr-1] = true;
    // pq.add(curr-1);
    // }
    // if(curr+1 <= N && !visited[curr+1]){
    // visited[curr+1] = true;
    // pq.add(curr+1);
    // }
    // }
    // time++;
    // }
    // return time-1;
    // }

    // Minimum Operations to Halve Array Sum
    // We have an array Arr[], the task is to find out the minimum number of
    // operations to make the
    // sum of array elements lesser or equal to half of its initial value. In one
    // such operation, it is
    // allowed to half the value of any array element.
    // Sample Input 1 : [1, 5, 8, 19]
    // Sample Output 1 : 3

    public static int minOps(int ar[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        for(int ele : ar){
            sum += ele;
            pq.add(ele);
        }
        int count = 0;
        int tempSum = sum;
        while(tempSum > sum/2){
            int ele = pq.poll();
            tempSum -= ele;
            pq.add(ele/2);
            tempSum += ele/2;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        // Kth Largest Element in a Stream: Question 1
        // kThLargestElement(2);

        // Minimum time required to fill given N slots: Question 2
        int N = 6;
        int K = 2;
        int arr[] = { 2, 6 };
        System.out.println(minTimeToFillSlots(N, K, arr));

        // Minimum Operations to Halve Array Sum
        int ar[] = {1, 5, 8, 19};
        System.out.println(minOps(ar));

        
    }
}