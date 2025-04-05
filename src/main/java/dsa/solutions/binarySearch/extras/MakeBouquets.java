package dsa.solutions.binarySearch.extras;

//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/

import java.util.Arrays;
public class MakeBouquets{
    private static int getMin(int [] arr){
        return Arrays.stream(arr).min().getAsInt();
    }
    private static int getMax(int [] arr){
        return Arrays.stream(arr).max().getAsInt();
    }

    private static int bouquetsMade(int [] arr, int day, int flowersRequired){
        int n = arr.length;
        int countFlowers=0;
        int countBouqs = 0;
        for(int i = 0 ; i<n ; i++){
            if(arr[i]<=day){
                countFlowers++;
                if(countFlowers==flowersRequired){
                    countBouqs++;
                    countFlowers = 0;
                }
            }else{
                countFlowers = 0;
            }
        }
        return countBouqs;
    }
    static int minDaysBS(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length){
            return -1;
        }

        int start = getMin(bloomDay);
        int end = getMax(bloomDay);
        int ans = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            int bouqsMade = bouquetsMade(bloomDay,mid,k);

            if(bouqsMade>=m){
                ans = mid;
                end = mid-1; //minimize ans
            }else{
                start = mid+1;
            }
        }
        return ans;
    }

    static int minDaysLinearSearch(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length){
            return -1;
        }

        int start = getMin(bloomDay);
        int end = getMax(bloomDay);

        for(int day = start; day<=end; day++){
            if(bouquetsMade(bloomDay,day,k)>=m){
                return day;
            }
        }
        return start;
    }


    public static void main(String[] args) {
        int [] bloomDay = {7,7,7,7,12,7,7};
        int m = 2, k = 3;

        System.out.println(Arrays.toString(bloomDay));
        System.out.println("m: " + m + ", k: "+ k);
        System.out.println("Minimum days to make m bouquets: "+minDaysBS(bloomDay,m,k));
    }
}
