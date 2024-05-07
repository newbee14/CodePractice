package GeneralPractice.TopQues.BinarySearch;

//Search in Rotated Sorted Array
public class LC33 {
    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2};
        int res=new LC33().search(arr,1);
        System.out.println(res);
    }

    private int search(int[] arr, int target) {
        int left=0;
        int right=arr.length-1;
        int res=-1;
        //4,5,6,7,0,1,2
        //0,1,2,3,4,5,6
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target) return mid;
            if(arr[mid]>=arr[left]){
                //go left
                if (target >= arr[left] && target <= arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            else{
                if (target <= arr[left] && target >= arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                //go right

            }


        }

        return res;
    }
}
