package GeneralPractice.TopQues.TwoPointer;

import java.util.Arrays;

public class LC1498 {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int mod = 1_000_000_007;
        int low=0;
        int high=n-1;
        int count=0;
        if(nums[low]>Math.floor(target/2)) return count;
        while(nums[high]>target || (nums[high]+nums[low])>=target){
            high--;
        }

        if(low==high) return count++;

        for(int i=0;i<high;i++){
             if(nums[i]+nums[high]<=target){
                 count+=Math.pow(2,high-i);
                 count %= mod;
             }else {
                 high--;
             }

        }
        return count;
    }
    public static void main(String[] args) {
        LC1498 l = new LC1498();
        int[] nums = {3,5,6,7};
//        int[] nums = {2,3,3,4,6,7};
        int target = 9;
        System.out.println(l.numSubseq(nums, target));
    }
}
