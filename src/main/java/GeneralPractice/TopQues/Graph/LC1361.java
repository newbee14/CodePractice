package GeneralPractice.TopQues.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

class LC1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            if(leftChild[i]!=-1) indegree[leftChild[i]]++;
            if(rightChild[i]!=-1) indegree[rightChild[i]]++;
        }

        int head=-1;
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                if(head==-1)
                    head=i;
                else
                    return false;
            }
            if(indegree[i]>1){
                return false;
            }
        }


        Queue<Integer> q=new ArrayDeque<Integer>();

        q.add(head);

        boolean[] visited=new boolean[n];

        while(!q.isEmpty()){
            int curr=q.poll();
            if(visited[curr]) return false;
            visited[curr]=true;

            if (leftChild[curr] != -1) q.add(leftChild[curr]);
            if (rightChild[curr] != -1) q.add(rightChild[curr]);

        }
        int trueCount = 0;
        for (boolean b : visited) {
            if (b) trueCount++;
        }
        return trueCount == n;

    }

    public static void main(String[] args) {
        System.out.println(new LC1361().validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2,-1,-1,-1}));
    }
}
