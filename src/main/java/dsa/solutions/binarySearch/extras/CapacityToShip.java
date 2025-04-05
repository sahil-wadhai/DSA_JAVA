package dsa.solutions.binarySearch.extras;

public class CapacityToShip{
    private int getMax(int [] weights){
        int max=0;
        for(int x:weights){
            max = Math.max(max,x);
        }
        return max;
    }
    private int getSum(int [] weights){
        int sum = 0;
        for(int x:weights){
            sum += x;
        }
        return sum;
    }
    private int getDays(int [] weights, int capacity){
        int n = weights.length;
        int countDays = 1;
        int sum = 0;
        for(int i=0; i<n ; i++){
            if(sum + weights[i]<=capacity){
                sum += weights[i];
            }else{
                countDays++;
                sum = weights[i];
            }
        }
        return countDays;
    }
    public int shipWithinDays(int[] weights, int daysGiven) {
        int start = getMax(weights);
        int end = getSum(weights);

        int ans = -1;
        while(start<=end){
            int mid = start + (end - start)/2; //capacity or load
            int days = getDays(weights,mid);
            if(days<=daysGiven){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}
