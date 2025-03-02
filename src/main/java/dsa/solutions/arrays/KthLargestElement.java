package dsa.solutions.arrays;

import java.util.*;

/*
    Brute Force : Sort the array in descending order and return kth element O(nlogn)
    Other approach : use priority Queue (max heap) <=(solved) O(nlogn)
    Optimized : use quick select algorithm
*/
public class KthLargestElement {
    static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int e:nums){
            pq.add(e);
        }

        for(int i = 0; i<k-1; i++){
            pq.remove();
        }
        return pq.remove();
    }

    public static void main(String[] args) {
        int [] nums = {3,2,1,5,6,4};
        int k=2;
        System.out.println(Arrays.toString(nums));
        System.out.println("k: "+k);
        System.out.println("Kth largest element: "+findKthLargest(nums,k));
    }
}
