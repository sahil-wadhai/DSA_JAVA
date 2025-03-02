package dsa.solutions.arrays;

//reference: https://www.javatpoint.com/largest-sum-contiguous-subarray

import java.util.*;
class KadanesAlgo{
    /*
        Brute Force : find all subarrays[3 loops] (count sum of all and then print max among them.)
        optimized : Run two for loops (traverse all subarrays and update max if sum > max ) <=(solved)
        best : Kadane's algorithm <=(solved)
    */

    private static int twoLoops(int [] nums){
        int N = nums.length;
        int max = nums[0];

        for(int i = 0; i<N ; i++){
            int sum = 0;
            for(int j = i ; j<N ; j++){
                //traversing all subarrays and updating max if sum > max
                sum += nums[j];
                if(sum>max){
                    max = sum;
                }
            }
        }
        return max;
    }

    static int kadanesAlgo(int[] nums){
        int N = nums.length;
        int sum = 0;
        int max = nums[0];
        for(int i=0 ; i<N ; i++){
            sum += nums[i]; // add num to running sum
            max = Math.max(max,sum); //update max if sum>max

            //ignore subarray if it gives negative sum (reset sum)
            if(sum<0){
                sum = 0;
            }
        }
        return max;
    }

    //Kadane's follow up
    //Get start and end index of subarray with max sum
    static private int[] maxSubArray(int[] nums){
        int n = nums.length;
        int sum = 0;
        int max = nums[0];

        int start = 0;
        int [] ans = new int[3]; //start , end, max

        /*
        If we carefully observe our algorithm,
        we can notice that the subarray always
        starts at the particular index where the sum variable is equal to 0,
        and at the ending index, the sum always crosses the previous maximum sum(i.e. max)
         */
        for(int i=0 ; i<n ; i++){
            if(sum==0) start = i;
            sum += nums[i]; // add num to running sum

            if(sum>max){
                ans[0] = start;
                ans[1] = i;
                max = sum;
            }

            //ignore subarray if it gives negative sum (reset sum)
            if(sum<0){
                sum = 0;
            }
        }
        ans[2]=max;
        return ans;
    }


    public static void main(String[] args) {

        int [] arr= {-2, -3, 4, -1, -2, 1, 5, -3};

        //int ans = twoLoops(arr);
        int ans = kadanesAlgo(arr);

        System.out.println();
        System.out.println("Input: nums = "+ Arrays.toString(arr));
        System.out.println("Output: "+ ans);

        System.out.println("Subarray start, end and max : " + Arrays.toString(maxSubArray(arr)));
    }
}
