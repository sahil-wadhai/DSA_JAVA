package dsa.solutions.arrays;

//
//

/*
    - Brute Force: use nested loops to check all sub arrays O(n**2)
    - Optimal: Prefix sum approach: O(n)
        1) Maintain a running sum of elements (sum).
        2) Store the frequency of prefix sums in a HashMap (preSum).
        3) For every index i, check if sum - k exists in preSum:
           If yes, it means there exists a subarray ending at i whose sum is k.
           Add the frequency of sum - k to the count.
        4) Finally, store/update the sum in the HashMap.
 */

import java.util.*;
public class CountSubArrWithSumK{
    static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> preSum = new HashMap<>();

        int sum=0;
        int count=0;
        for(int i=0; i<n ; i++){
            sum += nums[i];

            if(sum==k){
                count++;
            }

            int rem = sum-k;
            if(preSum.containsKey(rem)){
                count+=preSum.get(rem);
            }

            preSum.put(sum,preSum.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int [] nums = {0,0,0,1,0};
        int k = 0;

        System.out.println("nums: "+Arrays.toString(nums));
        System.out.println("k: "+k);
        System.out.println("Number of subarrays with sum k: "+subarraySum(nums,k));
    }
}
