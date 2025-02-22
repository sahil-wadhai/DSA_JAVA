package dsa.solutions.arrays;

//print max in each window of size k
/*
    brute force: use priority queue(max heap) with fixed size sliding window technique O(n*k)  <= (solved)
    optimized : use deque, add and remove element such that first element is required max in window

*/
import java.util.*;
public class SlidingWindowMaximum {
    static int[] bruteForce(int[] nums, int k) {
        int n = nums.length;
        int [] res = new int[n-k+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int max = 0;
        int count=0;
        for(int i=0,j=0; j<n ; j++){
            pq.add(nums[j]); //O(log k)
            if(j-i+1==k){
                res[count++] = pq.peek(); //O(1)
                int first = nums[i];
                pq.remove(first); //O(k)
                i++;
            }
        }
        return res;
    }

    static int[] optimized(int [] nums,int k){
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        int count = 0;

        for (int i = 0, j = 0; j < n; j++) {

            // Remove smaller elements in the window
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[j]) {
                dq.pollLast();
            }

            dq.offerLast(j);

            // Store the max value once the window is filled
            if (j - i + 1 == k) {
                res[count++] = nums[dq.peekFirst()];
                i++;
                // Remove elements outside the window
                if (!dq.isEmpty() && dq.peekFirst() < i) {
                    dq.pollFirst();
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int [] arr ={1,3,-1,-3,5,3,6,7};   // {5,3,4} k=1
        int k=3;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(optimized(arr,k)));
    }

}
