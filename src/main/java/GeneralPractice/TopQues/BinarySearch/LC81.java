package GeneralPractice.TopQues.BinarySearch;

//Search in Rotated Sorted Array where elements can be duplicate
public class LC81 {
//    public static void main(String[] args) {
//        int[] arr={4,5,6,7,0,1,2};
//        int pivot=new LC81().findPivot(arr);
//        int res=new LC81().search(arr,pivot,2);
//
//        System.out.println(res);
//    }
//
//    private int search(int[] arr, int pivot, int target) {
//        int left=-1;
//        int right=-1;
//        if((arr[pivot]<=target && arr[arr.length-1]>=target) || pivot==0){
//            left=pivot;
//            right=arr.length-1;
//        }
//        else{
//            left=0;
//            right=pivot;
//        }
//        while(left<=right){
//            int mid=(left+right)/2;
//            if(arr[mid]==target){
//                return mid;
//            }
//            else if(arr[mid]>target) {
//                right=mid-1;
//            }
//            else{
//                left=mid+1;
//            }
//        }
//        return -1;
//    }
//
//    //2,5,6,0,0,1,2
//    //0,1,2,3,4,5,6
//    private int findPivot(int[] arr) {
//        int pivot=0;
//        for(int i=1;i<arr.length-1;i++){
//            if(arr[0]>arr[i]){
//                pivot=i;
//                break;
//            }
//        }
//        return pivot;
//    }
//--------Above soluntion is O(nlogn) which involves one for loop and one BS,
// Next we will try to solve this problem by one pass BS
        public static void main(String[] args) {
        int[] arr={2,5,6,0,0,1,2};
//        int[] arr={1,0,1,1,1};
        int target=0;
        Boolean res=new LC81().search(arr,target);

        System.out.println(res);
    }

    private Boolean search(int[] arr, int target) {
            int left=0;
            int right=arr.length-1;

            while(left<=right){
                int mid=(left+right)/2;

                if(arr[mid]==target){
                    return true;
                }
                if(arr[mid]==arr[left] && arr[mid]==arr[right]){
                    left=left+1;
                    right=right-1;
                }
                else if(arr[left]<=arr[mid]){
                    if(arr[left]>=target && target<arr[mid]){
                           right=mid-1;
                    }
                    else{
                        left=mid+1;
                    }
                }
                else{
                    if(arr[right]<=target && target>arr[mid]){
                        left=mid+1;
                    }
                    else{
                        right=mid-1;
                    }
                }
            }
            return false;
    }

}
