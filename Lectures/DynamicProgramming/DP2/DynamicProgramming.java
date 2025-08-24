public class DynamicProgramming {

    //0-1 Knapsack Problem
    public static int knapsack(int val[], int weight[], int W, int i) {
        if (W == 0 || i == 0) {
            return 0;
        }

        if(weight[i-1] <= W){
            int ans1 = val[i-1] + knapsack(val, weight, W - weight[i-1], i-1); //include
            int ans2 = knapsack(val, weight, W, i-1); //exclude 
            return Math.max(ans1, ans2);
        }else{
            return knapsack(val, weight, W, i-1);
        }         
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int weight[] = {2,5,1,3,4};
        int W = 7;
        System.out.println(knapsack(val, weight, W, val.length ));
    }   
}
