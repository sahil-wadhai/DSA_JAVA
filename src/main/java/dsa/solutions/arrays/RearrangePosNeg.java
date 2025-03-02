package dsa.solutions.arrays;
import java.util.Arrays;
//https://leetcode.com/problems/rearrange-array-elements-by-sign/description/

public class RearrangePosNeg {

    //Every consecutive pair of integers have opposite signs.
    static int[] rearrangeArray(int[] nums){
        if(nums.length%2 != 0) return nums;

        int [] res = new int[nums.length];
        int pos = 0; //pointer to positive
        int neg = 1; //pointer to negative
        for(int num : nums){
            if(num<0){
                res[neg] = num;
                neg += 2;
            }else{
                res[pos] = num;
                pos += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(nums));
        System.out.println("Alternating pos and neg: "+rearrangeArray(nums));
    }
}
