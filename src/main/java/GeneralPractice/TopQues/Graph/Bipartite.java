package GeneralPractice.TopQues.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

//class Pair{
//    int row;
//    int col;
//    Pair(int row,int col){
//        this.row=row;
//        this.col=col;
//    }
//}
public class Bipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // 0: uncolored, 1: color A, -1: color B

        // Perform BFS on each uncolored vertex
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) {
                if (!bfs(graph, colors, i))
                    return false; // Graph is not bipartite
            }
        }
        return true; // Graph is bipartite
    }

    private boolean bfs(int[][] graph, int[] colors, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        colors[start] = 1; // Color start vertex as A

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int color = colors[curr];
            int neighborColor = -color; // Color of neighbor should be opposite

            for (int neighbor : graph[curr]) {
                if (colors[neighbor] == 0) {
                    colors[neighbor] = neighborColor;
                    queue.offer(neighbor);
                } else if (colors[neighbor] != neighborColor) {
                    return false; // Found adjacent vertices with same color
                }
            }
        }
        return true; // No conflicts found
    }

    public static void main(String[] args) {
        Bipartite bg = new Bipartite();
//        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println("Is the graph bipartite? " + bg.isBipartite(graph)); // Output: true
    }
}
