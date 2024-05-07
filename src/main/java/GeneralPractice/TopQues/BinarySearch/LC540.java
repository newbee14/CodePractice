package GeneralPractice.TopQues.BinarySearch;

public class LC540 {
    //540. Single Element in a Sorted Array
    public static void main(String[] args) {
        int[] arr={1,1,2,3,3,4,4,8,8};
//        int[] arr={1,0,1,1,1};
        new LC540().singleNonDuplicate(arr);
    }
    public int singleNonDuplicate(int[] nums) {
        //1,1,2,3,3,4,4,8,8
        //0,1,2,3,4,5,6,7,8
        //-,1,2,3,4,5,6,7,-
        int n=nums.length;
        if(n==1) return nums[0];
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[n-1]!=nums[n-2]) return nums[n-1];
        int left=1;
        int right=n-2;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]!=nums[mid-1]&&nums[mid]!=nums[mid+1])
                return mid;
            if((mid%2==1 && nums[mid]==nums[mid-1]) ||
                    (mid%2==0 && nums[mid]==nums[mid+1])){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }

        return -1;

    }
}
