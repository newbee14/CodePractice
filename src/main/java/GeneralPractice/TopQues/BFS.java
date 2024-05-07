package GeneralPractice.TopQues;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
//        int[][] graph = {{1,2,3},{0},{0},{0}};
        int[][] graph = {{1},{0,2,4},{1,3,4},{2},{1,2}};
        new BFS().bfs(graph);
    }
    public void bfs(int[][] graph){
        int n=graph.length;
        boolean[] visited=new boolean[n];

        Queue<Integer> q= new ArrayDeque<>();
        q.add(0);
        visited[0]=true;

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
