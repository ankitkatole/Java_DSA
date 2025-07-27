import java.util.*;

public class KruskalsAlgorithm {
    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    public static int find(int x) {
        if (par[x] != x) {
            par[x] = find(par[x]); // Path compression
        }
        return par[x];
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (parA == parB)
            return;

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] > rank[parB]) {
            par[parB] = parA;
        } else {
            par[parA] = parB;
        }

    }

    static class Edge implements Comparable<Edge> {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }
    static void createGraph(ArrayList<Edge> edges){
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(0,3,30));
        edges.add(new Edge(1,3,40));
        edges.add(new Edge(2,3,50));
    }

    public static void kruskalAlgorithmMST(ArrayList<Edge> edges, int V){
        init();
        Collections.sort(edges);
        int mstCost = 0;
        int count = 0;
        for(int i = 0; count< V-1;i++){
            Edge e = edges.get(i);
            int parA = find(e.u);
            int parB = find(e.v);
            if(parA != parB) {
                union(e.u, e.v);
                mstCost += e.weight;
                count++;
                System.out.println("Edge: " + e.u + " - " + e.v + " with weight: " + e.weight);
            }
        }
        System.out.println("Total cost of MST: " + mstCost);
    } 
    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskalAlgorithmMST(edges, n);
    }
}
