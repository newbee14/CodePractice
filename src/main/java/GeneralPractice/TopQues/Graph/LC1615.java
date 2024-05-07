package GeneralPractice.TopQues.Graph;

import java.util.*;

public class LC1615 {
    /**
     *
     * @param n
     * @param roads
     * @return
     * intitution indegree nodes of a + intitution indegree nodes of b - common nodes
     */
    public int maximalNetworkRank(int n, int[][] roads){
        int max=0;
        Map<Integer, Set<Integer>> hm= new HashMap<>();
        for(int[] road:roads){
            hm.computeIfAbsent(road[1],k->new HashSet<>()).add(road[0]);
            hm.computeIfAbsent(road[0],k->new HashSet<>()).add(road[1]);
        }
        for(int i=0;i<n;++i){
            for(int j=i+1;j<n;++j){
                int rank=hm.getOrDefault(i, Collections.emptySet()).size()
                        +hm.getOrDefault(j, Collections.emptySet()).size();

                if(hm.getOrDefault(i,Collections.emptySet())
                        .contains(j)){
                    rank--;
                }
                max=Math.max(max,rank);

            }
        }
        return max;
    }
}
