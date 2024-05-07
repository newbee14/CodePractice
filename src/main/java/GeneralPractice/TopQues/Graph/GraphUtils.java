package GeneralPractice.TopQues.Graph;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }

}

public class GraphUtils {

    ArrayList<ArrayList<Integer>> edgesToGraphUndirected(ArrayList<ArrayList<Integer>> edges,int nodes){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<nodes;i++){
            adj.add(new ArrayList<>());
        }
        for(ArrayList<Integer> edge:edges){
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        return adj;
    }
    ArrayList<ArrayList<Integer>> edgesToGraphDirected(ArrayList<ArrayList<Integer>> edges,int nodes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge : edges) {
            adj.get(edge.get(0)).add(edge.get(1));
        }
        return adj;
    }

    ArrayList<ArrayList<Integer>> convertMatToAdj(int[][] mat){

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<mat.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    adj.get(i).add(j);
                }
            }
        }
        return adj;
    }

    int[][] convertAdjToMat(ArrayList<ArrayList<Integer>> adj){
        int[][] mat = new int[adj.size()][adj.size()];
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                mat[i][adj.get(i).get(j)]=1;
            }
        }
        return mat;
    }

    void bfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int start){
        Queue<Integer> q = new ArrayDeque<>();
        visited[start]=true;
        q.offer(start);
        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr+" ");
            for(int neighbor:adj.get(curr)){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    q.offer(neighbor);
                }
            }
        }
    }
    void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int start){
        visited[start]=true;
        System.out.print(start+" ");
        for(int neighbor:adj.get(start)){
            if(!visited[neighbor]){
                dfs(adj,visited,neighbor);
            }
        }
    }
    void dfsIterative(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int start){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        while(!stack.isEmpty()){
            int curr = stack.pop();
            if(!visited[curr]){
                visited[curr]=true;
                System.out.print(curr+" ");
            }
            for(int neighbor:adj.get(curr)){
                if(!visited[neighbor]){
                    stack.push(neighbor);
                }
            }
        }
    }
}
