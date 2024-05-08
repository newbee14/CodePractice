package GeneralPractice.TopQues.Revision;

public class FindElement {
    public static void main(String[] args) {
        int[] arr={4, 1, 2, 3,3,3};
        int target=3;
        int ans=search(arr,target);
        System.out.println("answer is "+ans);
    }
    public static int search(int[] arr, int target){
        int firstIndex=1000000+7;
        int n=arr.length;
        //arry can be zero
        if(n==0) return firstIndex;
        int low=0;
        int high=n-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                firstIndex=Math.min(firstIndex,mid);
                // return true;
            }
            //5,5,5, 1, 3, 4
            // if(arr[low]==arr[mid]){
            //     low++;
            //     continue;
            // }
            // 4,5,6,2,2,2
            if(arr[low]<=arr[mid]){
                if(arr[low]<=target && target<=arr[mid]){
                    high=mid-1;
                }
                else low=mid+1;
            }
            else{
                if(arr[mid]<=target && target<= arr[high]) low=mid+1;
                else high=mid-1;
            }
        }
        return firstIndex;
    }
}