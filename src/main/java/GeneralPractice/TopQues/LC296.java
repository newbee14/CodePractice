package GeneralPractice.TopQues;

import java.util.ArrayList;
import java.util.List;

public class LC296 {
    /**
     *
     * @param args
     * Input: grid = {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}}
     * Output: 6
     * Explanation: Given three friends living at (0,0), (0,4), and (2,2).
     * The point (0,2) is an ideal meeting point, as the total travel distance of 2 + 2 + 2 = 6 is minimal.
     * So return 6.
     */
    public static void main(String[] args) {
        int[][]  grid = {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        new LC296().minTotalDistance(grid);
    }
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = collectRows(grid);
        List<Integer> cols = collectCols(grid);
        int row = rows.get(rows.size() / 2);
        int col = cols.get(cols.size() / 2);
        return minDistance1D(rows, row) + minDistance1D(cols, col);
    }

    private int minDistance1D(List<Integer> points, int origin) {
        int distance = 0;
        for (int point : points) {
            distance += Math.abs(point - origin);
        }
        return distance;
    }

    private List<Integer> collectRows(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rows.add(row);
                }
            }
        }
        return rows;
    }

    private List<Integer> collectCols(int[][] grid) {
        List<Integer> cols = new ArrayList<>();
        for (int col = 0; col < grid[0].length; col++) {
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] == 1) {
                    cols.add(col);
                }
            }
        }
        return cols;
    }
}
