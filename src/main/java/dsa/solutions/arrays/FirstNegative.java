package dsa.solutions.arrays;

import java.util.*;
public class FirstNegative {
    // Function to find the first negative integer in every window of size k
    static List<Integer> firstNegativeInteger(int arr[], int k) {
        int n = arr.length;
        Queue<Integer> que = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0, j=0 ; j<n ; j++){
            if(arr[j]<0) que.offer(j);

            if(j-i+1==k){
                if(que.size()>0) res.add(arr[que.peek()]);
                else res.add(0);

                i++;
                if(que.size()>0 && que.peek()<i){
                    que.poll();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [] arr={-8, 2, 3, -6, 10, 9,-2};
        int k = 3;
        System.out.println(Arrays.toString(arr) + "  k : "+k);
        System.out.println(firstNegativeInteger(arr,k));
    }
}
