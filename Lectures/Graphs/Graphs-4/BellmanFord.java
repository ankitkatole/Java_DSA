import java.util.*;

public class BellmanFord {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    static void createGraph2(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // Creating a different graph with 6 vertices (0-5)
        graph[0].add(new Edge(0, 1, 4));
        graph[0].add(new Edge(0, 2, 2));
        
        graph[1].add(new Edge(1, 3, 3));
        graph[1].add(new Edge(1, 4, 2));
        
        graph[2].add(new Edge(2, 1, -1));
        graph[2].add(new Edge(2, 4, 4));
        
        graph[3].add(new Edge(3, 5, 2));
        
        graph[4].add(new Edge(4, 3, -3));
        graph[4].add(new Edge(4, 5, 1));
        
        graph[5].add(new Edge(5, 1, 1));
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        // Algorithm
        int V = graph.length;
        for (int i = 0; i < (V - 1); i++) {
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }

            }
        }

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.print("INF ");
            } else {
                System.out.print(dist[i] + " ");
            }
        }
        System.out.println("\n --------------------------");

    }

    public static void bellmanFord2(ArrayList<Edge> edges, int src, int V){
        int dist [] = new int[V];
        for(int i = 0; i < dist.length; i++){
            dist[i] = Integer.MAX_VALUE;    
        }
        dist[src] = 0;
        for(int i = 0; i< (V-1);i++){
            for(int j = 0;j<edges.size();j++){
                Edge e = edges.get(j);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for(int i = 0; i < dist.length; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.print("INF ");
            } else {
                System.out.print(dist[i] + " ");
            }
        }

        System.out.println("\n--------------------------");
    }

    public static void main(String[] args) {
        // Using Adjacency List
        System.out.println("Using Adjacency List:");
        int V = 5; 
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int src = 0; // Starting vertex
        bellmanFord(graph, src);
        V = 6; // Number of vertices for createGraph2
        ArrayList<Edge> graph2[] = new ArrayList[V];
        createGraph2(graph2);
        src = 0; // Starting vertex for graph2
        bellmanFord(graph2, src);

        // Using Edge List
        System.out.println("Using Edge List:");
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, -4));
        edges.add(new Edge(2, 3, 2));
        edges.add(new Edge(3, 4, 4));
        edges.add(new Edge(4, 1, -1));
        V = 5; // Number of vertices for edges
        bellmanFord2(edges, 0,V);
    }
}
