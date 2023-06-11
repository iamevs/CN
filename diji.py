def min_distance(distances, visited):
    min_dist = float('inf')
    min_index = -1
    for v in range(len(distances)):
        if distances[v] < min_dist and not visited[v]:
            min_dist = distances[v]
            min_index = v
    return min_index
def print_path(parents, target):
    if parents[target] == -1:
        print(target, end=' ')
        return
    print_path(parents, parents[target])
    print(target, end=' ')
def dijkstra(graph, source):
    num_vertices = len(graph)
    distances = [float('inf')] * num_vertices  
    parents = [-1] * num_vertices 
    distances[source] = 0 
    visited = [False] * num_vertices

    for _ in range(num_vertices):
        u = min_distance(distances, visited) 
        visited[u] = True

        for v in range(num_vertices):
            if graph[u][v] > 0 and not visited[v] and distances[v] > distances[u] + graph[u][v]:
                distances[v] = distances[u] + graph[u][v]
                parents[v] = u
    print("Vertex\tDistance\tPath")
    for v in range(num_vertices):
        print(f"{v}\t{distances[v]}\t\t", end='')
        print_path(parents, v)
        print()
graph = [
    [0, 4, 0, 0, 0, 0, 0, 8, 0],
    [4, 0, 8, 0, 0, 0, 0, 11, 0],
    [0, 8, 0, 7, 0, 4, 0, 0, 2],
    [0, 0, 7, 0, 9, 14, 0, 0, 0],
    [0, 0, 0, 9, 0, 10, 0, 0, 0],
    [0, 0, 4, 14, 10, 0, 2, 0, 0],
    [0, 0, 0, 0, 0, 2, 0, 1, 6],
    [8, 11, 0, 0, 0, 0, 1, 0, 7],
    [0, 0, 2, 0, 0, 0, 6, 7, 0]
]

dijkstra(graph, 0)
