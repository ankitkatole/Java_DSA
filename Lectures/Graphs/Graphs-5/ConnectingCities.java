import java.util.*;

public class ConnectingCities {
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

    public static void createGraph(int cities[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < cities.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < cities[i].length; j++) {
                if (cities[i][j] != 0) {
                    graph[i].add(new Edge(i, j, cities[i][j]));
                }
            }
        }
        System.out.println("Graph created successfully.");
    }

    static class Info implements Comparable<Info> {
        int v;
        int cost;

        public Info(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info other) {
            return this.cost - other.cost;
        }
    }

    public static int findCheapestPath(int src, int cities[][]) {
        int n = cities.length;
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(cities, graph);
        boolean vis[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            vis[i] = false;
        }
        PriorityQueue<Info> pq = new PriorityQueue<>();
        int finalCost = 0;
        pq.add(new Info(src, 0));
        while (!pq.isEmpty()) {
            Info curr = pq.poll();
            if (vis[curr.v])
                continue;
            vis[curr.v] = true;
            finalCost += curr.cost;

            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int v = curr.v;
                int wt = e.wt;
                if (!vis[e.dest]) {
                    pq.add(new Info(e.dest, e.wt));
                }
            }
        }

        for (boolean visited : vis) {
            if (!visited) {
                System.out.println("Not all cities are reachable from the source.");
                return -1;
            }
        }
        return finalCost;
    }

    public static void main(String[] args) {
        int[][][] testCases = {
                // Test Case 1: Fully Connected Graph
                {
                        { 0, 1, 2, 3, 4 },
                        { 1, 0, 5, 0, 7 },
                        { 2, 5, 0, 6, 0 },
                        { 3, 0, 6, 0, 0 },
                        { 4, 7, 0, 0, 0 },
                },

                // Test Case 2: Sparse Graph
                {
                        { 0, 2, 0, 0 },
                        { 2, 0, 3, 0 },
                        { 0, 3, 0, 1 },
                        { 0, 0, 1, 0 },
                },

                // Test Case 3: Disconnected Graph
                {
                        { 0, 2, 0, 0 },
                        { 2, 0, 0, 0 },
                        { 0, 0, 0, 1 },
                        { 0, 0, 1, 0 },
                },

                // Test Case 4: Single Node
                {
                        { 0 }
                },

                // Test Case 5: Two Nodes
                {
                        { 0, 8 },
                        { 8, 0 }
                },

                // Test Case 6: Equal Weights Complete Graph
                {
                        { 0, 1, 1, 1 },
                        { 1, 0, 1, 1 },
                        { 1, 1, 0, 1 },
                        { 1, 1, 1, 0 },
                }
        };

        String[] descriptions = {
                "Fully Connected Graph",
                "Sparse Graph",
                "Disconnected Graph",
                "Single Node Graph",
                "Two Node Graph",
                "Equal Weights Complete Graph"
        };

        int[] expectedResults = {
                10, // MST: 1+2+3+4
                6, // MST: 2+3+1
                -1, // Disconnected
                0, // Only one node
                8, // Only one edge
                3 // MST: 1+1+1
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("--------------------------------------------------");
            System.out.println("Test Case " + (i + 1) + ": " + descriptions[i]);
            int actual = findCheapestPath(0, testCases[i]);
            System.out.println("Expected Cost: " + expectedResults[i]);
            System.out.println("Actual Cost  : " + actual);
            System.out.println(actual == expectedResults[i] ? "✔ Test Passed" : "✘ Test Failed");
            System.out.println();
        }
    }

}
