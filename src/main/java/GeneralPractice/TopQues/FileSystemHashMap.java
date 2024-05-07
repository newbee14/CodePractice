package GeneralPractice.TopQues;

import java.util.HashMap;
import java.util.Map;

class FileSystemHashMap {
    private Map<String, Integer> hm=new HashMap<>();

    public FileSystemHashMap() {

    }

    public boolean createPath(String path, int value) {
        int lastIndexOf=path.lastIndexOf('/');
        if(lastIndexOf==-1 || path==null) return false;
        if(hm.containsKey(path)) return false;
        String baseDir=path;
        if(lastIndexOf==0 && path.length()==1) return false;
        else if(lastIndexOf>0){
            baseDir=path.substring(0,path.lastIndexOf('/'));
        }
        System.out.println("dir is "+baseDir);
        if(hm.containsKey(baseDir) || baseDir.equals(path)){
            hm.put(path,value);
            return true;
        }
        return false;
    }

    public int get(String path) {
        return hm.get(path);
    }

    public static void main(String[] args) {
        FileSystemHashMap fileSystem = new FileSystemHashMap();

        fileSystem.createPath("/leet", 1); // return true
        fileSystem.createPath("/leet/code", 2); // return true
        fileSystem.createPath("/leet/code",3); // return 2
        fileSystem.createPath("/c/d", 1); // return false because the parent path "/c" doesn't exist.
        fileSystem.get("/c"); // return -1 because this path doesn't exist.
    }
}