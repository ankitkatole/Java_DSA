import java.util.*;

public class Graph2 {
    static class Edge {
        int src, dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                bfs_UTIL(graph, visited);
            }
        }
    }

    public static void bfs_UTIL(ArrayList<Edge>[] graph, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

        q.add(0); // Start BFS from vertex 0

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));

    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int parent) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            } else if (e.dest != parent) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBipartile(ArrayList<Edge>[] graph) {
        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (col[e.dest] == -1) {
                            col[e.dest] = 1 - col[curr];
                            q.add(e.dest);
                        } else if (col[e.dest] == col[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isCycleDir(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        boolean Stack[] = new boolean[graph.length];
        for(int i = 0;i<graph.length;i++){
            if(!vis[i]){
                if(isCycleDirUtil(graph,vis,Stack,i)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleDirUtil(ArrayList<Edge>[] graph, boolean[] vis,boolean[] stack,int curr){
        vis[curr] = true;
        stack[curr] = true;
        for(int i =0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!vis[e.dest] && isCycleDirUtil(graph,vis,stack,e.dest)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void topSort(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<graph.length;i++){
            if(!vis[i]){
                topSortUtil(graph,vis,st,i);
            }
        }
        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, boolean[] vis, Stack<Integer> st, int curr){
        vis[curr] = true;
        for(int i = 0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topSortUtil(graph,vis,st,e.dest);
            }
        }
        st.push(curr);
    }

    public static void main(String[] args) {

        int V = 6; // Number of vertices
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println("Cycle Detection: " + detectCycle(graph));
        System.out.println("Bipartite Check: " + isBipartile(graph));
        System.out.println("Directed Cycle Detection: " + isCycleDir(graph));
        System.out.println("Topological Sort: ");
        topSort(graph);
        System.out.println();
    }
}
