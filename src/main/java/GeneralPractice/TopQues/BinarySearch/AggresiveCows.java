package GeneralPractice.TopQues.BinarySearch;

import java.util.Arrays;

public class AggresiveCows {
    public static void main(String[] args) {
//        int[] arr={0,3,4,7,10,9};
        int[] arr={10,1,2,7,5};
        int n=arr.length;
        int cows=3;
        int res=new AggresiveCows().maxDist(arr,n,cows);
        System.out.println(res);

    }

    private int maxDist(int[] arr, int n, int cows) {

        Arrays.sort(arr);
        int left=1;
        int right=arr[n-1];

        if(cows==2) return right;
        int maxDist=Integer.MIN_VALUE;
        while(left<=right){
            int mid=(left+right)/2;
            //Can we place all cows with min distance of mid
            if(canWePlace(arr,cows,mid)){
                maxDist=Math.max(maxDist,mid);
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return maxDist;
    }

    private boolean canWePlace(int[] arr, int cows, int mid) {
        boolean placementResult=false;
        int lastfilledStall=arr[0];
        cows--;
        for(int stall:arr){
            if(Math.abs(stall-lastfilledStall) >=mid)
                cows--;
            if(cows==0) {
                placementResult=true;
                break;
            }
        }

        return placementResult;
    }
}
