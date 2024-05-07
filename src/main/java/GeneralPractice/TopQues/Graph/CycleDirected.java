package GeneralPractice.TopQues.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CycleDirected {
    public static boolean detectCycleInDirectedGraph(int n, ArrayList <ArrayList< Integer >> edges) {

        ArrayList <ArrayList< Integer >> adj=new GraphUtils().edgesToGraphDirected(edges,n);
        boolean[] visited=new boolean[n];
        int[] indegree=new int[n];
        int i=0;
        for(ArrayList< Integer > a: adj) {
            a.stream().toArray();
            indegree[i]=a.size();
            i++;
        }
        int count=0;
        for(i=0;i<n;i++){
            if(!visited[i]){
                if(!new CycleDirected().topoSort(adj,visited,indegree,count)){
                    return false;
                }
            }
        }

        return true;
    }
    boolean topoSort(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int[] indegree,int count){
        int n=adj.size();
        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();

            visited[curr]=true;

            for(int i: adj.get(curr)){
                if(!visited[i]){
                    visited[i]=true;
                    indegree[i]--;
                    if(indegree[i]==0){
                        q.offer(i);
                    }
                }
            }
        }
        return  count==n;
    }
    public static void main(String[] args) {
        ArrayList <ArrayList< Integer >> edges = new ArrayList < > ();
        ArrayList <Integer> a = new ArrayList < > ();
        a.add(0);
        a.add(1);
        edges.add(a);
        a = new ArrayList < > ();
        a.add(1);
        a.add(2);
        edges.add(a);
        a = new ArrayList < > ();
        a.add(2);
        a.add(0);
        edges.add(a);
        a = new ArrayList < > ();
        a.add(2);
        a.add(3);
        edges.add(a);
        a = new ArrayList < > ();
        a.add(3);
        a.add(4);
        edges.add(a);
        System.out.println(detectCycleInDirectedGraph(5, edges));
    }
}
