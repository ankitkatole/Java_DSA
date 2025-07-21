import java.lang.ProcessHandle.Info;
import java.lang.reflect.Array;
import java.util.*;
public class CheapestFlights {
    //Cheapest Flights within K Stops
    //There are n cities connected by some number of flights. 
    //You are given an array flights where flights[i] = [from, to, price] indicates that there is a flight from city from to city to with cost price.
    //You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
    //If there is no such route, return -1.
    //Assume all prices are positive integers.

    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

    }   
    
    public static void createGraph(int flights[][],ArrayList<Edge> graph[]){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<flights.length; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];
            graph[u].add(new Edge(u, v, wt));
        }

    }

    static class Info{
        int v;
        int cost;
        int stops;
        public Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public static int cheapestFlight(int src,int dest, int k,int n, int flights[][]){
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);
        int dist[] = new int[n];
        for(int i = 0; i<n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0; 
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stops > k) continue; // If stops exceed k, skip this path

            for(int i = 0; i<graph[curr.v].size();i++){
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v] && curr.stops <= k) {
                    dist[v] = dist[u] + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }
        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }

    public static void main(String[] args) {
        int n = 4;
        int flights[][] = {{0,1,100}, {1,2,100},{1,3,600},{2,3,200},{2,0,100}};
        int src = 0, dest = 3, k = 1;
        int result = cheapestFlight(src, dest, k, n, flights);
        if(result == -1) {
            System.out.println("No route found within " + k + " stops.");
        } else {
            System.out.println("The cheapest price from " + src + " to " + dest + " with at most " + k + " stops is: " + result);
        }
    }
     
}
