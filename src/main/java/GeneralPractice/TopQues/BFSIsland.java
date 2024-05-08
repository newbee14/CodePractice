package GeneralPractice.TopQues;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFSIsland {
    public static void main(String[] args) {
//        int[][] graph = {{0},{0,2,4},{1,3,4},{2},{1,2}};
        int[][] graph = {{0},{1},{2},{3},{4}};

        new BFSIsland().bfsIsland(graph);
    }

    private void bfsIsland(int[][] graph) {
        int n=graph.length;
        boolean[] visited =new boolean[n];
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                bfs(graph,visited,i);
            }
        }
    }

    public void bfs(int[][] graph, boolean[] visited, int src){
        Queue<Integer> q= new ArrayDeque<Integer>();
        visited[src]=true;
        q.add(src);
        while(!q.isEmpty()){
            int currNode=q.poll();
            System.out.println(currNode);
            for(int i=0;i<graph[currNode].length;i++){
                int nextNode=graph[currNode][i];
                if(!visited[nextNode]){
                    q.add(nextNode);
                    visited[nextNode]=true;
                }
            }
        }

    }
}
