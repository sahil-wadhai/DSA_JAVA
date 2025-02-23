package dsa.solutions.arrays;

import java.util.*;
import java.lang.Math;

public class LongestSubArrWithSumK {
    static int longestSubarray(int[] arr, int k) {
        Map<Integer,Integer> preSum = new HashMap<>();
        int n = arr.length;
        int sum =0;
        int maxLen = 0;
        for(int i=0 ; i<n ; i++){
            sum += arr[i];
            if(sum==k){
                maxLen = Math.max(maxLen,i+1);
            }

            int rem = sum - k ;
            if(preSum.containsKey(rem)){
                int idx = preSum.get(rem);
                maxLen = Math.max(maxLen ,i-idx);
            }

            if(!preSum.containsKey(sum)){
                preSum.put(sum,i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int [] arr = {-5, 8, -14, 2, 4, 12};
        int k = -5;
        //Only subarray with sum = -5 is [-5, 8, -14, 2, 4] of length 5.
        System.out.println(Arrays.toString(arr));
        System.out.println("Given sum : ");
        System.out.println("Length of longest Sub Array with given sum : "+longestSubarray(arr,k));
    }
}
