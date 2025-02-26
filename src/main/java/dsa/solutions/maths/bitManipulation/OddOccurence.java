package dsa.solutions.maths.bitManipulation;
import java.util.Arrays;
//find two numbers with odd occurence in an array

/*
    Brute Force : Use HashMap
    Optimized(expected) : Bit manipulation <=(solved)
        -> Suppose ans= {a,b},  xor all numbers
           As there are only two odd numbers, xorVal = a^b (after xor of all numbers)
        -> Extract the two odd numbers from xorVal
           Hint : two numbers differs at 'right most set bit' (n & -n, number with right most set bit)
        -> compare num[i] with (number with right most set bit)
           if bit is not set , it belongs to first number i.e, a
           else it belongs to second number i.e, b
*/
public class OddOccurence {
    static int[] twoOddNum(int [] Arr)
    {
        int xor  = 0;

        for(int num : Arr){
            xor ^= num;
        }

        xor = xor & (-xor); //number with right most set bit
        int [] ans = {0,0};
        for(int num : Arr){
            //bit is not set
            if((num&xor)==0){
                ans[0] = ans[0]^num;
            }else{
                //bit is set
                ans[1] = ans[1]^num;
            }
        }

        //swap to make it in descending order
        if(ans[0]<ans[1]){
            int temp = ans[0];
            ans[0] = ans[1];
            ans[1] = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = {4, 2, 4, 5, 2, 3, 3, 1}; //unsorted array
        System.out.println(Arrays.toString(arr));
        System.out.println("Number with odd occurence : "+Arrays.toString(twoOddNum(arr)));
    }
}
