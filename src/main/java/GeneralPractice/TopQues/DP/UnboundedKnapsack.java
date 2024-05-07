package GeneralPractice.TopQues.DP;



import java.util.* ;
import java.io.*;
public class UnboundedKnapsack {
    public static int unboundedKnapsack(int n, int maxWeight, int[] value, int[] weight) {
        int[][] dp=new int[n][maxWeight+1];
        for(int[] a:dp)
            Arrays.fill(a,-1);

        return recur(weight,value,n-1,maxWeight,dp);


    }

    static int recur(int[] weight, int[] value, int n, int maxWeight,int[][] dp){

        if(maxWeight==0) return 0;
        if(n==0){
            if(maxWeight%weight[0]==0) return value[0]*maxWeight/weight[0];
            else return 0;
        }
        // if(dp[n][maxWeight] !=-1) return dp[n][maxWeight];
        int noPick=0 + recur(weight,value,n-1,maxWeight,dp);
        int pick=0;
        if(weight[n]<=maxWeight)
            pick=value[n]+ recur(weight,value,n,maxWeight-weight[n],dp);

        dp[n][maxWeight]= Math.max(pick,noPick);
        return Math.max(pick,noPick);
    }

    public static void main(String[] args) {
        int n = 3;
        int maxWeight = 15;
        int[] value = {7,2,4};
        int[] weight = {5, 10, 20};

        System.out.println(unboundedKnapsack(n, maxWeight, value, weight));
    }
}
