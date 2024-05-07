package GeneralPractice.TopQues.Graph;

import java.util.*;

class WordDistPair{
    String word;
    int distance;
    WordDistPair(String word,int distance){
        this.word=word;
        this.distance=distance;
    }
}
public class WordLadderOne {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<Character> availChars=new HashSet<>();
        Set<String> words=new HashSet<>();

        for(String a: wordList){
            words.add(a);
            for(int i=0;i<a.length();i++){
                availChars.add(a.charAt(i));
            }
        }

        Queue<WordDistPair> q=new ArrayDeque<>();
        q.add(new WordDistPair(beginWord,1));
        int distance=Integer.MAX_VALUE;
        while (!q.isEmpty()){
            String curr= q.peek().word;
            int currDist=q.peek().distance;
            q.poll();
            for(int i=0;i<curr.length();i++){
                char[] charArray=curr.toCharArray();
                for(char a: availChars){
                    charArray[i]=a;
                    String temp=new String(charArray);
                    if(temp.equals(endWord)){
                        distance=Math.min(distance,currDist+1);
                    }
                    else if(words.contains(temp)){
                        q.add(new WordDistPair(temp,currDist+1));
                    }
                    words.remove(temp);
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(new WordLadderOne().ladderLength(beginWord, endWord, wordList)); // Output: 5
    }
}
