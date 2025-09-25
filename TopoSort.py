from collections import deque

def kahn_topological_sort(graph, in_degree):
    queue = deque()
    result = []

    # Initialize queue with all nodes having in-degree 0
    for node in range(len(in_degree)):
        if in_degree[node] == 0:
            queue.append(node)

    while queue:
        u = queue.popleft()
        result.append(u)

        # For each neighbor v of u, reduce in-degree, add to queue if zero
        for v in graph[u]:
            in_degree[v] -= 1
            if in_degree[v] == 0:
                queue.append(v)

    if len(result) != len(graph):
        return None  # Cycle detected
    return result

# Define graph adjacency list and in-degree for nodes 0 to 5
graph = {
    0: [],
    1: [],
    2: [3],
    3: [1],
    4: [0, 1],
    5: [2, 0]
}

in_degree = [0] * 6
for u in graph:
    for v in graph[u]:
        in_degree[v] += 1

order = kahn_topological_sort(graph, in_degree)
if order:
    print("Topological sort order:", order)
else:
    print("Graph has a cycle, topological sort not possible.")
