package GeneralPractice.TopQues.Revision;

public class HeapImlp {
    //add
    //peak
    //pop
    //size

    //represnted in array
    int[] heap;
    int heapSize;
    int realSize=0;

    HeapImlp(int heapSize){
        this.heapSize=heapSize;
        heap=new int[heapSize+1];

    }

    public static void main(String[] args) {
        HeapImlp hp=new HeapImlp(5);
        hp.add(5);
        hp.add(7);
        hp.add(1);
        hp.add(9);
        hp.add(3);
        hp.pop();
    }

    private void pop() {
        if(realSize<1)
            return;
        else {
            int removeElem=heap[1];
            heap[1]=heap[realSize];

        }

    }

    public void add(int elem){
        realSize++;
        if(realSize>heapSize) return;

        int index=realSize;
        heap[index]=elem;
        if(index<=1) return;
        int parent=index/2;

        while(heap[parent]<heap[index]){
            int temp=heap[parent];
            heap[parent]=heap[index];
            heap[index]=temp;
            index=parent;
            parent=index/2;
        }
    }

}
