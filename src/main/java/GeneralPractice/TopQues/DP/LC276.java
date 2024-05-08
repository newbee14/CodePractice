package GeneralPractice.TopQues.DP;

public class LC276 {

    public static void main(String[] args) {
        System.out.println(new LC276().numWays(3,2));
    }
    public int numWays(int n, int k) {
        if(n==1) return k;

        return dp(n,k,-1,-2);

    }

    private int dp(int n,int k,int current,int last) {
        if(n==1) return 1;

        for(int i=1;i<=k;i++){
            if(current==last)
                continue;
            last=dp(n-1,k,i,last);
            current=dp(n-1,k,i,last);
        }
        return current;
    }
}
