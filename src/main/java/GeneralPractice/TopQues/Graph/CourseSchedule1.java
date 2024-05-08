package GeneralPractice.TopQues.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CourseSchedule1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=edgesToGraphDirected(prerequisites,numCourses);
        boolean[] visited=new boolean[numCourses];
        int[] indegree=new int[numCourses];
        calculateIndegree(adj,indegree);
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(topoSort(adj,visited,i,indegree)){
                    return false;
                }
            }
        }
        return true;
    }

    boolean topoSort(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int i,int[] indegree){
        Queue<Integer> q=new ArrayDeque<>();
        visited[i]=true;
        int count=0;
        for(int in: indegree){
            if(indegree[in]==0){
                q.offer(in);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            visited[curr]=true;
            count++;
            for(int a: adj.get(curr)){
                if(!visited[a]){
                    indegree[a]--;
                    if(indegree[a]==0){
                        q.offer(a);
                    }
                }
            }
        }
        return !(count==adj.size());
    }

    private void calculateIndegree(ArrayList<ArrayList<Integer>> adj, int[] indegree) {
        for(ArrayList<Integer> a: adj){
            for(int i: a){
                indegree[i]++;
            }
        }
    }

    ArrayList<ArrayList<Integer>> edgesToGraphDirected(int[][] edges,int nodes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }

}
