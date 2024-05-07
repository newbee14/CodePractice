package GeneralPractice.TopQues.BinarySearch;

import java.util.Arrays;

public class LC1552 {
    public static void main(String[] args) {
        int[] position = {1,2,3,4,5,6,7,8,9,10};
//        int[] position = {5,4,3,2,1,1000000000};
        int m = 4;
        int a=new LC1552().maxDistance(position,m);
        System.out.println(a);
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n=position.length;
        int left=1;
        int right=position[n-1];

        if(m==2) return right-position[0];
        int maxDist=Integer.MIN_VALUE;

        while(left<=right){
            int mid=(left+right)/2;

            if(canWePlace(position,m,mid)){
                maxDist=Math.max(maxDist,mid);
                left=mid+1;
            }
            else right=mid-1;
        }
        return maxDist;
    }

    private boolean canWePlace(int[] positions, int m, int mid) {
        int lastPlacedBall=positions[0];
        m--;
        for(int position:positions){

            if(Math.abs(position-lastPlacedBall)>=mid){
                lastPlacedBall=position;
                m--;
                if(m==0){
                    return true;
                }
            }
        }

        return false;
    }
}
