package GeneralPractice.TopQues.Heap;

import java.util.*;

public class LC1337 {

    Map<Integer,Integer> hm= new HashMap<>();

    public int[] kWeakestRows(int[][] mat, int k) {
        for(int i=0;i<mat.length;i++){
            int sum=0;
            for(int j=0;j<mat[i].length;j++){
                sum+=mat[i][j]==1?1:0;
            }
            hm.put(i,sum);
        }
        Queue<Integer> q=new PriorityQueue<>();

        for(int key:hm.keySet()){
            q.add(key);
            // if(q.size()>k) q.poll();
        }

        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = q.poll();
        }
        return top;
    }

    public int[] pop() {
        return new int[]{1,3};
    }
}

