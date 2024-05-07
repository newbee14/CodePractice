package GeneralPractice.TopQues.BinarySearch;


public class LC410 {
    public static void main(String[] args) {
        int[] nums={7,2,5,10,8};
        int k=2;
        int res=new LC410().splitArray(nums,k);
        System.out.println(res);
    }

    public int splitArray(int[] nums, int k) {
        int largest= Integer.MIN_VALUE;
        int sum= 0;

        for(int num:nums){
            largest=Math.max(largest,num);
            sum+=num;
        }

        int left = largest;
        int right = sum;
        int res=0;
        while(left<=right){
            int mid=(left+right)/2;

            if(canWeDevide(nums,k,mid)){
                res=mid;
                right=mid-1;
            }
            else {
                left=mid+1;
            }
        }
        return res;
    }

    private boolean canWeDevide(int[] nums, int k, int maxSum) {
        int subarray=0;
        int curreantSum=0;
        for(int num:nums){
            if(curreantSum+num<=maxSum){
                curreantSum+=num;
            }
            else {
                curreantSum=num;
                subarray++;
            }
        }
        return subarray+1<=k;
    }
}
