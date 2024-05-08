package GeneralPractice.TopQues.DP;

import java.util.ArrayList;

public class PrintSubseqRecursion {

    public static void main(String[] args) {
        int[] arr={1,2,1};
        int n=3;
        int desiredSum=2;

        System.out.println("----Running printAllSubseqWithSumk -----");
        new PrintSubseqRecursion().printAllSubseqWithSumk(arr,desiredSum,new ArrayList<Integer>(),0,0);
        System.out.println("----Running printAnySubseqWithSumk -----");
        new PrintSubseqRecursion().printAnySubseqWithSumk(arr,desiredSum,new ArrayList<Integer>(),0,0);
        System.out.println("----Running printAllSubseqWithSumKCount -----");
        int ans=new PrintSubseqRecursion().printAllSubseqWithSumKCount(arr,desiredSum,new ArrayList<Integer>(),0,0);
        System.out.println(ans);
    }

    private int printAllSubseqWithSumKCount(int[] arr, int desiredSum, ArrayList<Integer> ans, int currentSum, int index) {
      return 0;
    }

    private boolean printAnySubseqWithSumk(int[] arr, int desiredSum, ArrayList<Integer> ans, int currentSum, int index) {
        if(index==arr.length){
            if(currentSum==desiredSum){
                ans.stream().forEach(System.out::print);
                System.out.println();
                return true;
            }
            return false;
        }
        ans.add(arr[index]);
        currentSum+=arr[index];
        if(printAnySubseqWithSumk(arr,desiredSum,ans,currentSum,index+1)) return true;
        ans.remove(ans.size()-1);
        currentSum-=arr[index];
        if(printAnySubseqWithSumk(arr,desiredSum,ans,currentSum,index+1)) return true;
        return false;
    }

    private void printAllSubseqWithSumk(int[] arr, int desiredSum, ArrayList<Integer> ans, int currentSum, int index) {
        if(index==arr.length){
            if(desiredSum==currentSum){
                ans.stream().forEach(System.out::print);
                System.out.println();
            }
            return;
        }
        ans.add(arr[index]);
        currentSum+=arr[index];
        printAllSubseqWithSumk(arr,desiredSum,ans,currentSum,index+1);
        ans.remove(ans.size()-1);
        currentSum-=arr[index];
        printAllSubseqWithSumk(arr,desiredSum,ans,currentSum,index+1);
    }
}
