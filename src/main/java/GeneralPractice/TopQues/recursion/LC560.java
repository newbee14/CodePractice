package GeneralPractice.TopQues.recursion;

import java.util.Arrays;

class LC560 {

    public static void main(String[] args) {
        new LC560().subsetSumToK(5,100,new int[]{1,2,3,4,5});
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int[][] dpArray=new int[n][k+1];
        for(int[] a:dpArray)
            Arrays.fill(a,-1);
        dp(n-1,k,arr,dpArray);

        System.out.print(" ");
        for(int i=0;i<k;i++) {
            System.out.print(i+" ");
        }
        System.out.println();

        for(int i=0;i<n;i++){
            System.out.print(i+" ");
            for(int j=0;j<=k;j++){
                System.out.print(dpArray[i][j]+" ");
            }
            System.out.println();
        }

        return false;

    }

    static boolean dp(int index, int k, int arr[],int dpArray[][]){
        if(k==0) return true;
        if(index==0) return k==arr[index];
        if(dpArray[index][k]!=-1) return dpArray[index][k]==0?false:true;

        boolean pick=false;
        if(k>=arr[index])
            pick=dp(index-1,k-arr[index],arr,dpArray);
        boolean dontPick=dp(index-1,k,arr,dpArray);
        dpArray[index][k]=pick||dontPick?1:0;
        return pick||dontPick;

    }

}