package GeneralPractice.TopQues.Heap;

import java.util.ArrayList;
import java.util.List;

public class TopKElementLargest {

    public static void main(String[] args) {
        int[] arr={0,7,3,2,5,6,10,9,8,1};
        new TopKElementLargest().printTopKElements(arr,5);
    }

    private void printTopKElements(int[] arr, int k) {
        List<Integer> arrayList= new ArrayList<>();
        for(int j=arr.length/2-1;j>0;j--)
            maxHeapify(arr,arr.length,j);

        for(int j=arr.length-1,i=1;j>0 && i<=k;j--,i++) {
            int temp=arr[1];
            arr[1]=arr[j];
            arr[j]=temp;
            arrayList.add(temp);
            maxHeapify(arr,j,1);
        }
        arrayList.stream().forEach(System.out::println);
    }

    private void maxHeapify(int[] arr, int heapSize, int index) {
        int left=index*2;
        int right=index*2+1;
        int largest = index;

        if(left<heapSize && arr[left]>arr[largest]){
            largest=left;
        }
        if(right<heapSize && arr[right]>arr[largest]){
            largest=right;
        }
        if(largest!=index){
            int temp=arr[largest];
            arr[largest]=arr[index];
            arr[index]=temp;
            maxHeapify(arr,heapSize,largest);
        }
    }
}
