package GeneralPractice.TopQues.Graph;

import java.io.IOException;
import java.util.ArrayList;

public class DijsktraAlgo {

    public static void main(String[] args) throws IOException {
        int V = 3, E=3,S=2;
        ArrayList<Integer> node1 = new ArrayList<Integer>() {{add(1);add(1);}};
        ArrayList<Integer> node2 = new ArrayList<Integer>() {{add(2);add(6);}};
        ArrayList<Integer> node3 = new ArrayList<Integer>() {{add(2);add(3);}};
        ArrayList<Integer> node4 = new ArrayList<Integer>() {{add(0);add(1);}};
        ArrayList<Integer> node5 = new ArrayList<Integer>() {{add(1);add(3);}};
        ArrayList<Integer> node6 = new ArrayList<Integer>() {{add(0);add(6);}};

        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node1);
                add(node2);
            }
        };
        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node3);
                add(node4);
            }
        };
        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node5);
                add(node6);
            }
        };
        ArrayList<ArrayList<ArrayList<Integer>>> adj= new ArrayList<ArrayList<ArrayList<Integer>>>(){
            {
                add(inter1); // for 1st node
                add(inter2); // for 2nd node
                add(inter3); // for 3rd node
            }
        };
        //add final values of adj here.
        DijsktraAlgo obj = new DijsktraAlgo();
        int[] res= obj.dijkstra(V,adj,S);

        for(int i=0;i<V;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();

    }

    private int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {
        int[] dist = new int[v];
        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[s]=0;
        for(int i=0;i<v-1;i++){
            int minVertex = findMinVertex(dist,visited);
            visited[minVertex]=true;
            for(ArrayList<Integer> edge: adj.get(minVertex)){
                int neighbour = edge.get(0);
                int weight = edge.get(1);
                if(!visited[neighbour]){
                    int newDist = dist[minVertex]+weight;
                    if(newDist<dist[neighbour]){
                        dist[neighbour]=newDist;
                    }
                }
            }
        }
        return dist;
    }

    private int findMinVertex(int[] dist, boolean[] visited) {
        int minVertex = -1;
        for(int i=0;i<dist.length;i++){
            if(!visited[i] && (minVertex==-1 || dist[i]<dist[minVertex])){
                minVertex=i;
            }
        }
        return minVertex;
    }
}
