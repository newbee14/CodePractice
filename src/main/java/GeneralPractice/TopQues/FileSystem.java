package GeneralPractice.TopQues;

import java.util.*;

//LC- 588. In memory FS
class FileSystem {

    class TrieNode{
        Map<String,TrieNode> dirPath =new HashMap<>();
        Map<String,String> filePathAndContent=new HashMap<>();

    }
    private TrieNode root=null;
    public FileSystem() {
        root=new TrieNode();
    }

    public List<String> ls(String path) {
        TrieNode curr = root;
        List<String> res = new ArrayList<>();
        ArrayList<String> dirs = new ArrayList<String>(Arrays.asList(path.split("/")));
        if ("/".equals(path)) dirs.add("/");
        else dirs.set(0, "/");
        if(dirs.size()==1){

        }
        for (int i = 0; i < dirs.size() - 1; i++) {
            if (curr.dirPath.get(dirs.get(i)) == null) {
                return new ArrayList<>();
            }
            curr = curr.dirPath.get(dirs.get(i));
        }
        String last = dirs.get(dirs.size() - 1);
        TrieNode next=curr.dirPath.get(last);
        if(next==null) return res;
        if (curr.filePathAndContent.containsKey(last)){
            res.add(last);
        }
        else{
            res.addAll(next.dirPath.keySet());
            res.addAll(next.filePathAndContent.keySet());
        }
        return res;
    }

    public void mkdir(String path) {
        TrieNode curr=root;
        ArrayList<String> dirs= new ArrayList<>(Arrays.asList(path.split("/")));
        if("/".equals(path)) dirs.add("/");
        else dirs.set(0,"/");
        for (String val : dirs) {
            if (curr.dirPath.get(val) == null) {
                curr.dirPath.put(val,new TrieNode());
            }
            curr=curr.dirPath.get(val);
        }
    }

    public void addContentToFile(String filePath, String content) {
        TrieNode curr=root;
        ArrayList<String> dirs= new ArrayList<>(Arrays.asList(filePath.split("/")));
        dirs.set(0,"/");
        for (int i=0;i<dirs.size()-1;i++) {
            if (curr.dirPath.get(dirs.get(i)) == null) {
                curr.dirPath.put(dirs.get(i),new TrieNode());
            }
            curr=curr.dirPath.get(dirs.get(i));
        }
        curr.filePathAndContent.put(dirs.get(dirs.size()-1),content);
    }

    public String readContentFromFile(String filePath) {
        TrieNode curr=root;
        ArrayList<String> dirs= new ArrayList<>(Arrays.asList(filePath.split("/")));
        dirs.set(0,"/");
        for (int i=0;i<dirs.size()-1;i++) {
            if (curr.dirPath.get(dirs.get(i)) == null) {
                curr.dirPath.put(dirs.get(i),new TrieNode());
            }
            curr=curr.dirPath.get(dirs.get(i));
        }
        return curr.filePathAndContent.get(dirs.get(dirs.size()-1));
    }

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        System.out.println(fileSystem.ls("/"));                         // return []
        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/a/b/c/d", "hello");
        fileSystem.addContentToFile("/a/b/c/e", "hello123");
        System.out.println(fileSystem.ls("/a/b"));                         // return ["a"]
        System.out.println(fileSystem.readContentFromFile("/a/b/c/e")); // return "hello"
    }
}