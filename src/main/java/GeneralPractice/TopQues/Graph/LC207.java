package GeneralPractice.TopQues.Graph;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class LC207 {
    public static void main(String[] args) {
        int[][] graph = {{1,0},{0,1}};
        Map<Integer,List<Integer>> li= new HashMap<>();
        int[] inDegree=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            int[] node=graph[i];
            li.putIfAbsent(node[0],new ArrayList<>());
            li.putIfAbsent(node[1],new ArrayList<>());
            li.get(node[1]).add(node[0]);
            inDegree[node[0]]++;
        }

        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        int nodeVisited=0;
        while(!q.isEmpty()){
            int currNode=q.poll();
            nodeVisited++;
            for(int i : li.get(currNode)){
                inDegree[i]--;
                if (inDegree[i] == 0)
                    q.add(i);
            }
        }
    }
}
