package GeneralPractice.TopQues.DP;

import java.util.Arrays;

public class NinjaTraining
{
    static int f(int day, int last, int[][] points, int[][] dp) {
        // If the result is already calculated, return it
        if (dp[day][last] != -1) return dp[day][last];

        // Base case: When it's the first day (day == 0)
        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last)
                    maxi = Math.max(maxi, points[0][i]);
            }
            return dp[day][last] = maxi; // Store and return the result
        }

        int maxi = 0;
        // Loop through the three activities on the current day
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                // Calculate the points for the current activity and recursively
                // calculate the maximum points for the previous day
                int activity = points[day][i] + f(day - 1, i, points, dp);
                maxi = Math.max(maxi, activity); // Update the maximum points
            }
        }

        return dp[day][last] = maxi; // Store and return the result
    }

    // Function to find the maximum points for ninja training
    static int ninjaTraining(int n, int[][] points) {
        // Initialize a memoization table with -1 values
        int dp[][] = new int[n][4];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // Start the recursive calculation from the last day (n - 1) with the last activity (3)
        return f(n - 1, 3, points, dp);
    }

    public static void main(String[] args) {
        int[][] points = {
                { 1, 2, 3 },
                { 2, 3, 4 },
                { 3, 2, 1 }
        };
        int n = points.length;

        System.out.println("The maximum points for ninja training are " + ninjaTraining(n, points));
    }

}