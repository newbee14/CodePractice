package GeneralPractice.Trie;

import java.util.HashMap;
import java.util.Map;

class TrieCRUD {

    class TrieNode{
        Map<Character, TrieNode> hm=new HashMap<>();
        boolean isWord;
    }

    TrieNode root=null;

    public TrieCRUD() {
        root=new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char a= word.charAt(i);
            curr.hm.putIfAbsent(a,new TrieNode());
            curr=curr.hm.get(a);
        }
        curr.isWord = true;

    }

    public boolean search(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char a= word.charAt(i);
            if(!curr.hm.containsKey(a)) return false;

            if(i==word.length()-1 && !curr.isWord) {
                return false;
            }
            curr=curr.hm.get(a);
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(int i=0;i<prefix.length();i++){
            char a= prefix.charAt(i);
            if(!curr.hm.containsKey(a)) return false;
            curr=curr.hm.get(a);
        }
        return true;
    }

    public static void main(String[] args) {
         TrieCRUD obj = new TrieCRUD();
         obj.insert("word");
         boolean param_2 = obj.search("wor");
         boolean param_3 = obj.startsWith("word");
        System.out.println(param_2);
        System.out.println(param_3);
    }
}