package GeneralPractice.MicrosoftQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

class LRUCache {

    int capacity=0;
    Map<Integer,Integer> hm=new HashMap<>();
    ConcurrentLinkedDeque<Integer> q=new ConcurrentLinkedDeque<>();


    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        if(hm.containsKey(key)){
            q.remove(key);
            q.add(key);
            return hm.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(hm.size()<capacity){
            hm.put(key,value);
            q.add(key);
        }
        else{
            if(hm.containsKey(key)){
                q.remove(key);
                q.add(key);
                hm.put(key,value);
            }
            else{
                int removedKey=q.pollFirst();
                hm.remove(removedKey);
                hm.put(key,value);
                q.add(key);
            }
        }
    }
}