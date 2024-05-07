package GeneralPractice.TopQues.Heap;

import java.util.ArrayList;
import java.util.List;

public class TopKElementSmallest {
    public static void main(String[] args) {
        int[] arr={0,7,3,2,5,6,10,9,8,1};
        new TopKElementSmallest().printBottomKElements(arr,5);
    }

    private void printBottomKElements(int[] arr, int k) {
        for(int i=arr.length/2-1;i>0;i--){
            minHeapify(arr,arr.length,i);
        }
        List<Integer> list=new ArrayList<>();
        for(int i=arr.length-1,j=1;i>0 && j<=k;i--,j++){
            int temp=arr[i];
            arr[i]=arr[1];
            arr[1]=temp;
            list.add(arr[i]);
            minHeapify(arr,i,1);
        }
        list.stream().forEach(System.out::println);
    }

    private void minHeapify(int[] arr, int length, int index) {
        int left=index*2;
        int right=index*2+1;
        int smallest=index;

        if(left<length && arr[left]<arr[smallest]){
            smallest=left;
        }
        if(right<length && arr[right]<arr[smallest]){
            smallest=right;
        }
        if(smallest!=index){
            int temp=arr[index];
            arr[index]=arr[smallest];
            arr[smallest]=temp;
            minHeapify(arr,length,smallest);
        }
    }
}
