package GeneralPractice.TopQues.Heap;

public class KthLargestElement {
    public static void main(String[] args) {
//        int[] arr={0,7,3,2,5,6,10,9,8,1};
        int[] arr={1};
        int res=new KthLargestElement().getKthLargestElement(arr,1);
        System.out.println(res);
        int[][] mat= new int[4][5];
        int[] rows=new int[mat.length];
        for(int i=0;i<mat.length;i++){
            int sum=0;
            for(int j=0;j<mat[i].length;j++){
                sum+=mat[i][j]==1?1:0;
            }
        }
    }

    private int getKthLargestElement(int[] arr, int k) {
        int largest=-1;
        for(int i=arr.length/2-1;i>=0;i--){
            maxMinify(arr,arr.length,i);
        }
        for(int i=arr.length-1,j=1;i>=0 && j<=k;i--,j++){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            largest=arr[i];
            maxMinify(arr,i,0);
        }

        return largest;
    }

    private void maxMinify(int[] arr, int length, int index) {
        int left=index*2+1;
        int right=index*2+2;
        int largest=index;

        if(left<length && arr[left]>arr[largest]){
            largest=left;
        }
        if(right<length && arr[right]>arr[largest]){
            largest=right;
        }
        if(largest!=index){
            int temp=arr[largest];
            arr[largest]=arr[index];
            arr[index]=temp;
            maxMinify(arr,length,largest);
        }
    }
}
