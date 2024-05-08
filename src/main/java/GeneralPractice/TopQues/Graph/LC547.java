package GeneralPractice.TopQues.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class LC547 {
    public static void main(String[] args) {
        int[][] arr={{1,1,0},{1,1,0},{0,0,1}};
        int res=new LC547().findCircleNum(arr);
        System.out.println(res);
    }
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfComponents++;
                bfs(i, isConnected, visit);
            }
        }

        return numberOfComponents;
    }

    private void bfs(int i, int[][] isConnected, boolean[] visit) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visit[i] = true;

        while(!queue.isEmpty()){
            int current=queue.poll();
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[current][j]==1 && !visit[j]){
                    queue.add(j);
                    visit[j]=true;
                }
            }

        }

    }
}