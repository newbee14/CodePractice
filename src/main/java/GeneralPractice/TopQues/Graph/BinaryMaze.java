package GeneralPractice.TopQues.Graph;


import java.util.Arrays;
import java.util.PriorityQueue;

class tuple {
    int first, second, third;
    tuple(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}
class BinaryMaze {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[n-1][n-1]!=0) return -1;
        int[][] dist=new int[n][n];
        for(int[] a: dist){
            Arrays.fill(a, Integer.MAX_VALUE);
        }

        PriorityQueue<tuple> q=new PriorityQueue<>((tuple a, tuple b)->a.first-b.first);
        q.add(new tuple(1, 0, 0));

        int[] dx={-1,-1,0,1,1,1,0,-1};
        int[] dy= {0,1,1,1,0,-1,-1,-1};
        dist[0][0]=1;
        while(!q.isEmpty()){
            int distance=q.peek().first, row=q.peek().second, col=q.peek().third;
            q.poll();

            for(int i=0;i<8;i++){
                int newR=row+dx[i];
                int newC=col+dy[i];
                if(newR>=0 && newR<n && newC>=0 && newC<n && grid[newR][newC]==0
                        && dist[newR][newC] >distance+1){
                    dist[newR][newC]=distance+1;

                    if(newR==n-1 && newC==n-1) return distance+1;
                    q.add(new tuple(distance+1, newR, newC));
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {

        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(new BinaryMaze().shortestPathBinaryMatrix(grid)); // Output: 4
    }
}