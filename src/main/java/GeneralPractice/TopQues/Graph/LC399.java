package GeneralPractice.TopQues.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC399 {

    /**
     *Its a Directed Weighted Graph Problem
     * @param eq [["a","b"],["b","c"]]
     * @param values [2.0,3.0]
     * @param queries [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
     * @return [6.00000,0.50000,-1.00000,1.00000,-1.00000]
     * Explanation:
     * Given: a / b = 2.0, b / c = 3.0
     * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
     * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
     * note: x is undefined => -1.0
     */

    public double[] calcEquation(List<List<String>> eq, double[] values, List<List<String>> queries) {
            Map<Integer,Map<Integer,Double>> hm= new HashMap<>();
            for(int i=0;i<eq.size();i++){
                List<String> e= eq.get(i);
                String node1=e.get(0),node2=e.get(1);


            }
        return null;
    }
}

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] arr=new int[nums.length/3][3];
        int index=0;
        for(int i=2;i< nums.length;i+=3){
            if(nums[i-1]-nums[i-2] <= k && nums[i]-nums[i-1] <= k){
                int[] ar={nums[i-2],nums[i-1],nums[i]};
                arr[index]=ar;
                index++;
            }
            else
                return new int[0][];
        }
        return arr;
    }
}
