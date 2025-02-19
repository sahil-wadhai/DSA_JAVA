package dsa.solutions.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

// Check if Array Is Sorted and Rotated
public class SortedRotated {
    static boolean check(int[] nums) {
        int n = nums.length;
        int swaps = 0;
        for(int i=0 ; i<n-1 ; i++){
            if(nums[i]>nums[i+1]){
                swaps++;
            }
        }
        if(swaps==0) return true;
        else if(swaps==1 && nums[0]>=nums[n-1]) return true;
        else return false;
    }

    //driver code
    public static void main(String[] args) {
        int [] arr = {3,4,5,1,2}; //{6,10,6}
        System.out.println(Arrays.toString(arr));
        System.out.println("Is sorted and rotated : "+check(arr));
    }
}
