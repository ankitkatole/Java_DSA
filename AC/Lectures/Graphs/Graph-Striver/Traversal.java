import java.util.*;

public class Traversal {
    public static List<Integer> BFSTraversal(List<List<Integer>> li, int source) {
        int size = li.size();
        boolean vis[] = new boolean[size];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        q.add(source);
        vis[source] = true;
        while (!q.isEmpty()) {
            int i = q.poll();
            res.add(i);
            for (int j = 0; j < li.get(i).size(); j++) {
                int node = li.get(i).get(j);
                if (!vis[node]) {
                    vis[node] = true;
                    q.add(node);
                }
            }
        }
        return res;
    }

    public static void DFStraversal(List<List<Integer>> li, List<Integer> res, boolean[] vis, int node) {
        vis[node] = true;
        res.add(node);
        for (int i : li.get(node)) {
            if (!vis[i]) {
                DFStraversal(li, res, vis, i);
            }
        }
    }

    public static void main(String[] args) {
        int n = 9; // number of nodes
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
        graph.get(0).add(1);
        graph.get(0).add(5);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(2).add(1);
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(4).add(3);
        graph.get(4).add(7);
        graph.get(5).add(0);
        graph.get(5).add(6);
        graph.get(5).add(8);
        graph.get(6).add(5);
        graph.get(6).add(7);
        graph.get(7).add(6);
        graph.get(7).add(5);
        graph.get(8).add(5);

        List<Integer> result = BFSTraversal(graph, 0);
        System.out.println("BFS Traversal: " + result);

        int n2 = 8;
        List<List<Integer>> l2 = new ArrayList<>();
        for (int i = 0; i < n2; i++)
            l2.add(new ArrayList<>());

        // Add edges for l2 graph
        l2.get(0).add(1);
        l2.get(0).add(2);
        l2.get(1).add(0);
        l2.get(1).add(4);
        l2.get(1).add(5);
        l2.get(2).add(0);
        l2.get(2).add(3);
        l2.get(2).add(6);
        l2.get(3).add(2);
        l2.get(3).add(7);
        l2.get(4).add(1);
        l2.get(5).add(1);
        l2.get(6).add(2);
        l2.get(6).add(7);
        l2.get(7).add(6);
        l2.get(7).add(3);
        boolean[] vis2 = new boolean[n2];
        List<Integer> dfsResult = new ArrayList<>();
        DFStraversal(l2, dfsResult, vis2, 2);
        System.out.println("DFS Traversal: " + dfsResult);

    }
}