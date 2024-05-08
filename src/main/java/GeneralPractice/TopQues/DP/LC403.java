package GeneralPractice.TopQues.DP;



import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC403 {

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 5, 6, 8, 12, 17};
    }

//    public boolean canCross(int[] stones) {
//        if (stones[0] + 1 != stones[1]) return false; // Edge case
//
//        int n = stones.length;
//        int target = stones[n - 1];
//
//        Set<Integer> stonePositions = new HashSet<>();
//        for (int stone : stones) {
//            stonePositions.add(stone);
//        }
//
//        Map<Pair<Integer, Integer>, Boolean> memo = new HashMap<>();
//        return solve(1, stones[0] + 1, stonePositions, memo, target);
//    }
//
//    private boolean solve(int prevJump, int position, Set<Integer> stonePositions, Map<Pair<Integer, Integer>, Boolean> memo, int target) {
//        if (position == target) return true;
//        if (prevJump == 0 || !stonePositions.contains(position)) return false;
//
//        Pair<Integer, Integer> key = new Pair<>(prevJump, position);
//        if (memo.containsKey(key)) return memo.get(key);
//
//        boolean ch1 = solve(prevJump - 1, position + prevJump - 1, stonePositions, memo, target);
//        boolean ch2 = solve(prevJump, position + prevJump, stonePositions, memo, target);
//        boolean ch3 = solve(prevJump + 1, position + prevJump + 1, stonePositions, memo, target);
//
//        memo.put(key, ch1 || ch2 || ch3);
//        return ch1 || ch2 || ch3;
//    }
}