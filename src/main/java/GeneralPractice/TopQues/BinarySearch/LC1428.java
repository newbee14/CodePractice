package GeneralPractice.TopQues.BinarySearch;

public class LC1428 {
    public static void main(String[] args) {
        int[] arr={7,7,7,7,12,7,7};
        int m = 2, k = 3;
        int a=new LC1428().minDays(arr,m,k);
        System.out.println(a);

    }

    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length) return -1;

        int left=Integer.MAX_VALUE;
        int right=Integer.MIN_VALUE;

        for(int bloom:bloomDay){
            left=Math.min(left,bloom);
            right=Math.max(right,bloom);
        }

        while(left<right){
            int mid=(left+right)/2;

            if(checkBouquetValidity(bloomDay, m, k, mid)){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return right;
    }

    private boolean checkBouquetValidity(int[] bloomDay, int m, int k, int mid) {
        int total=0;
        int count=0;
        for(int bloom:bloomDay){
            if(bloom<=mid){
                count++;
                if(count==k){
                    m--;
                    if(m==0) return true;
                    count=0;
                }
            }
            else count=0;
        }

        return false;
    }
}
