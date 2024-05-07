package GeneralPractice.Trie;

import java.util.HashMap;
import java.util.Map;

class WordDictionary {
    class TrieNode{
        Map<Character,TrieNode> hm=new HashMap<>();
        int isWord=0;
    }

    TrieNode root=null;

    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr=root;
        for(char a: word.toCharArray()){
            curr.hm.putIfAbsent(a,new TrieNode());
            curr.hm.get(a);
        }
        curr.isWord++;
    }

    public boolean search(String word) {
        return advSearch(word,root);
    }

    private boolean advSearch(String word, TrieNode curr) {
        int i=0;
        for(char a: word.toCharArray()){
            if(curr.hm.containsKey(a))
                curr=curr.hm.get(a);
            else {
                if(a=='.'){
                    for(Character nxt:curr.hm.keySet()){
                        if(advSearch(word.substring(i+1),curr.hm.get(nxt)))
                            return true;
                    }
                }
                return false;
            }
            i++;
        }
        return curr.isWord>0;
    }
}
