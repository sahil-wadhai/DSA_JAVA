package dsa.solutions.arrays;

import java.util.Arrays;

/*
    1) find breaking point(i.e, pivot) nums[i]<nums[i+1] (loop from i=n-2 to i=0) here i is pivot
    2) find successor of pivot (from right to left first element greater than pivot)
    3) swap pivot and its successor
    4) reverse suffix (from pivot+1 to end)
*/
public class NextPermutation{

    private static int getBreakingPoint(int [] nums){
        int n = nums.length;
        int pivot = -1;
        for(int i=n-2 ; i>=0 ; i--){
            if(nums[i]<nums[i+1]){
                pivot = i;
                break;
            }
        }
        return pivot;
    }
    private static int getSuccesor(int [] nums, int pivot){
        int n = nums.length;
        int succ = -1;
        for(int i=n-1 ; i>=0 ; i--){
            if(nums[i]>nums[pivot]){
                succ = i;
                break;
            }
        }
        return succ;
    }
    private static void swap(int [] nums, int i1, int i2){
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
    private static void reverseSuffix(int [] nums,int start){
        int end = nums.length-1;
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = getBreakingPoint(nums); //1
        if(pivot != -1){
            int succ = getSuccesor(nums, pivot); //2
            swap(nums,pivot,succ); //3
        }
        reverseSuffix(nums,pivot+1); //4
    }

    public static void main(String[] args) {
        int [] nums = {1,2,5,4,3};
        System.out.println(Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
