import java.lang.reflect.Array;
import java.util.*;

public class Problems {
    /*
     * Problem 1: Nearby Cars
     * We are N points in a 2D plane which are locations of N cars. If we are at the
     * origin (0, 0), find the K closest cars to us.
     */
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distance;
        int idx;
        Point(int x, int y,int i) {
            this.x = x;
            this.y = y;
            this.distance = x * x + y * y;
            this.idx = i;
        }

        @Override
        public int compareTo(Point o) {
            return this.distance - o.distance;
        }
    }

    /*
     Problem 2: 
     Connect N Ropes: Given are the N ropes of different length, the task is to connect these roppes into one rope with minimum cost, 
     such that the cost to connect two ropes is equl to the sum od their lengths. Find the minimum cost to connect all the ropes.
     */

    /*
     Problem 3: Weakest Soldier
     We are given an mxn binary matrix of 1's (soldiers) and O's (civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the O's in each row. 
    A row i is weaker than a row j if one of the following is true: 
    • The number of soldiers in row i is less than the number of soldiers in row j. 
    • Both rows have the same number of soldiers and i < j. 
    Find the K weakest rows.
     */
    static class Row implements Comparable<Row>{
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2){
            if(this.soldiers == r2.soldiers){
                return this.idx - r2.idx;
            }
            return this.soldiers - r2.soldiers; 
        }
    }

    //Problem 4: Sliding Window Maximum Maximum of all subarrays of size K
    public static void main(String[] args) {
        //Problem 1: Nearby Cars
        System.out.println("Problem 1: K Closest Cars");
        int pts[][] = { { 3, 3 }, { -5, -1 }, { -2, 4 } };
        int k = 2;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < pts.length; i++) {
            Point p = new Point(pts[i][0], pts[i][1],i);
            pq.add(p);
        }
        
        for (int i = 0; i < k; i++) {
            System.out.println("C" + pq.remove().idx);
        }
        System.out.println("-------------------");

        //Problem 2: Connect N Ropes
        System.out.println("Problem 2: Connect N Ropes");
        int ropes[] = {2,3,3,4,6};
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            pq2.add(ropes[i]);
        }
        int cost = 0;
        while (pq2.size() > 1) {
            int a = pq2.remove();
            int b = pq2.remove();
            cost += a + b;
            pq2.add(a + b);
        }
        System.out.println("Minimum Cost: "+cost); 
        System.out.println("-------------------");       
        System.out.println("Problem 3: Weakest Soldier");
        int army[][] ={{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k3 = 2;
        PriorityQueue<Row> pq3 = new PriorityQueue<>();
        for(int i = 0;i<army.length;i++){
            int countSoldiers = 0;
            for(int j = 0;j<army[i].length;j++){
                countSoldiers += army[i][j];
            }
            pq3.add(new Row(countSoldiers,i));
        }

        System.out.format("%d Weakest Soldiers\n",k3);
        for(int i = 0;i<k3;i++){
            System.out.println("R"+pq3.remove().idx);
        }
        System.out.println("-------------------");
        System.out.println("Problem 4: Sliding Window Maximum");
        int arr2[] = {1,3,-1,-3,5,3,6,7};
        int k4 = 3;
        PriorityQueue<Integer> pq4 = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0;i<k4;i++){
            pq4.add(arr2[i]);
        }
        res.add(pq4.peek());
        for(int i = k4;i<arr2.length;i++){
            pq4.remove(arr2[i-k4]);
            pq4.add(arr2[i]);
            res.add(pq4.peek());
        }
        System.out.println("Maximum of all subarrays of size K");
        System.out.println(res);
        System.out.println("-------------------");
    }
}