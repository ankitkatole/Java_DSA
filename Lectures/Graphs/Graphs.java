import java.util.*;

public class Graphs {
    static class Edge {
        int src, dest, weight;
        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        q.add(0); // Start BFS from vertex 0
        
        while(!q.isEmpty()){
            int curr = q.poll();
            if(!visited[curr]){
                System.out.print(curr + " ");
                visited[curr] = true;
                for(int i = 0; i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                        q.add(e.dest);
                }          
            }
        }
    }

    // DFS Traversal
    public static void dfs(ArrayList<Edge>[] graph,boolean[] visited, int curr){
        visited[curr] = true;
        System.out.print(curr + " ");
        for(int i = 0; i< graph[curr].size();i++){
            // Get the edge
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph, visited, e.dest);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, boolean[] visited, int src, int dest){
        if(src == dest){
            return true;
        }
        visited[src] = true;
        for(int i = 0; i< graph[src].size();i++){
            Edge e = graph[src].get(i);
            if(!visited[e.dest] && hasPath(graph, visited, e.dest, dest)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 7; // Number of vertices
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));

        System.out.println("BFS Traversal:");
        bfs(graph);
        System.out.println();
        boolean[] visited = new boolean[V];
        System.out.println("DFS Traversal:");
        dfs(graph, visited, 0);
        System.out.println();
        System.out.println("Has Path Problem:");
        // Check if there is a path from 0 to 5 
        System.out.println("Path from 0 to 5: " + hasPath(graph, new boolean[V], 0, 5));
    }
}
