package dsa.solutions.maths.bitManipulation;
import java.util.*;
/*
    Concept:
    - A set of size n has 2**n subsets.
    - Each subset can be represented as a binary number of length n.
    - Each bit in the binary number represents whether an element is included (1) or not (0).

    example:
    Given set: {A, B, C}
    total subsets: 2**3 = 8  (i=0 to i=7)

    0 => 000 -> {}  (empty set)
    1 => 001 -> {C}
    2 => 010 -> {B}
    3 => 011 -> {B, C}
    4 => 100 -> {A}
    5 => 101 -> {A, C}
    6 => 110 -> {A, B}
    7 => 111 -> {A, B, C} (full set)

*/
public class PowerSet {

    static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        int totalSets = (int)Math.pow(2,n); //total number of subsets

        for(int i = 0; i<totalSets ; i++){
            List<Integer> subset = new ArrayList<>();

            //traverse bits of i
            for(int j=0; j<nums.length ; j++){
                int bit = (1<<j) & i;
                if(bit>=1) subset.add(nums[j]);
            }

            res.add(subset);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        System.out.println(Arrays.toString(nums));
        System.out.println(subsets(nums));
    }
}

