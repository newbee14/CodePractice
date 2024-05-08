package GeneralPractice.TopQues.Graph;

import java.util.*;

//Topo Sort
public class DAGShortestPath {
    public static int[] shortestPathInDAG(int n, int m, int[][] edges) {
        //'N' = 3, 'M' = 3, 'edges' = [0, 1, 2], [1, 2, 3], [0, 2, 6]].
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
        }
        boolean[] visited=new boolean[n];
        Queue<Integer> q=new ArrayDeque<>();
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            for(Pair p: adj.get(i)){
                indegree[p.first]++;
            }
        }
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            visited[curr]=true;
            for(Pair p: adj.get(curr)){
                if(!visited[p.first]){
                    indegree[p.first]--;
                    dist[p.first]=Math.min(dist[p.first],dist[curr]+p.second);
                    if(indegree[p.first]==0){
                        q.offer(p.first);
                    }
                }
            }
        }
        return dist;

    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        int[][] edges = {{0, 1, 2}, {1, 2, 3}, {0, 2, 6}};
        System.out.println(Arrays.toString(shortestPathInDAG(n, m, edges))); // Output: [0, 2, 5]
    }
}
