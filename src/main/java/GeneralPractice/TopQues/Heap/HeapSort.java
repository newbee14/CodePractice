package GeneralPractice.TopQues.Heap;

public class HeapSort {
    /*
    Step 1 − Create a Heap
    Step 2 − Find the last element of the array
    Step 3 − Swap the last element of the array with the first element
    Step 4 − Reduce the size of the heap by 1
    Step 5 − Heapify the root element again so that we have the highest element at root.
    Step 6 − Repeat until the size of the heap is greater than 1.
     */
    public static void main(String[] args) {

        int[] arr={0,7,3,2,5,6,10,9,8,1};
        new HeapSort().performHeapSort(arr);
    }

    private void performHeapSort(int[] arr) {
        for(int i=arr.length/2-1;i>0;i--)
            maxHeapify(arr,arr.length,i);

        for(int i=arr.length-1;i>0;i--){
            int temp=arr[i];
            arr[i]=arr[1];
            arr[1]=temp;
            maxHeapify(arr,i,1);
        }

    }

    private void maxHeapify(int[] arr,int heapSize,int index) {
        int left=index*2;
        int right=index*2+1;
        int largest = index;

        if(left<heapSize && arr[left]>arr[largest])
            largest=left;
        if(right<heapSize && arr[right]>arr[largest])
            largest=right;
        if(largest!=index){
            int temp=arr[largest];
            arr[largest]=arr[index];
            arr[index]=temp;
            maxHeapify(arr,heapSize,largest);
        }
    }
}
