package dsa.solutions.binarySearch;
import java.util.Arrays;

public class AggresiveCows{

    private static boolean allCowsPlaced(int [] stalls, int distance, int totalCows){
        int n = stalls.length;
        int count = 1;

        //place first cow at first stall
        int prev = stalls[0];

        for(int i=1; i<n ; i++){
            if(stalls[i]-prev >= distance){
                //place the cow
                prev = stalls[i];
                count++;
            }
            if(count>=totalCows) return true;
        }
        return false;
    }

    public static int aggressiveCowsBinarySearch(int []stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;

        //if number of stalls are less than number of angry cows
        if(k>n) return -1;

        int start = stalls[1] - stalls[0];
        int end = stalls[n-1] - stalls[0];
        int ans = -1;
        while(start<=end){

            //distance between cows
            int mid = start + (end-start)/2;

            if(allCowsPlaced(stalls,mid,k)){
                ans = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }

    public static int aggressiveCowsLinearSearch(int []stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;

        if(k>n) return -1;

        int start = stalls[1] - stalls[0];
        int end = stalls[n-1] - stalls[0];

        for(int i=start; i<=end ; i++){
            if(!allCowsPlaced(stalls,i,k)){
                return i-1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int [] stalls = {};
        int cows = 3;

        System.out.println("stalls: "+Arrays.toString(stalls)+", agressiveCows: "+cows);
        System.out.println("Maximize minimum distance between any two cows: "+aggressiveCowsBinarySearch(stalls,cows));
    }
}