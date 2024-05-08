package GeneralPractice.TopQues.Graph;

import java.util.*;


//Print shortest path using djikastra
public class DJShortPathPrint {
    public static List<Integer> dijkstra(int[][] edge, int v, int edges, int source, int destination) {
        ArrayList<ArrayList<Pair>> arr= new ArrayList<>();
        for(int i=0;i<v;i++){
            arr.add(new ArrayList<>());
        }
        for(int[] e: edge){
            arr.get(e[0]).add(new Pair(e[1],e[2]));
            arr.get(e[1]).add(new Pair(e[0],e[2]));
        }

        int[] dist=new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int[] parent=new int[v];

        PriorityQueue<Pair> q= new PriorityQueue<>((Pair a, Pair b)->a.second-b.second);
        q.add(new Pair(source,0));
        dist[source]=1;
        parent[source]=source;

        while(!q.isEmpty()){
            int node=q.peek().first;
            int cost=q.peek().second;
            q.poll();

            for(Pair a: arr.get(node)){
                int newNode=a.first;
                int newCost=a.second;
                if(dist[newNode]>newCost+cost){
                    dist[newNode]= newCost+cost;
                    parent[newNode]=node;
                    q.add(new Pair(newNode,dist[newNode]));
                }
            }
        }
        List<Integer> res= new ArrayList<>();
        res.add(destination);
        int i=source;
        int j=destination;
        while(i<=destination){
            int temp=parent[j];
            res.add(temp);
            j=temp;
            if(source==temp) break;
        }
        return res;
    }

    public static void main(String[] args) {
//        int v = 5;
//        int edges = 8;
//        int[][] edge = {{0, 1, 4}, {0, 2, 8}, {1, 2, 2}, {1, 3, 5}, {2, 3, 5}, {2, 4, 9}, {3, 4, 4}, {4, 3, 6}};
//        int source = 0;
//        int destination=4;

        /**
         * 4 5
         * 0 1 5
         * 0 2 8
         * 1 2 9
         * 1 3 2
         */
        int v = 4;
        int edges = 5;
        int[][] edge = {{0, 1, 5}, {0, 2, 8}, {1, 2, 9}, {1, 3, 2}, {2, 3, 6}};
        int source = 0;
        int destination=3;
        List<Integer> res = dijkstra(edge, v, edges, source,destination);
        System.out.println(res);
    }
}