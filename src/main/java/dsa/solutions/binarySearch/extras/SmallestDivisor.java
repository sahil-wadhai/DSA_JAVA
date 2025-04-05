package dsa.solutions.binarySearch.extras;

public class SmallestDivisor{
    private static int getMax(int [] nums){
        int max = 0;
        for(int n : nums){
            max = Math.max(max,n);
        }
        return max;
    }

    private static int getSum(int [] nums, int divisor){
        int sum = 0;
        for(int x : nums){
            sum += Math.ceil((double)x/divisor);
        }
        return sum;
    }
    static int smallestDivisorLinearSearch(int[] nums, int threshold) {
        int start = 1;
        int end = getMax(nums);

        for(int divisor = start; divisor<=end; divisor++){
            if(getSum(nums,divisor)<=threshold){
                return divisor;
            }
        }
        return start;
    }

    static int smallestDivisorBS(int[] nums, int threshold) {
        int start = 1;
        int end = getMax(nums);

        int ans = -1;

        while(start<=end){
            int mid = start + (end-start)/2;

            int sum = getSum(nums,mid);

            if(sum<=threshold){
                ans = mid;
                end = mid-1; // minimizing ans(i.e, divisor)
            }else{
                start = mid+1;
            }
        }
        return ans;
    }

}