package dsa.solutions.binarySearch;

import java.util.Arrays;

// array contains duplicates
public class FindInRotatedSorted2{

    static int search(int[] nums, int target) {
        int n = nums.length;

        int start = 0;
        int end = n-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(nums[mid]==target) return mid;

            //handling edge case
            if(nums[start]==nums[mid] && nums[mid]==nums[end]){
                start++;
                end--;
                continue;
            }

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
        int [] nums = {1,1,1,1,1,1,1,2,1,1};;
        int target = 2;
        System.out.println(Arrays.toString(nums));
        System.out.println("target: "+target);
        System.out.println("target present at index: "+search(nums,target));
    }
}
