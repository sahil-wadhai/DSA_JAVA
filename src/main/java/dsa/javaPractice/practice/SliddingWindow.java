package dsa.javaPractice.practice;

import java.util.*;
public class SliddingWindow{
    private static int getMaxKey(Map<Integer,Integer>map){
        int max = Integer.MIN_VALUE;
        for(int key:map.keySet()){
            max = Math.max(max,key);
        }
        return max;
    }
    static int[] usingMap(int[] nums, int k) {
        int n = nums.length;
        int [] res = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int count=0;

        for(int i=0,j=0; j<n ; j++){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            max = Math.max(max,nums[j]);
            if(j-i+1==k){
                System.out.println(map);
                res[count++] = max;
                if(map.get(nums[i])==1){
                    int removed = map.get(nums[i]);
                    map.remove(nums[i]);
                    if(removed==max){
                        max = getMaxKey(map);
                    }
                }else{
                    map.put(nums[i],map.get(nums[i])-1);
                }

                i++;
                System.out.println(max);
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
        int [] arr = {5,3,4};
        int k=1;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(optimized(arr,k)));
    }
}
