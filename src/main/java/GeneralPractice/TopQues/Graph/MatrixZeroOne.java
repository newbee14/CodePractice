package GeneralPractice.TopQues.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;


public class MatrixZeroOne {
    public static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> adj, int n, int m) {
        // Write your code here.
        int[][] mat= new int[n][m];
        int[][] duplicate= new int[n][m];

        for(int i=0;i<n;i++){
            ArrayList<Integer> a=adj.get(i);
            for(int j=0;j<a.size();j++){
                if(adj.get(i).get(j)==1)
                    mat[i][j]=1;
            }
        }

        boolean[][] visited=new boolean[n][m];
        Queue<Pair> q=new ArrayDeque<>();
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                // start BFS if cell contains 1
                if(mat[i][j] == 1) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int nRow=q.peek().first;
            int nCol=q.peek().second;
            q.poll();

            markVisitedAndDistance(mat,nRow,nCol,visited,n,m,duplicate,q);
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < duplicate.length; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < duplicate[i].length; j++) {
                // Add elements from the 2D array to the inner list
                innerList.add(duplicate[i][j]);
            }
            // Add the inner list (row) to the result list
            result.add(innerList);
        }
        return result;
    }
    static void markVisitedAndDistance(int[][] mat,int i,int j,
                                       boolean[][] visited,int n,int m,int[][] dup,Queue<Pair> q){
        int[][] distance={{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] a: distance){
            int nRow=i+a[0];
            int nCol=j+a[1];

            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && mat[nRow][nCol] == 0 && !visited[nRow][nCol]){
                dup[nRow][nCol]=dup[i][j]+1;
                // mat[i][j]=0;
                visited[nRow][nCol]=true;
                q.add(new Pair(nRow,nCol));
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(0);
        a1.add(0);
        a1.add(0);
        a1.add(1);

        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(0);
        a2.add(0);
        a2.add(1);
        a2.add(1);
        ArrayList<Integer> a3 = new ArrayList<>();
        a3.add(0);
        a3.add(1);
        a3.add(1);
        a3.add(0);

        adj.add(a1);
        adj.add(a2);
        adj.add(a3);
        int n = 3;
        int m = 4;
        System.out.println(nearest(adj, n, m));
    }
}
