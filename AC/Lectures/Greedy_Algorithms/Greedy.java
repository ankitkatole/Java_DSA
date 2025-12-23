import java.util.*;

public class Greedy{

    // Activity Selection Problem
    public static void activitySelection(int start[], int end[]) {
        int maxActivities = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        maxActivities++;
        ans.add(0);

        int lastEnd = end[0];
        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                maxActivities++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println("Maximum activities: " + maxActivities);
    }

    // Fractional Knapsack problem
    public static int fractionalKnapsack(int W, int wt[], int val[]) {
        double ratio[][] = new double[val.length][2];
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = (double) val[i] / wt[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int result = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            if (capacity >= wt[(int) ratio[i][0]]) {
                result += val[(int) ratio[i][0]];
                capacity -= wt[(int) ratio[i][0]];
            } else {
                result += (capacity * ratio[i][1]);
                capacity = 0;
                break;
            }
        }
        return result;
    }

    //Minimum Absolute Difference problem
    public static int minAboluteDiff(int a[],int b[]){
        Arrays.sort(a);
        Arrays.sort(b);
        int minDifferece = 0;
        for(int i=0;i<a.length;i++){
            minDifferece += Math.abs(a[i]-b[i]);
        }
        return minDifferece;
    }

    //Maximum Length Pairs problem
    public static int maxLengthPairs(int arr[][]){
        Arrays.sort(arr,Comparator.comparingInt(o->o[1]));
        int count = 1;
        int lastEnd = arr[0][1];
        for(int i=1;i<arr.length;i++){
            if(arr[i][0]>=lastEnd){
                count++;
                lastEnd = arr[i][1];
            }
        }
        return count;
    }

    //Indian Coins Problem
    public static int indianCoins(int coins[], int val){
        Arrays.sort(coins);
        int count = 0;
        for(int i=coins.length-1;i>=0;i--){
            while(val>=coins[i]){
                val -= coins[i];
                count++;
            }
            if(val == 0){
                break;
            }
        }
        return count;
    }
    
    //Job Sequencing Problem
    static class Job{
        int id;
        int deadline;
        int profit;
        public Job(int id, int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    public static void jobSequencing(int job[][], int n){
        ArrayList<Job> jobs = new ArrayList<>();
        for(int i=0;i<n;i++){
            jobs.add(new Job(i,job[i][0],job[i][1]));
        }

        Collections.sort(jobs, (a,b)->b.profit-a.profit);
        //Descending Order profit

        ArrayList<Integer> result = new ArrayList<>();
        int time = 0;
        for(int i=0;i<jobs.size();i++){
            if(jobs.get(i).deadline>time){
                result.add(jobs.get(i).id);
                time++;
            }
        }
        System.out.println(result);
    }

    //Chocolate Distribution Problem
    public static int chocolaProblem(int costVer[], int costHor[]) {
        // Convert int[] to Integer[]
        Integer[] costVerInteger = Arrays.stream(costVer).boxed().toArray(Integer[]::new);
        Integer[] costHorInteger = Arrays.stream(costHor).boxed().toArray(Integer[]::new);

        // Sort using a Comparator for descending order
        Arrays.sort(costVerInteger, Comparator.reverseOrder());
        Arrays.sort(costHorInteger, Comparator.reverseOrder());

        int h = 0, v = 0, hp = 1, vp = 1, cost = 0;

        while (h < costHorInteger.length && v < costVerInteger.length) {
            if (costHorInteger[h] >= costVerInteger[v]) {
                // Horizontal cut
                cost += costHorInteger[h] * vp;
                hp++;
                h++;
            } else {
                // Vertical cut
                cost += costVerInteger[v] * hp;
                vp++;
                v++;
            }
        }

        while (h < costHorInteger.length) {
            cost += costHorInteger[h] * vp;
            hp++;
            h++;
        }

        while (v < costVerInteger.length) {
            cost += costVerInteger[v] * hp;
            vp++;
            v++;
        }

        return cost;
    }
    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };
        activitySelection(start, end);

        int W = 50;
        int wt[] = { 10, 20, 30 };
        int val[] = { 60, 100, 120 };
        System.out.println("Maximum profit: " + fractionalKnapsack(W, wt, val));

        int a[] = {4,1,8,7};
        int b[] = {2,3,6,5};
        System.out.println("Minimum Absolute Difference: "+ minAboluteDiff(a,b));
        
        int arr[][] = {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}};
        System.out.println("Maximum Length Pairs: "+ maxLengthPairs(arr));

        int coins[] = {1,2,5,10,20,50,100,200,500,2000};
        System.out.println("Indian Coins: "+ indianCoins(coins, 590));
        
        int jobsInfo[][] = {{4,20},{1,10},{1,40},{1,30}};

        System.out.println("Job Sequencing: ");
        jobSequencing(jobsInfo, jobsInfo.length);

        int costVer[] = {2,1,3,1,4};
        int costHor[] = {4,1,2};
        System.out.println("Chocolate Distribution: "+ chocolaProblem(costVer, costHor));
    }
}
