package dsa.solutions.binarySearch;

import java.util.Arrays;

public class FindInRotatedSorted1{

    static int search(int[] nums, int target) {
        int n = nums.length;

        int start = 0;
        int end = n-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(nums[mid]==target) return mid;

            //Search in left sorted array
            if(nums[start]<=nums[mid]){
                //if target lies in left sorted array
                if(nums[start]<=target && target<=nums[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
            //Search in right sorted array
            else if(nums[mid]<=nums[end]){
                //if target lies in left sorted array
                if(nums[mid]<=target && target<=nums[end]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(Arrays.toString(nums));
        System.out.println("target: "+target);
        System.out.println("target present at index: "+search(nums,target));
    }
}
