package GeneralPractice.TopQues;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class HitCounter {

//    private ConcurrentLinkedDeque<Pair<Integer, Integer>> q;
//    private int total;
//
//    public HitCounter() {
//        total=0;
//        q= new ConcurrentLinkedDeque<>();
//    }
//
//    public void hit(int timestamp){
//        if(q.isEmpty()||q.getLast().getKey()!=timestamp){
//            q.add(new Pair<>(timestamp,1));
//        }
//        else if(q.getLast().getKey()==timestamp){
//            int prevCount=q.getLast().getValue();
//            q.removeLast();
//            q.add(new Pair<>(timestamp,prevCount+1));
//        }
//        total++;
//    }
//
//    public int getHits(int timestamp){
//        while (!q.isEmpty()){
//            int diff=timestamp-q.peek().getKey();
//            if(diff>=300) {
//                total -= q.getFirst().getValue();
//                q.pollFirst();
//            }
//            else break;
//        }
//        return total;
//    }
}
