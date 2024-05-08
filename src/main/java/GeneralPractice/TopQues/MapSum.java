package GeneralPractice.TopQues;

import java.util.HashMap;
import java.util.Map;


//LC= Map Sum Pairs
class MapSum {

    class TrieNode{
        Map<Character, TrieNode> charMap=new HashMap<>();
        int val;
        int wordVal;
        boolean isWord;

        public TrieNode(int value) {
            this.wordVal= 0;
            this.val=value;
            isWord=false;
        }
    }
    private TrieNode root=null;
    public MapSum() {
        root=new TrieNode(0);
    }
    //key: apple, val=3
    public void insert(String key, int val) {
        TrieNode curr=root;
        int keyVal=this.getKeyVal(key);
        for (int i = 0; i < key.length(); i++) {
            char w=key.charAt(i);
            if(curr.charMap.get(w)==null){
                curr.charMap.put(w,new TrieNode(val));
            }
            else {
                curr.charMap.get(w).val+=(val-keyVal);
            }
            curr=curr.charMap.get(w);
        }
        curr.isWord=true;
        curr.wordVal=val;
    }
    
    public int getKeyVal(String key){
        TrieNode curr=root;
        for (int i = 0; i < key.length(); i++) {
            char w=key.charAt(i);
            if(curr.charMap.get(w)==null){
                return 0;
            }
            curr=curr.charMap.get(w);
        }
        return curr.isWord?curr.wordVal:0;
    }

    public int sum(String key) {
        TrieNode curr=root;
        for (int i = 0; i < key.length(); i++) {
            char w=key.charAt(i);
            if(curr.charMap.get(w)==null) return 0;
            curr=curr.charMap.get(w);
        }
        return curr.val;
    }

    public static void main(String[] args) {
        MapSum obj = new MapSum();
        obj.insert("apple",3);
        int param_2 = obj.sum("ap");
        System.out.println(param_2);
        obj.insert("app",2);
        param_2 = obj.sum("ap");
        System.out.println(param_2);
        param_2 = obj.sum("a");
        System.out.println(param_2);
        param_2 = obj.sum("b");
        System.out.println(param_2);
    }
}
