import java.util.*;

public class Assignment {
    public static void NBinraries(int n) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            int num = 0;
            int j = 0;
            int temp = i;
            while (temp != 0) {
                int rem = temp % 2;
                num += rem * Math.pow(10, j);
                temp = temp / 2;
                j++;
            }
            q.add(num);
        }
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
            if (q.isEmpty()) {
                System.out.println();
            }
        }
    }

    public static void generatePrintBinary(int n) {
        Queue<String> q = new LinkedList<String>();
        q.add("1");
        while (n-- > 0) {
            String s1 = q.peek();
            q.remove();
            System.out.println(s1);
            String s2 = s1;
            q.add(s1 + "0");
            q.add(s2 + "1");
        }
    }

    public static int NRopesMinCost(int n, int arr[]) {
        Arrays.sort(arr);
        int cost = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.add(arr[i]);
        }
        while (q.size() > 1) {
            int first = q.remove();
            int second = q.remove();
            int sum = first + second;
            cost += sum;
            q.add(sum);
        }
        return cost;
    }

    static class Job {
        String jobID;
        int deadline;
        int profit;

        public Job(String jobID, int deadline, int profit) {
            this.jobID = jobID;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static List<Character> jobSchedulingWithDeaddline(List<Job> jobs, int n) {
        Collections.sort(jobs, new Comparator<Job>() { 
            @Override 
            public int compare(Job j1, Job j2) { 
                return j2.profit - j1.profit;
        } });
        
        return null;

    }

    public static void reverseKElements(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<>();
        int n = q.size();
        for (int i = 0; i < k; i++) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        for (int i = 0; i < n - k; i++) {
            q.add(q.remove());
        }
    }
    public static void main(String[] args) {
        // NBinraries(10);
        // generatePrintBinary(10);
        // int arr[] = { 4, 3, 2, 6 };
        // System.out.println(NRopesMinCost(4, arr));

        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter the number of jobs:"); 
        int n = sc.nextInt(); 
        sc.nextLine(); 
        List<Job> jobs = new ArrayList<>();
        System.out.println("Enter job details (JobID Deadline Profit):"); 
        for (int i = 0; i < n; i++) { 
            String jobID = sc.next(); 
            int deadline = sc.nextInt(); 
            int profit = sc.nextInt(); 
            jobs.add(new Job(jobID, deadline, profit)); 
        }
    }
}
