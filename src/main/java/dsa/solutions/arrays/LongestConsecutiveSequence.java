package dsa.solutions.arrays;
import java.util.*;

//https://leetcode.com/problems/longest-consecutive-sequence/description/
public class LongestConsecutiveSequence{

    private static boolean isPresent(int [] nums , int x){
        for(int e : nums){
            if(x==e) return true;
        }
        return false;
    }
    static int longestConsecutive(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int x : nums){
            int cnt = 1;
            while (isPresent(nums, x + 1)) {
                cnt++;
                x += 1;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

    static int longestConsecutiveOptimized(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for(int ele : nums){
            set.add(ele);
        }

        int count = 0;
        int max = 0;
        for(int num : set){
            //check if num is first element in the sequence
            if(!set.contains(num-1)){
                count = 1;
                while(set.contains(num+1)){
                    count++;
                    num++;
                }
                max = Math.max(max,count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int [] nums = {100,4,200,1,3,2};
        System.out.println(Arrays.toString(nums));
        System.out.println("Longest consecutive sequence: "+longestConsecutiveOptimized(nums));

    }
}
