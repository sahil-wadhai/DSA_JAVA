package dsa.solutions.arrays;
import java.util.*;

public class FourSum{

    //same as three sum
    public List<List<Integer>> fourSum(int[] nums, int target){
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0 ; i<n ; i++){

            if(i>0 && nums[i]==nums[i-1]) continue; //skip duplicates

            for(int j = i+1; j<n ; j++){

                if(j>i+1 && nums[j]==nums[j-1]) continue; //skip duplicates

                int start = j+1;
                int end = n-1;
                while(start<end){
                    long sum = (long) nums[i]+nums[j]+nums[start]+nums[end];
                    if(sum==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                        start++;
                        end--;

                        //skip duplicates
                        while(start<end && nums[start]==nums[start-1]) start++ ;
                        while(start<end && nums[end]==nums[end+1]) end--;
                    }else if(sum>target){
                        end--;
                    }else if(sum<target){
                        start++;
                    }

                }
            }
        }
        return res;
    }
}
