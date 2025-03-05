package dsa.solutions.arrays;
import java.util.*;

public class TwoSum{
    // a + b = target
    //a = target - b;
    public int[] twoSum(int[] nums, int target) {
        int [] ans = {-1,-1};
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0 ; i<nums.length; i++){
            int b = nums[i];
            int a = target - b;
            if(map.containsKey(a)){
                ans[0] = map.get(a);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i],i);
        }

        return ans;
    }
}