package GeneralPractice.TopQues;

import java.util.*;

public class ReplaceWords {
    class TrieNode{
        Map<Character, TrieNode> charMap= new HashMap<>();
        boolean isWordEnd=false;
    }
    private TrieNode root;
    public ReplaceWords() {
        root=new TrieNode();
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        this.insert(dictionary);
        StringBuilder res= new StringBuilder();
        String[] sentenceArr=sentence.trim().split(" ");
        for (int i = 0; i < sentenceArr.length; i++) {
            String prefix=this.getPrefix(sentenceArr[i]);
            if(prefix.isEmpty()) res.append(sentenceArr[i]).append(" ");
            else res.append(prefix).append(" ");
        }
        return res.toString().trim();
    }
    public void insert(List<String> dict){
        dict.stream().forEach(word->{
            TrieNode curr=root;
            for (int i = 0; i < word.length(); i++) {
                char w=word.charAt(i);
                if(curr.charMap.get(w)==null){
                    curr.charMap.put(w,new TrieNode());
                }
                curr=curr.charMap.get(w);
            }
            curr.isWordEnd=true;
        });
    }
    public String getPrefix(String word){
        TrieNode curr=root;
        StringBuilder prefix= new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char w=word.charAt(i);
            if(curr.isWordEnd) return prefix.toString();
            if(curr.charMap.get(w)!=null){
                prefix.append(w);
            }
            else{
                return new StringBuilder().toString();
            }
            curr=curr.charMap.get(w);
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        ReplaceWords replaceWords=new ReplaceWords();
        String res=replaceWords.replaceWords(new ArrayList<>(Arrays.asList("a", "b", "c")), "aadsfasf absbs bbab cadsfafs");
        System.out.println(res);
    }
}
