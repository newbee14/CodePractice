package GeneralPractice.TopQues.Graph;

import java.util.*;

class WordDistPath{
    String word;
    int distance;

    ArrayList<String> path;
    WordDistPath(String word,int distance, ArrayList<String> path){
        this.word=word;
        this.distance=distance;
        this.path=path;

    }
}
class WordLadderTwo {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<Character> availChars=new HashSet<>();
        Set<String> words=new HashSet<>();

        for(String a: wordList){
            words.add(a);
            for(int i=0;i<a.length();i++){
                availChars.add(a.charAt(i));
            }
        }

        Queue<WordDistPath> q=new ArrayDeque<>();
        q.add(new WordDistPath(beginWord,1,new ArrayList<>(Arrays.asList(beginWord))));
        List<List<String>> result=new ArrayList<>();
        int distance=Integer.MAX_VALUE;
        words.remove(beginWord);
        int level=1;
        ArrayList<String> userWords=new ArrayList<>();
        while (!q.isEmpty()){
            String curr= q.peek().word;
            int currDist=q.peek().distance;
            ArrayList<String> currPath=q.peek().path;
            q.poll();
            if(currDist>=level){
                for(String a: userWords){
                    words.remove(a);
                }
                userWords.clear();
                level=currDist;
            }
            for(int i=0;i<curr.length();i++){
                char[] charArray=curr.toCharArray();
                for(char a: availChars){
                    charArray[i]=a;
                    String temp=new String(charArray);
                    if(temp.equals("rex")){
                        System.out.println("temp = " + temp);
                    }
                    if(temp.equals(endWord)){
                        if(currDist+1<=distance){
                            distance=currDist+1;
                            currPath.add(temp);
//                            result.clear();
                            result.add(currPath);
                        }
                    }
                    else if(words.contains(temp)){
                        ArrayList<String> newPath=new ArrayList<>(currPath);
                        newPath.add(temp);
                        q.add(new WordDistPath(temp,currDist+1,newPath));
                        level=currDist+1;
                        userWords.add(temp);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        String beginWord = "hit";
//        String endWord = "cog";
//        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        String beginWord = "red";
        String endWord = "tax";
        List<String> wordList = new ArrayList<>(Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"));
        System.out.println(new WordLadderTwo().findLadders(beginWord, endWord, wordList)); // Output: 5
    }
}