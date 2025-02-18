package dsa.javaPractice.arrays;

import java.util.Arrays;

public class RotateArray {
    static void rotate(int[] nums, int k) {
        int n = nums.length;
        int [] ans = new int[n];
        for(int i = n-1 ; i>=0 ; i--)
        {
            ans [(i+k)%n] = nums[i];
        }

        for(int i=0 ; i<n ; i++)
        {
            nums[i] = ans[i];
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7}; //{6,10,6}
        int k=3;
        System.out.println(Arrays.toString(arr));
        rotate(arr,k);
        System.out.printf("rotated left by %d places : ",k);
        System.out.print(Arrays.toString(arr));
    }

}
