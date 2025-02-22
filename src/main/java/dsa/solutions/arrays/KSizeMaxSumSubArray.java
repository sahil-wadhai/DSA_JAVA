package dsa.solutions.arrays;

import java.util.Arrays;

public class KSizeMaxSumSubArray {
    private static int maximumSumSubarray(int[] arr, int k) {
        int n = arr.length;
        int sum=0;
        int max = 0;

        for(int i=0,j=0; j<n ; j++){
            sum += arr[j];
            if(j-i+1==k){ //window_size==k retain the window
                max=Math.max(max,sum);
                sum -= arr[i];
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int [] arr = {400, 200, 200, 0 , 0, 0, 800};
        int k = 3;

        System.out.println(Arrays.toString(arr));
        System.out.println("Maximum sum of subarray of size k :"+maximumSumSubarray(arr,k));
    }
}
