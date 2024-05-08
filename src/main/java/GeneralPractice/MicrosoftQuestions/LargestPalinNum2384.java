package GeneralPractice.MicrosoftQuestions;

public class LargestPalinNum2384 {
    public String largestPalindromic(String num) {
        int[] cnt=new int[10];
        for(int i=0;i<num.length();i++){
            cnt[num.charAt(i)-'0']++;
        }
        //the palindrome string can be odd or even
        //iff its even then there is no mid point else there is a mid point

        StringBuilder end=new StringBuilder();
        for(int i=9;i>=0;i--){
            if(end.length()==0 &&i==0) break;
            while(cnt[i]>1){
                end.append(i);
                cnt[i]-=2;
            }
        }
        String start=end.toString();
        int mid=-1;
        for(int i=0;i<=9;i++){
            if(cnt[i]!=0)
                mid=i;
        }
        if(mid==-1) return start+end.reverse().toString();
        else return start+mid+end.reverse().toString();
    }
    public static void main(String[] args) {
        LargestPalinNum2384 largestPalinNum2384=new LargestPalinNum2384();
        System.out.println(largestPalinNum2384.largestPalindromic("00009"));
    }
}
