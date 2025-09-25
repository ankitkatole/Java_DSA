import java.util.*;

public class TopologicalSortKahn {
    private int vertices;
    private List<List<Integer>> adjList;
    private int[] inDegree;

    public TopologicalSortKahn(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        inDegree = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        inDegree[dest]++;
    }

    public void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> topoOrder = new ArrayList<>();

        // Enqueue nodes with in-degree 0
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            topoOrder.add(u);

            for (int v : adjList.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if (topoOrder.size() != vertices) {
            System.out.println("Graph has a cycle, topological sort not possible.");
        } else {
            System.out.println("Topological Sort Order: " + topoOrder);
        }
    }

    public static void main(String[] args) {
        TopologicalSortKahn graph = new TopologicalSortKahn(6);

        // Add edges from your example graph
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        graph.topologicalSort();
    }
}
