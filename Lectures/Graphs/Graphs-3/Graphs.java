import java.util.*;

public class Graphs {
    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,3));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));

    }

    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]){
        for(int i = 0;i<graph.length; i++){
            for(int j = 0; j < graph[i].size(); j++){
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[]){
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indeg.length; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr + " ");
            for(int i = 0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    //Exponential time complexity
    public static void allPaths(ArrayList<Edge> graph[], int src, int dest, String path){
        if(src== dest){
            System.out.println(path+dest);
            return;
        }
        for(int i = 0; i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            allPaths(graph,e.dest,dest,path+src+" ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[6];
        createGraph(graph);
        System.out.println("Topological Sort of the graph is: ");
        topSort(graph);
        System.out.println("----------------------");
        System.out.println("All paths from 5 to 1 are: ");
        
        allPaths(graph, 5, 1, "");
        System.out.println("----------------------");
    }
}
