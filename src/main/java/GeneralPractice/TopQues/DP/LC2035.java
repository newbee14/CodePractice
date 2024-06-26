package GeneralPractice.TopQues.DP;

import java.util.ArrayList;
import java.util.Arrays;

class LC2035 {
    static int minSubsetSumDifference(ArrayList<Integer> arr, int n) {
        int totSum = 0;

        // Calculate the total sum of the array elements
        for (int i = 0; i < n; i++) {
            totSum += arr.get(i);
        }

        // Create a DP table to store subset sum information
        boolean[][] dp = new boolean[n][totSum/2 + 1];

        // Initialize the DP table for the first row
        for (int i = 0; i <= totSum/2; i++) {
            dp[0][i] = (i == arr.get(0));
        }

        // Fill in the DP table using bottom-up dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= totSum/2; target++) {
                // Calculate if the current element is not taken
                boolean notTaken = dp[ind - 1][target];

                // Calculate if the current element is taken
                boolean taken = false;
                if (arr.get(ind) <= target) {
                    taken = dp[ind - 1][target - arr.get(ind)];
                }

                // Update the DP table for the current element and target sum
                dp[ind][target] = notTaken || taken;
            }
        }

        int mini = Integer.MAX_VALUE;

        // Find the minimum absolute difference between two subsets
        for (int i = 0; i <= totSum/2; i++) {
            if (dp[n - 1][i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3, 9,7,3));
        int n = arr.size();

        // Calculate and print the minimum absolute difference
        System.out.println("The minimum absolute difference is: " + minSubsetSumDifference(arr, n));
    }

}