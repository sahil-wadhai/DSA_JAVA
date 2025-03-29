package dsa.solutions.binarySearch;
// https://leetcode.com/problems/koko-eating-bananas/description/

public class KokoEatingBananas{

    private int findMax(int [] piles){
        int max = 0;
        for(int n : piles){
            max = Math.max(max,n);
        }
        return max;
    }

    private int totalHours(int [] piles, int n){
        int total = 0;
        for(int x : piles){
            total += (int)Math.ceil((double)x/n);
        }
        return total;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = findMax(piles);

        while(start<=end){
            int mid = start + (end-start)/2;

            int totalH = totalHours(piles,mid); //mid is inversely proportional to totalH

            if(totalH <= h){
                //mid is possible ans but we want to minimize it
                end = mid-1;
            }else{
                //mid increases totalH decreases
                start = mid+1;
            }
        }
        return start;
    }
}