package GeneralPractice.TopQues;


import java.util.HashMap;
import java.util.Map;

public class TrieCRUD {

    class TrieNode {
        int wordEnd=0;
        Map<Character,TrieNode> charMap=new HashMap<>();
    }
    private TrieNode root=null;
    public TrieCRUD() {
        this.root=new TrieNode();
    }
    public void insert(String word) {

        TrieNode curr= root;
        for(int i=0;i<word.length();i++){
            char w=word.charAt(i);
            if(curr.charMap.get(w)==null){
                curr.charMap.put(w,new TrieNode());
            }
            curr=curr.charMap.get(w);
        }
        curr.wordEnd++;
    }

    public boolean search(String word) {
        TrieNode curr= root;
        for(int i=0;i<word.length();i++){
            char w=word.charAt(i);
            if(curr.charMap.get(w)==null){
                return false;
            }
            curr=curr.charMap.get(w);
        }
        if(curr.wordEnd==0)
            return false;
        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for (int i = 0; i < prefix.length(); i++) {
            char w=prefix.charAt(i);
            if(curr.charMap.get(w)==null) return false;
            curr=curr.charMap.get(w);
        }
        return true;
    }
    public boolean deleteWord(String word){
        TrieNode curr=root;
        for (int i = 0; i < word.length(); i++) {
            char w=word.charAt(i);
            if(curr.charMap.get(w)==null) return false;
            curr=curr.charMap.get(w);
        }
        if(curr.wordEnd==0) return false;
        curr.wordEnd=0;
        return true;
    }

    public static void main(String[] args) {
        TrieCRUD trieCRUD=new TrieCRUD();
        trieCRUD.insert("Hello");
        trieCRUD.search("Hello");
        trieCRUD.startsWith("He");
    }

}
