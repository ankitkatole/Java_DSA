#include <stdio.h>
#include <stdlib.h>

#define MAX_NODES 6

typedef struct Node {
    int vertex;
    struct Node* next;
} Node;

typedef struct Graph {
    int numVertices;
    Node* adjLists[MAX_NODES];
    int inDegree[MAX_NODES];
} Graph;

Node* createNode(int v) {
    Node* newNode = malloc(sizeof(Node));
    newNode->vertex = v;
    newNode->next = NULL;
    return newNode;
}

Graph* createGraph(int vertices) {
    Graph* graph = malloc(sizeof(Graph));
    graph->numVertices = vertices;

    for (int i = 0; i < vertices; i++) {
        graph->adjLists[i] = NULL;
        graph->inDegree[i] = 0;
    }

    return graph;
}

void addEdge(Graph* graph, int src, int dest) {
    Node* newNode = createNode(dest);
    newNode->next = graph->adjLists[src];
    graph->adjLists[src] = newNode;
    graph->inDegree[dest]++;
}

void topologicalSort(Graph* graph) {
    int queue[MAX_NODES], front = 0, rear = -1;
    int inDegree[MAX_NODES];
    int count = 0;
    int result[MAX_NODES];

    // Copy inDegree array to local array
    for (int i = 0; i < graph->numVertices; i++) {
        inDegree[i] = graph->inDegree[i];
    }

    // Initialize queue with all vertices with 0 in-degree
    for (int i = 0; i < graph->numVertices; i++) {
        if (inDegree[i] == 0) {
            queue[++rear] = i;
        }
    }

    while (front <= rear) {
        int u = queue[front++];
        result[count++] = u;

        Node* temp = graph->adjLists[u];
        while (temp != NULL) {
            int v = temp->vertex;
            if (--inDegree[v] == 0) {
                queue[++rear] = v;
            }
            temp = temp->next;
        }
    }

    if (count != graph->numVertices) {
        printf("Graph has a cycle, topological sort not possible.\n");
        return;
    }

    printf("Topological Sort Order: ");
    for (int i = 0; i < count; i++) {
        printf("%d ", result[i]);
    }
    printf("\n");
}

int main() {
    Graph* graph = createGraph(MAX_NODES);

    // Add edges for the example graph
    addEdge(graph, 5, 2);
    addEdge(graph, 5, 0);
    addEdge(graph, 4, 0);
    addEdge(graph, 4, 1);
    addEdge(graph, 2, 3);
    addEdge(graph, 3, 1);

    topologicalSort(graph);

    // Free memory is omitted for brevity
    return 0;
}
